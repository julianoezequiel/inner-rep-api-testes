package com.api.rep.dto.comandos;

import com.api.rep.entity.Empregador;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe representa o comando EMPREGADOR
 *
 * 
 * @author juliano.ezequiel
 *
 */
@JsonPropertyOrder(value = {"eTpId", "eId","eCei"})
public class EmpregadorCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	/**
	 * EMPREGADOR_RAZAO
	 */
	private String eRS;

	/**
	 * EMPREGADOR_IDENT
	 */
	private String eId;

	/**
	 * EMPREGADOR_CEI
	 */
	private String eCei;

	/**
	 * EMPREGADOR_LOCAL
	 */
	private String eLoc;

	/**
	 * EMPREGADOR_TIPO_IDENT
	 */
	private String eTpId;

	public String geteId() {
		return eId;
	}

	public void seteId(String empregadorIdent) {
		this.eId = empregadorIdent;
	}

	public String geteCei() {
		return eCei;
	}

	public void seteCei(String empregadorCei) {
		this.eCei = empregadorCei;
	}

	public String geteLoc() {
		return eLoc;
	}

	public void seteLoc(String empregadorLocal) {
		this.eLoc = empregadorLocal;
	}

	public String geteRS() {
		return eRS;
	}

	public void seteRS(String empregadorRazao) {
		this.eRS = empregadorRazao;
	}

	public String geteTpId() {
		return eTpId;
	}

	public void seteTpId(String empregadorTipoIdent) {
		this.eTpId = empregadorTipoIdent;
	}

	public Empregador toEmpregador() {
		Empregador empregador = new Empregador();
		empregador.setEmpregadorCei(eCei);
		empregador.setEmpregadorIdent(eId);
		empregador.setEmpregadorLocal(eLoc);
		empregador.setEmpregadorRazao(eRS);
		empregador.setEmpregadorTipoIdent(eTpId);

		return empregador;

	}

}
