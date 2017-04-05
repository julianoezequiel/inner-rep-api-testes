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

import com.api.rep.dto.comandos.ColetaDumpCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "coleta_dumping")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "ColetaDumping.findAll", query = "SELECT c FROM ColetaDumping c"),
		@NamedQuery(name = "ColetaDumping.findById", query = "SELECT c FROM ColetaDumping c WHERE c.id = :id"),
		@NamedQuery(name = "ColetaDumping.findByEnderecoFim", query = "SELECT c FROM ColetaDumping c WHERE c.enderecoFim = :enderecoFim"),
		@NamedQuery(name = "ColetaDumping.findByEnderecoInicio", query = "SELECT c FROM ColetaDumping c WHERE c.enderecoInicio = :enderecoInicio") })
public class ColetaDumping implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "endereco_fim")
	private Integer enderecoFim;
	@Column(name = "endereco_inicio")
	private Integer enderecoInicio;
	@JsonIgnore
	@OneToMany(mappedBy = "coletaDumpingId")
	private Collection<Tarefa> tarefaCollection;

	public ColetaDumping() {
	}

	public ColetaDumping(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnderecoFim() {
		return enderecoFim;
	}

	public void setEnderecoFim(Integer enderecoFim) {
		this.enderecoFim = enderecoFim;
	}

	public Integer getEnderecoInicio() {
		return enderecoInicio;
	}

	public void setEnderecoInicio(Integer enderecoInicio) {
		this.enderecoInicio = enderecoInicio;
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
		if (!(object instanceof ColetaDumping)) {
			return false;
		}
		ColetaDumping other = (ColetaDumping) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.ColetaDumping[ id=" + id + " ]";
	}

	public ColetaDumpCmd toColetaDumpingCmd() {
		ColetaDumpCmd cmd = new ColetaDumpCmd();
		cmd.setcDEndFim(enderecoFim);
		cmd.setcDEndIni(enderecoInicio);
		return cmd;
	}
}
