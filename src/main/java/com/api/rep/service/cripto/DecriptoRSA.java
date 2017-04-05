package com.api.rep.service.cripto;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.service.ServiceException;

/**
 * Efetua a parte da decifração
 */
@Component
public class DecriptoRSA {

	/**
	 * Decifra a chave AES recebida do Rep
	 * 
	 * @throws InvalidKeySpecException
	 */
	public byte[] decript(byte[] chaveRSAPrivada, Integer[] chaveAESCripto) throws ServiceException {

		byte[] chaveDecifrada = null;
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(chaveRSAPrivada));

			byte[] chaveCifradaByte = new byte[chaveAESCripto.length];
			for (int i = 0; i < chaveAESCripto.length; i++) {
				chaveCifradaByte[i] = (byte) chaveAESCripto[i].intValue();
			}

			Cipher rsacf = Cipher.getInstance("RSA");
			rsacf.init(Cipher.DECRYPT_MODE, privateKey);

			chaveDecifrada = rsacf.doFinal(chaveCifradaByte);

		} catch (Exception e) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, ("Erro ao realizar a decriptografia RSA"));
		}
		return chaveDecifrada;
	}
}
