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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.AjustesBioCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "ajustes_bio")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "AjustesBio.findAll", query = "SELECT a FROM AjustesBio a"),
		@NamedQuery(name = "AjustesBio.findById", query = "SELECT a FROM AjustesBio a WHERE a.id = :id"),
		@NamedQuery(name = "AjustesBio.findByCapturaAdaptiva", query = "SELECT a FROM AjustesBio a WHERE a.capturaAdaptiva = :capturaAdaptiva"),
		@NamedQuery(name = "AjustesBio.findByDedoDuplicado", query = "SELECT a FROM AjustesBio a WHERE a.dedoDuplicado = :dedoDuplicado"),
		@NamedQuery(name = "AjustesBio.findByNivellfd", query = "SELECT a FROM AjustesBio a WHERE a.nivellfd = :nivellfd"),
		@NamedQuery(name = "AjustesBio.findBySegurancaFiltroLatente", query = "SELECT a FROM AjustesBio a WHERE a.segurancaFiltroLatente = :segurancaFiltroLatente"),
		@NamedQuery(name = "AjustesBio.findBySegurancaIdentificacao", query = "SELECT a FROM AjustesBio a WHERE a.segurancaIdentificacao = :segurancaIdentificacao"),
		@NamedQuery(name = "AjustesBio.findBySegurancaVerificacao", query = "SELECT a FROM AjustesBio a WHERE a.segurancaVerificacao = :segurancaVerificacao"),
		@NamedQuery(name = "AjustesBio.findByTimeout", query = "SELECT a FROM AjustesBio a WHERE a.timeout = :timeout") })
public class AjustesBio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "captura_adaptiva")
	private Integer capturaAdaptiva;
	@Column(name = "dedo_duplicado")
	private Integer dedoDuplicado;
	@Column(name = "nivellfd")
	private Integer nivellfd;
	@Column(name = "seguranca_filtro_latente")
	private Integer segurancaFiltroLatente;
	@Column(name = "seguranca_identificacao")
	private Integer segurancaIdentificacao;
	@Column(name = "seguranca_verificacao")
	private Integer segurancaVerificacao;
	@Column(name = "timeout")
	private Integer timeout;
	@OneToMany(mappedBy = "ajustesBioId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;
	@OneToMany(mappedBy = "ajustesBioId")
	@JsonIgnore
	private Collection<Rep> repCollection;

	public AjustesBio() {
	}

	public AjustesBio(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapturaAdaptiva() {
		return capturaAdaptiva;
	}

	public void setCapturaAdaptiva(Integer capturaAdaptiva) {
		this.capturaAdaptiva = capturaAdaptiva;
	}

	public Integer getDedoDuplicado() {
		return dedoDuplicado;
	}

	public void setDedoDuplicado(Integer dedoDuplicado) {
		this.dedoDuplicado = dedoDuplicado;
	}

	public Integer getNivellfd() {
		return nivellfd;
	}

	public void setNivellfd(Integer nivellfd) {
		this.nivellfd = nivellfd;
	}

	public Integer getSegurancaFiltroLatente() {
		return segurancaFiltroLatente;
	}

	public void setSegurancaFiltroLatente(Integer segurancaFiltroLatente) {
		this.segurancaFiltroLatente = segurancaFiltroLatente;
	}

	public Integer getSegurancaIdentificacao() {
		return segurancaIdentificacao;
	}

	public void setSegurancaIdentificacao(Integer segurancaIdentificacao) {
		this.segurancaIdentificacao = segurancaIdentificacao;
	}

	public Integer getSegurancaVerificacao() {
		return segurancaVerificacao;
	}

	public void setSegurancaVerificacao(Integer segurancaVerificacao) {
		this.segurancaVerificacao = segurancaVerificacao;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
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
		if (!(object instanceof AjustesBio)) {
			return false;
		}
		AjustesBio other = (AjustesBio) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.AjustesBio[ id=" + id + " ]";
	}

	public AjustesBioCmd toAjustesBioCmd() {
		AjustesBioCmd cmd = new AjustesBioCmd();
		cmd.setCfgBCA(capturaAdaptiva);
		cmd.setCfgBDD(dedoDuplicado);
		cmd.setCfgBFL(segurancaFiltroLatente);
		cmd.setCfgBNLFD(nivellfd);
		cmd.setCfgBSegI(segurancaIdentificacao);
		cmd.setCfgBSegV(segurancaVerificacao);
		cmd.setCfgBTO(timeout);

		return cmd;

	}

}
