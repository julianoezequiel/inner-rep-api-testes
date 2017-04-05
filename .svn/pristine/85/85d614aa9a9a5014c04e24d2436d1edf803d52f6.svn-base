package com.api.rep.dto.comunicacao;

import java.io.Serializable;

import com.api.rep.entity.Rep;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe representa o objeto Rep que se autentica no sistema
 * 
 * @author juliano.ezequiel
 *
 */
public class RepDTO implements Serializable {

	private static final long serialVersionUID = 6063659709331831136L;

	private Integer id;
	private String numeroSerie;
	private String chaveComunicacao;
	private String sign;
	private Integer[] chaveAes;
	private Integer[] moduloRsa;
	private String chavePublica;
	private Integer expoenteRsa;

	public RepDTO() {
	}

	public RepDTO(Rep rep) {
		this.chaveComunicacao = rep.getChaveComunicacao();
		this.numeroSerie = rep.getNumeroSerie();
		this.id = rep.getId();
		this.chaveAes = rep.getChaveAES();
		this.chavePublica = rep.getChavePublica();
		this.moduloRsa = rep.getChaveRSAPublica();
		this.expoenteRsa = rep.getExpoente();
	}

	public RepDTO(String numeroSerie, String chave) {
		this.chaveComunicacao = chave;
		this.numeroSerie = numeroSerie;
	}

	public RepDTO(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public String getChaveComunicacao() {
		return chaveComunicacao;
	}

	public Integer getId() {
		return id;
	}

	public synchronized String getSign() {
		return sign;
	}

	public synchronized void setSign(String sign) {
		this.sign = sign;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public synchronized void setId(Integer id) {
		this.id = id;
	}

	public synchronized void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public synchronized void setChaveComunicacao(String chaveComunicacao) {
		this.chaveComunicacao = chaveComunicacao;
	}

	@JsonIgnore
	public Rep getRep() {
		return new Rep(this.id, this.numeroSerie, this.chaveComunicacao);
	}

	public Integer[] getChaveAes() {
		return chaveAes;
	}

	public void setChaveAes(Integer[] chaveAES) {
		this.chaveAes = chaveAES;
	}

	public Integer[] getModuloRsa() {
		return moduloRsa;
	}

	public void setModuloRsa(Integer[] chaveRSA) {
		this.moduloRsa = chaveRSA;
	}

	public String getChavePublica() {
		return chavePublica;
	}

	public void setChavePublica(String chavePublica) {
		this.chavePublica = chavePublica;
	}

	public Integer getExpoenteRsa() {
		return expoenteRsa;
	}

	public void setExpoenteRsa(Integer expoente) {
		this.expoenteRsa = expoente;
	}

}
