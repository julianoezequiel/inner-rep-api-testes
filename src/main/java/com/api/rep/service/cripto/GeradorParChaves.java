package com.api.rep.service.cripto;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.entity.Rep;
import com.api.rep.service.ServiceException;
import com.api.rep.utils.Utils;

/**
 * Gera um par de chaves e as guarda em formato serializado. (não é o formato
 * mais seguro - seria melhor usar um keystore, que pode ser protegido por
 * senha), mas faço isto para simplificar a compreensão.
 */
@Component
public class GeradorParChaves {

	private static final int RSAKEYSIZE = 1024;
	public final static Logger LOGGER = LoggerFactory.getLogger(GeradorParChaves.class.getName());

	/**
	 * Gera um par de chaves e as guarda em formato serializado em arquivos.
	 */
	public void geraParChaves(Rep rep) throws ServiceException {

		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

			kpg.initialize(RSAKEYSIZE);
			KeyPair kpr = kpg.generateKeyPair();

			RSAPrivateKey privateKey = (RSAPrivateKey) kpr.getPrivate();
			RSAPublicKey publicKey = (RSAPublicKey) kpr.getPublic();

			byte[] chavePublicaByte = publicKey.getModulus().toByteArray();
			Integer[] chavePublica = new Integer[chavePublicaByte.length - 1];
			for (int i = 1; i < chavePublicaByte.length; i++) {
				chavePublica[i - 1] = Utils.ConvertToDecValor(chavePublicaByte[i]);
			}

			BigInteger ex = publicKey.getPublicExponent();

			rep.setChaveRSAPrivada(privateKey.getEncoded());
			rep.setExpoente(ex.intValue());
			rep.setChaveRSAPublica(chavePublica);

			LOGGER.info("Chave Pub RSA : " + Arrays.toString(rep.getChaveRSAPublica()));
		} catch (Exception e) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, ("Erro ao criar chaves RSA"));
		}
	}

	// public static void main(String[] args) {
	// KeyPairGenerator kpg;
	// try {
	// kpg = KeyPairGenerator.getInstance("RSA");
	//
	// kpg.initialize(1024);
	//
	// KeyPair kpr = kpg.generateKeyPair();
	//
	// RSAPrivateKey privateKey = (RSAPrivateKey) kpr.getPrivate();
	// RSAPublicKey publicKey = (RSAPublicKey) kpr.getPublic();
	//
	// byte[] aes = new byte[32];
	// for (int i = 0; i < 32; i++) {
	// aes[i] = (byte) i;
	// }
	//
	// byte[] aesCripto = cifra(publicKey, aes);
	//
	// byte[] chaveByte = publicKey.getModulus().toByteArray();
	//
	// BigInteger expo = publicKey.getPublicExponent();
	//
	// String s = publicKey.getModulus().toString();
	//
	// System.out.println(s);
	//
	// byte[] expoB = expo.toString().getBytes();
	// byte[] modulosExpoente = new byte[134];
	//
	// System.arraycopy(chaveByte, 1, modulosExpoente, 0, chaveByte.length - 1);
	// System.arraycopy(expoB, 0, modulosExpoente, 127, expoB.length);
	//
	// byte[] aesDescript = decifra(chaveByte, aesCripto);
	//
	// System.out.println(aesDescript);
	//
	// } catch (NoSuchAlgorithmException | InvalidKeyException |
	// NoSuchPaddingException | IllegalBlockSizeException
	// | BadPaddingException | InvalidAlgorithmParameterException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public static byte[] decifra(byte[] chaveByte, byte[] chaveAESCripto) {
	//
	// byte[] chaveDecifrada = null;
	// try {
	// KeyFactory kf = KeyFactory.getInstance("RSA");
	// PrivateKey privateKey = kf.generatePrivate(new
	// PKCS8EncodedKeySpec(chaveByte));
	//
	// Cipher rsacf = Cipher.getInstance("RSA");
	// rsacf.init(Cipher.DECRYPT_MODE, privateKey);
	//
	// chaveDecifrada = rsacf.doFinal(chaveAESCripto);
	//
	// } catch (Exception e) {
	// System.out.println(e);
	// }
	// return chaveDecifrada;
	// }
	//
	// public static byte[] cifra(PublicKey pub, byte[] textoClaro)
	// throws NoSuchAlgorithmException, NoSuchPaddingException,
	// InvalidKeyException, IllegalBlockSizeException,
	// BadPaddingException, InvalidAlgorithmParameterException {
	// byte[] textoCifrado = null;
	// byte[] chaveCifrada = null;
	//
	// // // -- A) Gerando uma chave simétrica de 128 bits
	// // KeyGenerator kg = KeyGenerator.getInstance("AES");
	// // kg.init(128);
	// // SecretKey sk = kg.generateKey();
	// // byte[] chave = sk.getEncoded();
	// // // -- B) Cifrando o texto com a chave simétrica gerada
	// // Cipher aescf = Cipher.getInstance("AES/CBC/NoPadding");
	// // IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
	// // aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"),
	// // ivspec);
	// // textoCifrado = aescf.doFinal(textoClaro);
	//
	// // // -- C) Cifrando a chave com a chave pública
	// Cipher rsacf = Cipher.getInstance("RSA");
	// rsacf.init(Cipher.ENCRYPT_MODE, pub);
	// chaveCifrada = rsacf.doFinal(textoClaro);
	//
	// return chaveCifrada;
	// }

}
