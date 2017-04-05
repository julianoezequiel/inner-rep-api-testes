package com.api.rep.dto.comandos;

import com.api.rep.entity.Info;

public class InfoCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private String infNProd;
	private String infMProd;
	private String infNumRep;
	private String infStatRep;
	private String infVerApl;
	private String infVerMrp;
	private String infNumFunc;
	private String infNumUsuBio;
	private String infNumBio;
	private String infNsr;
	private String infTpBio;
	private String infMBio;
	private String infCpBio;
	private String infStatImp;

	public String getInfNProd() {
		return infNProd;
	}

	public void setInfNProd(String infNProd) {
		this.infNProd = infNProd;
	}

	public String getInfMProd() {
		return infMProd;
	}

	public void setInfMProd(String infMProd) {
		this.infMProd = infMProd;
	}

	public String getInfNumRep() {
		return infNumRep;
	}

	public void setInfNumRep(String infNumRep) {
		this.infNumRep = infNumRep;
	}

	public String getInfVerApl() {
		return infVerApl;
	}

	public void setInfVerApl(String infVerApl) {
		this.infVerApl = infVerApl;
	}

	public String getInfVerMrp() {
		return infVerMrp;
	}

	public void setInfVerMrp(String infVerMrp) {
		this.infVerMrp = infVerMrp;
	}

	public String getInfNumFunc() {
		return infNumFunc;
	}

	public void setInfNumFunc(String infNumFunc) {
		this.infNumFunc = infNumFunc;
	}

	public String getInfNumBio() {
		return infNumBio;
	}

	public void setInfNumBio(String infNumBio) {
		this.infNumBio = infNumBio;
	}

	public String getInfNsr() {
		return infNsr;
	}

	public void setInfNsr(String infNsr) {
		this.infNsr = infNsr;
	}

	public String getInfTpBio() {
		return infTpBio;
	}

	public void setInfTpBio(String infTpBio) {
		this.infTpBio = infTpBio;
	}

	public String getInfMBio() {
		return infMBio;
	}

	public void setInfMBio(String infMBio) {
		this.infMBio = infMBio;
	}

	public String getInfCpBio() {
		return infCpBio;
	}

	public void setInfCpBio(String infCpBio) {
		this.infCpBio = infCpBio;
	}

	public String getInfStatImp() {
		return infStatImp;
	}

	public void setInfStatImp(String infStatImp) {
		this.infStatImp = infStatImp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public synchronized String getInfStatRep() {
		return infStatRep;
	}

	public synchronized void setInfStatRep(String infStatRep) {
		this.infStatRep = infStatRep;
	}

	public synchronized String getInfNumUsuBio() {
		return infNumUsuBio;
	}

	public synchronized void setInfNumUsuBio(String infNumUsuBio) {
		this.infNumUsuBio = infNumUsuBio;
	}

	public Info toInfo() {

		Info info = new Info();

		info.setCapacidadeBio(this.infCpBio != null && this.infCpBio != "" ? Integer.parseInt(this.infCpBio) : 0);
		info.setModeloBio(this.infMBio);
		info.setModeloProduto(this.infMProd);
		info.setNomeProduto(this.infNProd);
		info.setNumeroRep(this.infNumRep);
		info.setNumeroUsuario(this.infNumFunc != null && this.infNumFunc != "" ? Integer.parseInt(this.infNumFunc) : 0);
		info.setNumeroUsuarioBio(this.infNumBio != null && this.infNumBio != "" ? Integer.parseInt(this.infNumBio) : 0);
		info.setStatusBloqueio(
				this.infStatRep != null && this.infStatRep != "" ? Integer.parseInt(this.infStatRep) : 0);
		info.setStatusImpressora(this.infStatImp);
		info.setTipoBio(this.infTpBio);
		info.setUltimoNsr(this.infNsr);
		info.setVersaoApl(this.infVerApl);
		info.setVersaoMrp(this.infVerMrp);
		info.setNumeroBiometrias(this.infNumBio != null && this.infNumBio != "" ? Integer.parseInt(this.infNumBio) : 0);
		return info;
	}

}
