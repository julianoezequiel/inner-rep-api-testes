package com.api.rep.dto.comandos;

public class VerificacaoCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer verTipo;

	public synchronized Integer getVerTipo() {
		return verTipo;
	}

	public synchronized void setVerTipo(Integer verTipo) {
		this.verTipo = verTipo;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

}
