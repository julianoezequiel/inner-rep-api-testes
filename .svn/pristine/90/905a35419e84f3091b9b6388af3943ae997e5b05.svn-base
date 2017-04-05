package com.api.rep.dto.comunicacao;

/**
 * Classe de envio do Token de autenticação para o Rep. Também é enviado a chave
 * de comunicação cadastrada para o Rep. O Rep utiliza a chave de comunucação
 * para realizar uma validação de segurança no Rep.
 * 
 * @author juliano.ezequiel
 *
 */
public class TokenDTO {

	private String token;
	private String chaveComunicacao;

	public TokenDTO(String token) {
		this.token = token;
	}

	public TokenDTO(String token, String chaveComunicacao) {
		this.token = token;
		this.chaveComunicacao = chaveComunicacao;
	}

	public TokenDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public String getChaveComunicacao() {
		return chaveComunicacao;
	}

	public void setChaveComunicacao(String chaveComunicacao) {
		this.chaveComunicacao = chaveComunicacao;
	}

}
