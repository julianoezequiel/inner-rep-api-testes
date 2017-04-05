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

import com.api.rep.dto.comandos.ColetaCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "coleta")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Coleta.findAll", query = "SELECT c FROM Coleta c"),
		@NamedQuery(name = "Coleta.findById", query = "SELECT c FROM Coleta c WHERE c.id = :id"),
		@NamedQuery(name = "Coleta.findByColetaDataFim", query = "SELECT c FROM Coleta c WHERE c.coletaDataFim = :coletaDataFim"),
		@NamedQuery(name = "Coleta.findByColetaDataInicio", query = "SELECT c FROM Coleta c WHERE c.coletaDataInicio = :coletaDataInicio"),
		@NamedQuery(name = "Coleta.findByColetaNsrFim", query = "SELECT c FROM Coleta c WHERE c.coletaNsrFim = :coletaNsrFim"),
		@NamedQuery(name = "Coleta.findByColetaNsrInicio", query = "SELECT c FROM Coleta c WHERE c.coletaNsrInicio = :coletaNsrInicio") })
public class Coleta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "coleta_data_fim")
	private String coletaDataFim;
	@Size(max = 255)
	@Column(name = "coleta_data_inicio")
	private String coletaDataInicio;
	@Column(name = "coleta_nsr_fim")
	private Integer coletaNsrFim;
	@Column(name = "coleta_nsr_inicio")
	private Integer coletaNsrInicio;
	@OneToMany(mappedBy = "coletaId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;

	public Coleta() {
	}

	public Coleta(Integer id) {
		this.id = id;
	}

	public Coleta(Integer numeroNsr, Integer ultimoNsr) {
		this.coletaNsrInicio = numeroNsr;
		this.coletaNsrFim = ultimoNsr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColetaDataFim() {
		return coletaDataFim;
	}

	public void setColetaDataFim(String coletaDataFim) {
		this.coletaDataFim = coletaDataFim;
	}

	public String getColetaDataInicio() {
		return coletaDataInicio;
	}

	public void setColetaDataInicio(String coletaDataInicio) {
		this.coletaDataInicio = coletaDataInicio;
	}

	public Integer getColetaNsrFim() {
		return coletaNsrFim;
	}

	public void setColetaNsrFim(Integer coletaNsrFim) {
		this.coletaNsrFim = coletaNsrFim;
	}

	public Integer getColetaNsrInicio() {
		return coletaNsrInicio;
	}

	public void setColetaNsrInicio(Integer coletaNsrInicio) {
		this.coletaNsrInicio = coletaNsrInicio;
	}

	@XmlTransient
	public Collection<Tarefa> getTarefaCollection() {
		return tarefaCollection;
	}

	public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
		this.tarefaCollection = tarefaCollection;
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
		if (!(object instanceof Coleta)) {
			return false;
		}
		Coleta other = (Coleta) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Coleta[ id=" + id + " ]";
	}

	public ColetaCmd toColetaCmd() {
		ColetaCmd dto = new ColetaCmd();
		dto.setcNsrF(this.coletaNsrFim);
		dto.setcNsrI(this.coletaNsrInicio);
		dto.setcDtF(coletaDataFim);
		dto.setcDtI(coletaDataInicio);
		return dto;

	}

}
