package com.api.rep.service.auth;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rep.dto.comunicacao.CriptoRnd;
import com.api.rep.dto.comunicacao.RepDTO;
import com.api.rep.dto.comunicacao.TokenDTO;
import com.api.rep.entity.Rep;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.api.rep.service.cripto.CriptoAES;
import com.api.rep.service.cripto.DecriptoRSA;
import com.api.rep.service.cripto.GeradorParChaves;
import com.api.rep.utils.JwtUtil;
import com.api.rep.utils.Utils;

/**
 * Classe responsável pela autenticação do Rep no servidor
 * 
 * @author juliano.ezequiel
 *
 */
@Service
public class AuthService extends ApiService {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private GeradorParChaves geradorParChaves;

	@Autowired
	private DecriptoRSA decriptoRSA;

	@Autowired
	private CriptoAES criptoAES;

	private String token;

	private HashMap<String, CriptoRnd> map = new HashMap<>();

	/**
	 * Metodo para autenticar e criar o Token de acesso para o Rep.
	 * 
	 * @param repDTO
	 * @return TokenDTO
	 * @throws ServiceException
	 * @throws InvalidAlgorithmParameterException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 */
	public TokenDTO autenticar(RepDTO repDTO) throws ServiceException {

		// TODO: validar a criptografia
		if (repDTO.getSign() == null || !map.containsKey(repDTO.getNumeroSerie())) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED);
		}

		LOGGER.info("Rep assinatura : " + repDTO.getSign());
		// Campo obrigatório
		if (repDTO == null || repDTO.getNumeroSerie() == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}

		if (repDTO.getChaveAes() == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Chave AES obrigatória");
		}

		// busca o rep na base
		Rep rep = this.getRepService().buscarPorNumeroSerie(repDTO.getNumeroSerie());

		if (rep != null) {
			token = jwtUtil.generateToken(rep.getNumeroSerie());
		} else {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}

		ApiService.LOGGER.info("Token criado : " + token);
		map.remove(repDTO.getNumeroSerie());
		ApiService.LOGGER.info("chave pública  : " + repDTO.getChavePublica());
		// salva a chave AES na base
		byte[] chaveAES = this.decriptoRSA.decript(rep.getChaveRSAPrivada(), repDTO.getChaveAes());
		rep.setChaveAES(Utils.toArrayInt(chaveAES));
		this.getRepService().salvar(rep);
		Integer[] tokenTemp = criptoAES.criptoInt(rep.getChaveAES(), Utils.stringToByteM16(token));
		Integer[] chaveCom = criptoAES.criptoInt(rep.getChaveAES(), Utils.stringToByteM16(rep.getChaveComunicacao()));

		TokenDTO tokenDTO = new TokenDTO(tokenTemp, chaveCom);
		// System.out.println("Token tamanho : " + tokenTemp.length);
		// System.out.println("chave comunicacao : " + chaveCom.length);

		return tokenDTO;
	}

	/**
	 * Gera o número aleatória para o Rep assinar
	 * 
	 * @param repDTO
	 * @return
	 * @throws ServiceException
	 */
	public CriptoRnd criptoRnd(RepDTO repDTO) throws ServiceException {
		if (repDTO.getNumeroSerie() == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}
		LOGGER.info("Rep número de Série : " + repDTO.getNumeroSerie());
		Rep rep = this.getRepService().buscarPorNumeroSerie(repDTO.getNumeroSerie());
		if (rep == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}
		CriptoRnd criptoRnd = new CriptoRnd();
		Random random = new Random();
		Long num = new Long(random.nextLong());
		LOGGER.info("Número randomico gerado pelo servidor : " + num.toString());
		criptoRnd.setInfoRnd(num.toString());
		map.put(repDTO.getNumeroSerie(), criptoRnd);

		// gera o par de chaves RSA
		geradorParChaves.geraParChaves(rep);
		this.getRepService().salvar(rep);
		criptoRnd.setModuloRsa(rep.getChaveRSAPublica());
		criptoRnd.setExpoenteRsa(rep.getExpoente());

		return criptoRnd;
	}

}
