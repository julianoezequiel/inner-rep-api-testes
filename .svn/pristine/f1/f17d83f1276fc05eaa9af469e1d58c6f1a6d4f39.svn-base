package com.api.rep.dto.comandos;

import com.api.rep.entity.ColetaDumping;

public class ColetaDumpCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer cDEndFim;
	private Integer cDEndIni;

	public synchronized Integer getcDEndFim() {
		return cDEndFim;
	}

	public synchronized void setcDEndFim(Integer cDEndFim) {
		this.cDEndFim = cDEndFim;
	}

	public synchronized Integer getcDEndIni() {
		return cDEndIni;
	}

	public synchronized void setcDEndIni(Integer cDEndIni) {
		this.cDEndIni = cDEndIni;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public ColetaDumping toColetaDumping() {
		ColetaDumping coletaDumping = new ColetaDumping();
		coletaDumping.setEnderecoFim(cDEndFim);
		coletaDumping.setEnderecoInicio(cDEndIni);
		return coletaDumping;
	}

}
