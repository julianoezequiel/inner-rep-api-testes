package com.api.rep.service.cripto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.service.ServiceException;

/**
 * Decifra os dados criptografados pelo Rep
 * 
 * @author juliano.ezequiel
 *
 */
@Component
public class DecriptoAES {

	public byte[] decript(Integer[] chaveAES, byte[] dadosCripto) throws ServiceException {
		byte[] textoDecifrado = null;
		try {
			if (chaveAES == null) {
				throw new ServiceException(HttpStatus.UNAUTHORIZED);
			}
			ChaveAES objAES = new ChaveAES(chaveAES);

			Cipher aescf = Cipher.getInstance("AES/CBC/NoPadding");

			IvParameterSpec ivspec = new IvParameterSpec(objAES.getIv());
			SecretKeySpec keySpec = new SecretKeySpec(objAES.getKey(), "AES");
			aescf.init(Cipher.DECRYPT_MODE, keySpec, ivspec);
			textoDecifrado = aescf.doFinal(dadosCripto);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			throw new ServiceException(HttpStatus.UNAUTHORIZED, ("Erro ao realizar a descriptografia AES"));
		}
		return textoDecifrado;
	}
}
