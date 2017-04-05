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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.ConfiguracacoesWebServerCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "configuracoes_web_server")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracoesWebServer.findAll", query = "SELECT c FROM ConfiguracoesWebServer c"),
    @NamedQuery(name = "ConfiguracoesWebServer.findById", query = "SELECT c FROM ConfiguracoesWebServer c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracoesWebServer.findByHabilitaPorta80", query = "SELECT c FROM ConfiguracoesWebServer c WHERE c.habilitaPorta80 = :habilitaPorta80"),
    @NamedQuery(name = "ConfiguracoesWebServer.findByTipoConfig", query = "SELECT c FROM ConfiguracoesWebServer c WHERE c.tipoConfig = :tipoConfig")})
public class ConfiguracoesWebServer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "habilita_porta80")
    private Integer habilitaPorta80;
    @Lob
    @Column(name = "ip_seguro")
    private Integer[] ipSeguro;
    @Column(name = "tipo_config")
    private Integer tipoConfig;
    @OneToMany(mappedBy = "configuracoesWebServerId")
    @JsonIgnore
    private Collection<Tarefa> tarefaCollection;
    @OneToMany(mappedBy = "configuracoesWebServerId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public ConfiguracoesWebServer() {
    }

    public ConfiguracoesWebServer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHabilitaPorta80() {
        return habilitaPorta80;
    }

    public void setHabilitaPorta80(Integer habilitaPorta80) {
        this.habilitaPorta80 = habilitaPorta80;
    }

    public Integer[] getIpSeguro() {
        return ipSeguro;
    }

    public void setIpSeguro(Integer[] ipSeguro) {
        this.ipSeguro = ipSeguro;
    }

    public Integer getTipoConfig() {
        return tipoConfig;
    }

    public void setTipoConfig(Integer tipoConfig) {
        this.tipoConfig = tipoConfig;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracoesWebServer)) {
            return false;
        }
        ConfiguracoesWebServer other = (ConfiguracoesWebServer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.ConfiguracoesWebServer[ id=" + id + " ]";
    }
    
    public ConfiguracacoesWebServerCmd toConfigurcacoesWebServer() {
		ConfiguracacoesWebServerCmd cmd = new ConfiguracacoesWebServerCmd();
		cmd.setCfgWIPS(ipSeguro);
		cmd.setCfgWTpCfg(tipoConfig);
		cmd.setCfgWP80(habilitaPorta80);
		return cmd;
	}
}
