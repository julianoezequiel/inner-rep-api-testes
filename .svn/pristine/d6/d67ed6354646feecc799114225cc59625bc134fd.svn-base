package com.api.rep.service.cripto;

public class ChaveAES {

	private final byte[] key;
	private final byte[] iv;
	private final byte[] chaveCompleta;

	public ChaveAES() {
		key = new byte[16];
		iv = new byte[16];
		chaveCompleta = new byte[32];
	}

	public ChaveAES(char[] raw) {
		byte[] buf = LowLevel.getBytes(raw);
		key = LowLevel.copyBuf(buf, 0, 16);
		iv = LowLevel.copyBuf(buf, 16, 16);
		chaveCompleta = new byte[0];
	}

	public ChaveAES(byte[] raw) {
		key = LowLevel.copyBuf(raw, 0, 16);
		iv = LowLevel.copyBuf(raw, 16, 16);
		chaveCompleta = raw;
	}

	public ChaveAES(Integer[] chaveAES) {
		byte[] chaveAESTemp = new byte[chaveAES.length];
		for (int i = 0; i < chaveAES.length; i++) {
			chaveAESTemp[i] = (byte) chaveAES[i].intValue();
		}
		key = LowLevel.copyBuf(chaveAESTemp, 0, 16);
		iv = LowLevel.copyBuf(chaveAESTemp, 16, 16);
		chaveCompleta = chaveAESTemp;
	}

	public byte[] getKey() {
		return key;
	}

	public byte[] getIv() {
		return iv;
	}

	// Neste ponto a chave aes descriptografada
	public byte[] getChaveCompleta() {
		return chaveCompleta;
	}

}
