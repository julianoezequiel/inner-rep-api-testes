package com.api.rep.service.cripto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.service.ServiceException;
import com.api.rep.utils.Utils;

/**
 * Efetua a parte da criptografia
 */
@Component
public class CriptoAES {

	public Integer[] criptoInt(Integer[] chaveAES, byte[] dados) throws ServiceException {
		return Utils.toArrayInt(cripto(chaveAES, dados));
	}

	public byte[] cripto(Integer[] chaveAES, byte[] dados) throws ServiceException {
		try {
			byte[] dadosCripto = null;

			ChaveAES objAES = new ChaveAES(chaveAES);

			Cipher aescf = Cipher.getInstance("AES/CBC/NoPadding");
			IvParameterSpec ivspec = new IvParameterSpec(objAES.getIv());
			SecretKeySpec keySpec = new SecretKeySpec(objAES.getKey(), "AES");
			aescf.init(Cipher.ENCRYPT_MODE, keySpec, ivspec);
			dadosCripto = aescf.doFinal(dados);

			return dadosCripto;
		} catch (Exception e) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, ("Erro ao criptografar dados"));
		}
	}

}
