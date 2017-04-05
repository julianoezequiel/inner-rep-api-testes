/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.ConfiguracoesRedeCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "configuracoes_rede")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ConfiguracoesRede.findAll", query = "SELECT c FROM ConfiguracoesRede c"),
		@NamedQuery(name = "ConfiguracoesRede.findById", query = "SELECT c FROM ConfiguracoesRede c WHERE c.id = :id"),
		@NamedQuery(name = "ConfiguracoesRede.findByHabilitaDhcp", query = "SELECT c FROM ConfiguracoesRede c WHERE c.habilitaDhcp = :habilitaDhcp"),
		@NamedQuery(name = "ConfiguracoesRede.findByIntervaloCom", query = "SELECT c FROM ConfiguracoesRede c WHERE c.intervaloCom = :intervaloCom"),
		@NamedQuery(name = "ConfiguracoesRede.findByIntervaloComunicacaoNuvem", query = "SELECT c FROM ConfiguracoesRede c WHERE c.intervaloComunicacaoNuvem = :intervaloComunicacaoNuvem"),
		@NamedQuery(name = "ConfiguracoesRede.findByNomeHost", query = "SELECT c FROM ConfiguracoesRede c WHERE c.nomeHost = :nomeHost"),
		@NamedQuery(name = "ConfiguracoesRede.findByNomeRep", query = "SELECT c FROM ConfiguracoesRede c WHERE c.nomeRep = :nomeRep"),
		@NamedQuery(name = "ConfiguracoesRede.findByPortaRep", query = "SELECT c FROM ConfiguracoesRede c WHERE c.portaRep = :portaRep"),
		@NamedQuery(name = "ConfiguracoesRede.findByPortaServidor", query = "SELECT c FROM ConfiguracoesRede c WHERE c.portaServidor = :portaServidor"),
		@NamedQuery(name = "ConfiguracoesRede.findByRepInicia", query = "SELECT c FROM ConfiguracoesRede c WHERE c.repInicia = :repInicia"),
		@NamedQuery(name = "ConfiguracoesRede.findByTipoDns", query = "SELECT c FROM ConfiguracoesRede c WHERE c.tipoDns = :tipoDns") })
