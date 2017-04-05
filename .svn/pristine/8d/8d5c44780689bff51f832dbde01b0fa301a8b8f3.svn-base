package com.api.rep.dto.comunicacao;

/**
 * Sempre que o Rep enviar um POST de status, deverá conter este objeto
 * 
 * @author juliano.ezequiel
 *
 */
public class StatusDTO {

	private Integer ultimoNsr;
	private Integer config;

	public Integer getUltimoNsr() {
		return ultimoNsr;
	}

	public void setUltimoNsr(Integer ultimoNsr) {
		this.ultimoNsr = ultimoNsr;
	}

	public synchronized Integer getConfig() {
		return config;
	}

	public synchronized void setConfig(Integer config) {
		this.config = config;
	}

}
