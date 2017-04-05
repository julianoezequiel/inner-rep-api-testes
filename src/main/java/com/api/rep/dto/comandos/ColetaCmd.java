package com.api.rep.dto.comandos;

import com.api.rep.entity.Coleta;

/**
 * Classe do comando de ColetaCmd, as propriedades devem seguir
 * exatamente os nomes aqui atribuidos.
 * 
 * @author juliano.ezequiel
 *
 */
public class ColetaCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer cNsrI;
	private Integer cNsrF;
	private String cDtI;
	private String cDtF;

	public synchronized Integer getcNsrI() {
		return cNsrI;
	}

	public synchronized void setcNsrI(Integer coletaNsrInicio) {
		this.cNsrI = coletaNsrInicio;
	}

	public synchronized Integer getcNsrF() {
		return cNsrF;
	}

	public synchronized void setcNsrF(Integer coletaNsrFim) {
		this.cNsrF = coletaNsrFim;
	}

	public synchronized String getcDtI() {
		return cDtI;
	}

	public synchronized void setcDtI(String coletaDataInicio) {
		this.cDtI = coletaDataInicio;
	}

	public synchronized String getcDtF() {
		return cDtF;
	}

	public synchronized void setcDtF(String coletaDataFim) {
		this.cDtF = coletaDataFim;
	}

	public Coleta toColeta() {
		Coleta coleta = new Coleta();
		coleta.setColetaDataFim(cDtF);
		coleta.setColetaDataInicio(cDtI);
		coleta.setColetaNsrFim(cNsrF);
		coleta.setColetaNsrInicio(cNsrI);
		return coleta;
	}
}