public class ConfiguracoesRede implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Lob
	@Column(name = "gateway")
	private Integer[] gateway;
	@Column(name = "habilita_dhcp")
	private Integer habilitaDhcp;
	@Column(name = "intervalo_com")
	private Integer intervaloCom;
	@Column(name = "intervalo_comunicacao_nuvem")
	private Integer intervaloComunicacaoNuvem;
	@Lob
	@Column(name = "ip_dns")
	private Integer[] ipDns;
	@Lob
	@Column(name = "ip_rep")
	private Integer[] ipRep;
	@Lob
	@Column(name = "ip_servidor")
	private Integer[] ipServidor;
	@Lob
	@Column(name = "mascara_rede")
	private Integer[] mascaraRede;
	@Size(max = 255)
	@Column(name = "nome_host")
	private String nomeHost;
	@Size(max = 255)
	@Column(name = "nome_rep")
	private String nomeRep;
	@Lob
	@Column(name = "numero_mac")
	private Integer[] numeroMac;
	@Column(name = "porta_rep")
	private Integer portaRep;
	@Column(name = "porta_servidor")
	private Integer portaServidor;
	@Column(name = "rep_inicia")
	private Integer repInicia;
	@Column(name = "tipo_dns")
	private Integer tipoDns;
	@OneToMany(mappedBy = "configuracoesRedeId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;
	@OneToMany(mappedBy = "configuracoesRedeId")
	@JsonIgnore
	private Collection<Rep> repCollection;

	public ConfiguracoesRede() {
	}

	public ConfiguracoesRede(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getGateway() {
		return gateway;
	}

	public void setGateway(Integer[] gateway) {
		this.gateway = gateway;
	}

	public Integer getHabilitaDhcp() {
		return habilitaDhcp;
	}

	public void setHabilitaDhcp(Integer habilitaDhcp) {
		this.habilitaDhcp = habilitaDhcp;
	}

	public Integer getIntervaloCom() {
		return intervaloCom;
	}

	public void setIntervaloCom(Integer intervaloCom) {
		this.intervaloCom = intervaloCom;
	}

	public Integer getIntervaloComunicacaoNuvem() {
		return intervaloComunicacaoNuvem;
	}

	public void setIntervaloComunicacaoNuvem(Integer intervaloComunicacaoNuvem) {
		this.intervaloComunicacaoNuvem = intervaloComunicacaoNuvem;
	}

	public Integer[] getIpDns() {
		return ipDns;
	}

	public void setIpDns(Integer[] ipDns) {
		this.ipDns = ipDns;
	}

	public Integer[] getIpRep() {
		return ipRep;
	}

	public void setIpRep(Integer[] ipRep) {
		this.ipRep = ipRep;
	}

	public Integer[] getIpServidor() {
		return ipServidor;
	}

	public void setIpServidor(Integer[] ipServidor) {
		this.ipServidor = ipServidor;
	}

	public Integer[] getMascaraRede() {
		return mascaraRede;
	}

	public void setMascaraRede(Integer[] mascaraRede) {
		this.mascaraRede = mascaraRede;
	}

	public String getNomeHost() {
		return nomeHost;
	}

	public void setNomeHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}

	public String getNomeRep() {
		return nomeRep;
	}

	public void setNomeRep(String nomeRep) {
		this.nomeRep = nomeRep;
	}

	public Integer[] getNumeroMac() {
		return numeroMac;
	}

	public void setNumeroMac(Integer[] numeroMac) {
		this.numeroMac = numeroMac;
	}

	public Integer getPortaRep() {
		return portaRep;
	}

	public void setPortaRep(Integer portaRep) {
		this.portaRep = portaRep;
	}

	public Integer getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(Integer portaServidor) {
		this.portaServidor = portaServidor;
	}

	public Integer getRepInicia() {
		return repInicia;
	}

	public void setRepInicia(Integer repInicia) {
		this.repInicia = repInicia;
	}

	public Integer getTipoDns() {
		return tipoDns;
	}

	public void setTipoDns(Integer tipoDns) {
		this.tipoDns = tipoDns;
	}

	@XmlTransient
	public Collection<Tarefa> getTarefaCollection() {
		return tarefaCollection;
	}

	public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
		this.tarefaCollection = tarefaCollection;
	}

	@XmlTransient
	public Collection<Rep> getRepCollection() {
		return repCollection;
	}

	public void setRepCollection(Collection<Rep> repCollection) {
		this.repCollection = repCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ConfiguracoesRede)) {
			return false;
		}
		ConfiguracoesRede other = (ConfiguracoesRede) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.ConfiguracoesRede[ id=" + id + " ]";
	}

	public ConfiguracoesRedeCmd toConfiguracoesRedeCmd() {
		ConfiguracoesRedeCmd configuracoesRedeCmd = new ConfiguracoesRedeCmd();

		configuracoesRedeCmd.setCfgRDhcp(this.habilitaDhcp);
		configuracoesRedeCmd.setCfgRGat(this.gateway);
		configuracoesRedeCmd.setCfgRTpDns(this.tipoDns);
		configuracoesRedeCmd.setCfgRIntCom(this.intervaloCom);
		configuracoesRedeCmd.setCfgRIpDns(this.ipDns);
		configuracoesRedeCmd.setCfgRIpRep(this.ipRep);
		configuracoesRedeCmd.setCfgRIpServ(this.ipServidor);
		configuracoesRedeCmd.setCfgRMasc(this.mascaraRede);
		configuracoesRedeCmd.setCfgRNHost(this.nomeHost);
		configuracoesRedeCmd.setCfgRNRep(this.nomeRep);
		configuracoesRedeCmd.setCfgRNumMac(this.numeroMac);
		configuracoesRedeCmd.setCfgRPortRep(this.portaRep);
		configuracoesRedeCmd.setCfgRPortServ(this.portaServidor);
		configuracoesRedeCmd.setCfgRRepIn(this.repInicia);
		configuracoesRedeCmd.setCfgRNInt(this.intervaloComunicacaoNuvem);

		return configuracoesRedeCmd;
	}

}
