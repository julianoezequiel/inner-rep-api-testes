package com.api.rep.dto.comandos;

import com.api.rep.entity.Identificadores;

public class IdentificadoresCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private String idVerApl;
	private String idApl;
	private String idVerMrp;
	private String idMrp;
	private String idVerTp;
	private String idVerBoot;
	private String idVerBio;
	private String idVerProx;
	private String idVerImp;
	private String idChPub;

	public synchronized String getIdVerApl() {
		return idVerApl;
	}

	public synchronized void setIdVerApl(String idVerApl) {
		this.idVerApl = idVerApl;
	}

	public synchronized String getIdApl() {
		return idApl;
	}

	public synchronized void setIdApl(String idIdApl) {
		this.idApl = idIdApl;
	}

	public synchronized String getIdVerMrp() {
		return idVerMrp;
	}

	public synchronized void setIdVerMrp(String idVerMrp) {
		this.idVerMrp = idVerMrp;
	}

	public synchronized String getIdMrp() {
		return idMrp;
	}

	public synchronized void setIdMrp(String idMrp) {
		this.idMrp = idMrp;
	}

	public synchronized String getIdVerTp() {
		return idVerTp;
	}

	public synchronized void setIdVerTp(String idVerTp) {
		this.idVerTp = idVerTp;
	}

	public synchronized String getIdVerBoot() {
		return idVerBoot;
	}

	public synchronized void setIdVerBoot(String idVerBoot) {
		this.idVerBoot = idVerBoot;
	}

	public synchronized String getIdVerBio() {
		return idVerBio;
	}

	public synchronized void setIdVerBio(String idVerBio) {
		this.idVerBio = idVerBio;
	}

	public synchronized String getIdVerProx() {
		return idVerProx;
	}

	public synchronized void setIdVerProx(String idVerProx) {
		this.idVerProx = idVerProx;
	}

	public synchronized String getIdVerImp() {
		return idVerImp;
	}

	public synchronized void setIdVerImp(String idVerImp) {
		this.idVerImp = idVerImp;
	}

	public synchronized String getIdChPub() {
		return idChPub;
	}

	public synchronized void setIdChPub(String idChPub) {
		this.idChPub = idChPub;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public Identificadores toIdentificadores() {
		Identificadores identificadores = new Identificadores();
		identificadores.setChavePublica(this.idChPub);
		identificadores.setIdApr(this.idApl);
		identificadores.setIdMrp(this.idMrp);
		identificadores.setVersaoApl(this.idVerApl);
		identificadores.setVersaoBio(this.idVerBio);
		identificadores.setVersaoBoot(this.idVerBoot);
		identificadores.setVersaoImp(this.idVerImp);
		identificadores.setVersaoMrp(this.idVerMrp);
		identificadores.setVersaoProx(this.idVerProx);
		identificadores.setVersaoTamper(this.idVerTp);

		return identificadores;
	}

}
