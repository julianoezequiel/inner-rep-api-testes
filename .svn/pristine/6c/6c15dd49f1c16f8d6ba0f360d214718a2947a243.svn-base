package com.api.rep.dto.comandos;

import com.api.rep.entity.AjustesBio;

/**
 * Classe representa o Comando CONFIG_BIO
 * 
 * @author juliano.ezequiel
 *
 */
public class AjustesBioCmd implements Cmd {

	private static final long serialVersionUID = 1L;
	
	private Integer cfgBSegI;
	private Integer cfgBSegV;
	private Integer cfgBFL;
	private Integer cfgBCA;
	private Integer cfgBNLFD;
	private Integer cfgBTO;
	private Integer cfgBDD;

	public synchronized Integer getCfgBSegI() {
		return cfgBSegI;
	}

	public synchronized void setCfgBSegI(Integer cfgBSegI) {
		this.cfgBSegI = cfgBSegI;
	}

	public synchronized Integer getCfgBSegV() {
		return cfgBSegV;
	}

	public synchronized void setCfgBSegV(Integer cfgBSegV) {
		this.cfgBSegV = cfgBSegV;
	}

	public synchronized Integer getCfgBFL() {
		return cfgBFL;
	}

	public synchronized void setCfgBFL(Integer cfgBFL) {
		this.cfgBFL = cfgBFL;
	}

	public synchronized Integer getCfgBCA() {
		return cfgBCA;
	}

	public synchronized void setCfgBCA(Integer cfgBCA) {
		this.cfgBCA = cfgBCA;
	}

	public synchronized Integer getCfgBNLFD() {
		return cfgBNLFD;
	}

	public synchronized void setCfgBNLFD(Integer cfgBNLFD) {
		this.cfgBNLFD = cfgBNLFD;
	}

	public synchronized Integer getCfgBTO() {
		return cfgBTO;
	}

	public synchronized void setCfgBTO(Integer cfgBTO) {
		this.cfgBTO = cfgBTO;
	}

	public synchronized Integer getCfgBDD() {
		return cfgBDD;
	}

	public synchronized void setCfgBDD(Integer cfgBDD) {
		this.cfgBDD = cfgBDD;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public AjustesBio toAjustesBio() {
		AjustesBio ajustesBio = new AjustesBio();
		ajustesBio.setCapturaAdaptiva(cfgBCA);
		ajustesBio.setDedoDuplicado(cfgBDD);
		ajustesBio.setNivellfd(cfgBNLFD);
		ajustesBio.setSegurancaFiltroLatente(cfgBFL);
		ajustesBio.setSegurancaIdentificacao(cfgBSegI);
		ajustesBio.setSegurancaVerificacao(cfgBSegV);
		ajustesBio.setTimeout(cfgBTO);
		return ajustesBio;
	}

}
