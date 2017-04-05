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

import com.api.rep.dto.comandos.ConfiguracoesCartoesCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "configuracoes_cartoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracoesCartoes.findAll", query = "SELECT c FROM ConfiguracoesCartoes c"),
    @NamedQuery(name = "ConfiguracoesCartoes.findById", query = "SELECT c FROM ConfiguracoesCartoes c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracoesCartoes.findByDigitosFixo", query = "SELECT c FROM ConfiguracoesCartoes c WHERE c.digitosFixo = :digitosFixo"),
    @NamedQuery(name = "ConfiguracoesCartoes.findByTipoBarras", query = "SELECT c FROM ConfiguracoesCartoes c WHERE c.tipoBarras = :tipoBarras"),
    @NamedQuery(name = "ConfiguracoesCartoes.findByTipoProx", query = "SELECT c FROM ConfiguracoesCartoes c WHERE c.tipoProx = :tipoProx")})
public class ConfiguracoesCartoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "buffer_tlm")
    private Integer[] bufferTlm;
    @Column(name = "digitos_fixo")
    private Integer digitosFixo;
    @Lob
    @Column(name = "mascara_barras")
    private Integer[] mascaraBarras;
    @Lob
    @Column(name = "mascara_prox")
    private Integer[] mascaraProx;
    @Column(name = "tipo_barras")
    private Integer tipoBarras;
    @Column(name = "tipo_prox")
    private Integer tipoProx;
    @OneToMany(mappedBy = "configuracoesCartoesId")
    @JsonIgnore
    private Collection<Tarefa> tarefaCollection;
    @OneToMany(mappedBy = "configuracoesCartoesId")
    @JsonIgnore
    private Collection<Rep> repCollection;

    public ConfiguracoesCartoes() {
    }

    public ConfiguracoesCartoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer[] getBufferTlm() {
        return bufferTlm;
    }

    public void setBufferTlm(Integer[] bufferTlm) {
        this.bufferTlm = bufferTlm;
    }

    public Integer getDigitosFixo() {
        return digitosFixo;
    }

    public void setDigitosFixo(Integer digitosFixo) {
        this.digitosFixo = digitosFixo;
    }

    public Integer[] getMascaraBarras() {
        return mascaraBarras;
    }

    public void setMascaraBarras(Integer[] mascaraBarras) {
        this.mascaraBarras = mascaraBarras;
    }

    public Integer[] getMascaraProx() {
        return mascaraProx;
    }

    public void setMascaraProx(Integer[] mascaraProx) {
        this.mascaraProx = mascaraProx;
    }

    public Integer getTipoBarras() {
        return tipoBarras;
    }

    public void setTipoBarras(Integer tipoBarras) {
        this.tipoBarras = tipoBarras;
    }

    public Integer getTipoProx() {
        return tipoProx;
    }

    public void setTipoProx(Integer tipoProx) {
        this.tipoProx = tipoProx;
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
        if (!(object instanceof ConfiguracoesCartoes)) {
            return false;
        }
        ConfiguracoesCartoes other = (ConfiguracoesCartoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.rep.entity.ConfiguracoesCartoes[ id=" + id + " ]";
    }
    
	public ConfiguracoesCartoesCmd toConfiguracoesCartoesCmd() {

		ConfiguracoesCartoesCmd cmd = new ConfiguracoesCartoesCmd();

		cmd.setCfgCDigFixo(this.digitosFixo);
		cmd.setCfgCMascB(this.mascaraBarras);
		cmd.setCfgCMascP(this.mascaraProx);
		cmd.setCfgCTpB(this.tipoBarras);
		cmd.setCfgCTpP(this.tipoProx);
		cmd.setCfgCTlm(this.bufferTlm);

		return cmd;
	}
}
