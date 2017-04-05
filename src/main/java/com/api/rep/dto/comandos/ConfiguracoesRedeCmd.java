package com.api.rep.dto.comandos;

import com.api.rep.entity.ConfiguracoesRede;

public class ConfiguracoesRedeCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer[] cfgRIpRep;
	private Integer cfgRDhcp;
	private Integer cfgRPortRep;
	private Integer[] cfgRNumMac;
	private String cfgRNRep;
	private Integer cfgRRepIn;
	private Integer[] cfgRIpServ;
	private Integer cfgRPortServ;
	private Integer[] cfgRMasc;
	private Integer[] cfgRGat;
	private Integer cfgRIntCom;
	private Integer cfgRTpDns;
	private String cfgRNHost;
	private Integer[] cfgRIpDns;
	private Integer cfgRNInt;

	public synchronized Integer[] getCfgRIpRep() {
		return cfgRIpRep;
	}

	public synchronized void setCfgRIpRep(Integer[] cfgRIpRep) {
		this.cfgRIpRep = cfgRIpRep;
	}

	public synchronized Integer getCfgRDhcp() {
		return cfgRDhcp;
	}

	public synchronized void setCfgRDhcp(Integer cfgRDhcp) {
		this.cfgRDhcp = cfgRDhcp;
	}

	public synchronized Integer getCfgRPortRep() {
		return cfgRPortRep;
	}

	public synchronized void setCfgRPortRep(Integer cfgRPortRep) {
		this.cfgRPortRep = cfgRPortRep;
	}

	public synchronized Integer[] getCfgRNumMac() {
		return cfgRNumMac;
	}

	public synchronized void setCfgRNumMac(Integer[] cfgRNumMac) {
		this.cfgRNumMac = cfgRNumMac;
	}

	public synchronized String getCfgRNRep() {
		return cfgRNRep;
	}

	public synchronized void setCfgRNRep(String cfgRNRep) {
		this.cfgRNRep = cfgRNRep;
	}

	public synchronized Integer getCfgRRepIn() {
		return cfgRRepIn;
	}

	public synchronized void setCfgRRepIn(Integer cfgRRepIn) {
		this.cfgRRepIn = cfgRRepIn;
	}

	public synchronized Integer[] getCfgRIpServ() {
		return cfgRIpServ;
	}

	public synchronized void setCfgRIpServ(Integer[] cfgRIpServ) {
		this.cfgRIpServ = cfgRIpServ;
	}

	public synchronized Integer getCfgRPortServ() {
		return cfgRPortServ;
	}

	public synchronized void setCfgRPortServ(Integer cfgRPortServ) {
		this.cfgRPortServ = cfgRPortServ;
	}

	public synchronized Integer[] getCfgRMasc() {
		return cfgRMasc;
	}

	public synchronized void setCfgRMasc(Integer[] cfgRMasc) {
		this.cfgRMasc = cfgRMasc;
	}

	public synchronized Integer[] getCfgRGat() {
		return cfgRGat;
	}

	public synchronized void setCfgRGat(Integer[] cfgRGat) {
		this.cfgRGat = cfgRGat;
	}

	public synchronized Integer getCfgRIntCom() {
		return cfgRIntCom;
	}

	public synchronized void setCfgRIntCom(Integer cfgRIntCom) {
		this.cfgRIntCom = cfgRIntCom;
	}

	public synchronized String getCfgRNHost() {
		return cfgRNHost;
	}

	public synchronized void setCfgRNHost(String cfgRNHost) {
		this.cfgRNHost = cfgRNHost;
	}

	public synchronized Integer[] getCfgRIpDns() {
		return cfgRIpDns;
	}

	public synchronized void setCfgRIpDns(Integer[] cfgRIpDns) {
		this.cfgRIpDns = cfgRIpDns;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	public synchronized Integer getCfgRTpDns() {
		return cfgRTpDns;
	}

	public synchronized void setCfgRTpDns(Integer cfgRTpDns) {
		this.cfgRTpDns = cfgRTpDns;
	}

	public synchronized Integer getCfgRNInt() {
		return cfgRNInt;
	}

	public synchronized void setCfgRNInt(Integer cfgRNInt) {
		this.cfgRNInt = cfgRNInt;
	}

	public ConfiguracoesRede toConfiguracoesRede() {
		ConfiguracoesRede configuracoesRede = new ConfiguracoesRede();
		configuracoesRede.setGateway(this.cfgRGat);
		configuracoesRede.setHabilitaDhcp(this.cfgRDhcp);
		configuracoesRede.setTipoDns(this.cfgRTpDns);
		configuracoesRede.setIntervaloCom(this.cfgRIntCom);
		configuracoesRede.setIpDns(this.cfgRIpDns);
		configuracoesRede.setIpRep(this.cfgRIpRep);
		configuracoesRede.setIpServidor(this.cfgRIpServ);
		configuracoesRede.setMascaraRede(this.cfgRMasc);
		configuracoesRede.setNomeHost(this.cfgRNHost);
		configuracoesRede.setNomeRep(this.cfgRNRep);
		configuracoesRede.setNumeroMac(this.cfgRNumMac);
		configuracoesRede.setPortaRep(this.cfgRPortRep);
		configuracoesRede.setPortaServidor(this.cfgRPortServ);
		configuracoesRede.setRepInicia(this.cfgRRepIn);
		configuracoesRede.setIntervaloComunicacaoNuvem(this.cfgRNInt);

		return configuracoesRede;
	}

}
