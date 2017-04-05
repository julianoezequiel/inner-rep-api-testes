package com.api.rep.service.cripto;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class LowLevel {

	public static char[] getChars(byte[] bytes) {
		Charset cs = Charset.forName("ISO-8859-1");
		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.put(bytes);
		bb.flip();
		CharBuffer cb = cs.decode(bb);
		return cb.array();
	}

	public static byte[] getBytes(char[] chars) {
		Charset cs = Charset.forName("ISO-8859-1");
		CharBuffer cb = CharBuffer.allocate(chars.length);
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = cs.encode(cb);
		return bb.array();
	}

	public static byte[] getBytes(String chars) {
		Charset cs = Charset.forName("ISO-8859-1");
		CharBuffer cb = CharBuffer.allocate(chars.length());
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = cs.encode(cb);
		return bb.array();
	}

	public static char[] copyBuf(char[] buf, int start, int size) {
		char[] data = new char[size];
		System.arraycopy(buf, start, data, 0, size);
		return data;
	}

	public static char[] copyBuf(char[] buf, int start) {
		int size = buf.length - start;
		char[] data = new char[size];
		System.arraycopy(buf, start, data, 0, size);
		return data;
	}

	public static Object[] copyBuf(Object[] buf, int start, int size) {
		Object[] data = new Object[size];
		System.arraycopy(buf, start, data, 0, size);
		return data;
	}

	public static byte[] copyBuf(byte[] buf, int start) {
		int size = buf.length - start;
		byte[] data = new byte[size];
		System.arraycopy(buf, start, data, 0, size);
		return data;
	}

	public static byte[] copyBuf(byte[] buf, int start, int size) {
		byte[] data = new byte[size];
		System.arraycopy(buf, start, data, 0, size);
		return data;
	}

	public static char[] stringToChar(String buf) {
		char[] data = new char[buf.length()];
		for (int i = 0; i < data.length; i++) {
			data[i] = buf.charAt(i);
		}
		return data;
	}

	public static String charToString(char[] buf) {
		return String.valueOf(buf);
	}

	public static String sprintBuffer(char[] buf) {
		String linha = "";
		if (buf.length > 0) {
			for (int i = 0; i < buf.length; i++) {
				if (i > 0 && i % 16 == 0) {
					linha += "\n";
				}
				String hex = Integer.toHexString(buf[i]);
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				linha += " 0x" + hex.toUpperCase();
			}
		}
		return linha;
	}

	public static void printBuffer(char[] buf) {
		String linha = sprintBuffer(buf);
		System.out.println(linha);
	}

	public static String sprintAscii(char[] buf, int linelimit) {
		String texto = "";
		String linha = "";
		for (int i = 0; i < buf.length; i++) {
			if (buf[i] >= 32 & buf[i] <= 126) { // imprimiveis
				linha += String.valueOf(buf[i]);
			} else {
				linha += " ";
			}
			if (linelimit > 0) {
				if (linha.length() >= linelimit) {
					texto += linha + "\n";
					linha = "";
				}
			}
		}
		texto += linha;
		return texto;
	}

	public static String sprintAscii(char[] buf) {
		return sprintAscii(buf, 0);
	}

	public static void printAscii(char[] buf) {
		String linha = sprintAscii(buf);
		System.out.println(linha);
	}

	/**
	 * Use merge
	 */
	@Deprecated
	public static char[] concatBuffer(char[]... bufs) {
		char[] buf1 = {};
		for (char[] buf2 : bufs) {
			char[] data = new char[buf1.length + buf2.length];
			System.arraycopy(buf1, 0, data, 0, buf1.length);
			System.arraycopy(buf2, 0, data, buf1.length, buf2.length);
			buf1 = data;
		}
		return buf1;
	}

	public static char[] merge(char[]... bufs) {
		char[] buf1 = {};
		for (char[] buf2 : bufs) {
			char[] data = new char[buf1.length + buf2.length];
			System.arraycopy(buf1, 0, data, 0, buf1.length);
			System.arraycopy(buf2, 0, data, buf1.length, buf2.length);
			buf1 = data;
		}
		return buf1;
	}

	public static int word(char msb, char lsb) {
		return (msb ^ (lsb << 8));
	}

	public static char msb(int quantity) {
		return (char) ((quantity & 0xff00) >> 8);
	}

	public static char lsb(int quantity) {
		return (char) (quantity & 0x00ff);
	}

	public static char[] concat(char[] buf1, char aByte) {
		char[] buf = new char[1];
		buf[0] = aByte;
		return concatBuffer(buf1, buf);
	}

	public static int hexToInt(String hexa) {
		if (hexa.contains("0x")) {
			hexa = hexa.replace("0x", "");
		}
		int valor = Integer.parseInt(hexa, 16);
		return valor;
	}

	public static char hexToChar(String hexa) {
		return (char) hexToInt(hexa.trim());
	}

	public static char[] bcdToHex(String valor) {
		char[] hex = new char[valor.length() / 2];
		for (int i = 0; i < valor.length(); i += 2) {
			hex[i / 2] = hexToChar(valor.substring(i, i + 2));
		}
		return hex;
	}

	public static boolean compareBuffer(char[] buf1, char[] buf2) {
		if (buf1.length != buf2.length) {
			return false;
		}
		for (int i = 0; i < buf1.length; i++) {
			if (buf1[i] != buf2[i]) {
				return false;
			}
		}
		return true;
	}

}
