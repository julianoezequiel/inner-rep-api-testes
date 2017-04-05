package com.api.rep.dto.comunicacao;

import com.api.rep.dto.comandos.Cmd;

/**
 * Classe de envio do Token de autenticação para o Rep. Também é enviado a chave
 * de comunicação cadastrada para o Rep. O Rep utiliza a chave de comunucação
 * para realizar uma validação de segurança no Rep.
 * 
 * @author juliano.ezequiel
 *
 */
public class TokenDTO implements Cmd {

	private static final long serialVersionUID = 1L;
	private Integer[] token;
	private Integer[] chaveComunicacao;

	public TokenDTO(Integer[] token, Integer[] chaveComunicacao) {
		this.token = token;
		this.chaveComunicacao = chaveComunicacao;
	}

	public TokenDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer[] getToken() {
		return token;
	}

	public Integer[] getChaveComunicacao() {
		return chaveComunicacao;
	}

	public void setChaveComunicacao(Integer[] chaveComunicacao) {
		this.chaveComunicacao = chaveComunicacao;
	}

	public static byte[] stringToByte(String entrada) {
		byte[] retorno = new byte[256];
		for (int i = 0; i < entrada.length(); i++) {
			retorno[i] = (byte) entrada.charAt(i);
		}
		return retorno;
	}

}
