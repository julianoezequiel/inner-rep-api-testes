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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.ConfiguracaoSenhaCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "configuracoes_senha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracoesSenha.findAll", query = "SELECT c FROM ConfiguracoesSenha c"),
    @NamedQuery(name = "ConfiguracoesSenha.findById", query = "SELECT c FROM ConfiguracoesSenha c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracoesSenha.findBySenhaBio", query = "SELECT c FROM ConfiguracoesSenha c WHERE c.senhaBio = :senhaBio"),
    @NamedQuery(name = "ConfiguracoesSenha.findBySenhaConfig", query = "SELECT c FROM ConfiguracoesSenha c WHERE c.senhaConfig = :senhaConfig"),
    @NamedQuery(name = "ConfiguracoesSenha.findBySenhaPendrive", query = "SELECT c FROM ConfiguracoesSenha c WHERE c.senhaPendrive = :senhaPendrive")})
public class ConfiguracoesSenha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "senha_bio")
    private String senhaBio;
    @Size(max = 255)
    @Column(name = "senha_config")
    private String senhaConfig;
    @Size(max = 255)
    @Column(name = "senha_pendrive")
    private String senhaPendrive;
    @OneToMany(mappedBy = "configuracoesSenhaId")
    @JsonIgnore
    private Collection<Tarefa> tarefaCollection;
    @OneToMany(mappedBy = "configuracoesSenhaId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public ConfiguracoesSenha() {
    }

    public ConfiguracoesSenha(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenhaBio() {
        return senhaBio;
    }

    public void setSenhaBio(String senhaBio) {
        this.senhaBio = senhaBio;
    }

    public String getSenhaConfig() {
        return senhaConfig;
    }

    public void setSenhaConfig(String senhaConfig) {
        this.senhaConfig = senhaConfig;
    }

    public String getSenhaPendrive() {
        return senhaPendrive;
    }

    public void setSenhaPendrive(String senhaPendrive) {
        this.senhaPendrive = senhaPendrive;
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
        if (!(object instanceof ConfiguracoesSenha)) {
            return false;
        }
        ConfiguracoesSenha other = (ConfiguracoesSenha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.ConfiguracoesSenha[ id=" + id + " ]";
    }
    
    public ConfiguracaoSenhaCmd toConfiguracaoCmd() {
		ConfiguracaoSenhaCmd configuracaoSenhaCmd = new ConfiguracaoSenhaCmd();
		configuracaoSenhaCmd.setCfgSBio(senhaBio);
		configuracaoSenhaCmd.setCfgSCfg(senhaConfig);
		configuracaoSenhaCmd.setCfgSPend(senhaPendrive);
		return configuracaoSenhaCmd;
	}
    
}
