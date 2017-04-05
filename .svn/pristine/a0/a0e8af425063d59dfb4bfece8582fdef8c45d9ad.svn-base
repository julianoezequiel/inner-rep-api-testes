package com.api.rep.dto.comandos;

import com.api.rep.entity.UsuarioBio;

public class UsuarioBioCmd implements Cmd {

	private static final long serialVersionUID = 1L;
	private String fPis;

	public String getfPis() {
		return fPis;
	}

	public void setfPis(String pis) {
		this.fPis = pis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsuarioBio toUsuarioBio() {
		UsuarioBio usuarioBio = new UsuarioBio();
		usuarioBio.setPis(fPis);
		return usuarioBio;
	}

}
