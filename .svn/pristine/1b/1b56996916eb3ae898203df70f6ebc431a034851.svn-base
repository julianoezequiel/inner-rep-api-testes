package com.api.rep.dto.comandos;

import com.api.rep.entity.ConfiguracoesWebServer;

public class ConfiguracacoesWebServerCmd implements Cmd {

	private static final long serialVersionUID = 1L;

	private Integer cfgWTpCfg;
	private Integer[] cfgWIPS;
	private Integer cfgWP80;
	

	public synchronized Integer getCfgWTpCfg() {
		return cfgWTpCfg;
	}

	public synchronized void setCfgWTpCfg(Integer cfgWTpCfg) {
		this.cfgWTpCfg = cfgWTpCfg;
	}

	public synchronized Integer[] getCfgWIPS() {
		return cfgWIPS;
	}

	public synchronized void setCfgWIPS(Integer[] cfgWIPS) {
		this.cfgWIPS = cfgWIPS;
	}

	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	public synchronized Integer getCfgWP80() {
		return cfgWP80;
	}

	public synchronized void setCfgWP80(Integer cfgWP80) {
		this.cfgWP80 = cfgWP80;
	}

	public ConfiguracoesWebServer toConfigurcacoesWebServer() {
		ConfiguracoesWebServer configuracoesWebServer = new ConfiguracoesWebServer();
		configuracoesWebServer.setIpSeguro(cfgWIPS);
		configuracoesWebServer.setTipoConfig(cfgWTpCfg);
		configuracoesWebServer.setHabilitaPorta80(cfgWP80);
		return configuracoesWebServer;
	}

}
