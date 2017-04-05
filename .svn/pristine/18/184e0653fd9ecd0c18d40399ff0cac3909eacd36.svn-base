package com.api.rep.rest.auth;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comunicacao.CriptoRnd;
import com.api.rep.dto.comunicacao.RepDTO;
import com.api.rep.dto.comunicacao.TokenDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.auth.AuthService;

@RestController
public class AuthRestController extends ApiRestController {

	@Autowired
	private AuthService authService;

	/**
	 * Método para autenticação do Rep. O Rep deve enviar um o objeto<RepDTO>
	 * contendo o número de série
	 * 
	 * @param repDTO
	 * @return {@link TokenDTO}
	 * @throws ServiceException
	 * @throws InvalidKeySpecException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@RequestMapping(value = CONSTANTES.URL_AUTH_SIGN, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> autenticar(@RequestBody RepDTO repDTO) throws ServiceException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		return new ResponseEntity<TokenDTO>(this.authService.autenticar(repDTO), HttpStatus.CREATED);
	}

	@RequestMapping(value = CONSTANTES.URL_AUTH, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<CriptoRnd> criptoRnd(@RequestBody RepDTO repDTO) throws ServiceException {
		return new ResponseEntity<CriptoRnd>(this.authService.criptoRnd(repDTO), HttpStatus.CREATED);
	}

}
