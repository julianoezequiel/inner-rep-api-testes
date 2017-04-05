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

import com.api.rep.dto.comandos.Cmd;
import com.api.rep.dto.comandos.EmpregadorCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "empregador")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Empregador.findAll", query = "SELECT e FROM Empregador e"),
		@NamedQuery(name = "Empregador.findById", query = "SELECT e FROM Empregador e WHERE e.id = :id"),
		@NamedQuery(name = "Empregador.findByEmpregadorCei", query = "SELECT e FROM Empregador e WHERE e.empregadorCei = :empregadorCei"),
		@NamedQuery(name = "Empregador.findByEmpregadorIdent", query = "SELECT e FROM Empregador e WHERE e.empregadorIdent = :empregadorIdent"),
		@NamedQuery(name = "Empregador.findByEmpregadorLocal", query = "SELECT e FROM Empregador e WHERE e.empregadorLocal = :empregadorLocal"),
		@NamedQuery(name = "Empregador.findByEmpregadorRazao", query = "SELECT e FROM Empregador e WHERE e.empregadorRazao = :empregadorRazao"),
		@NamedQuery(name = "Empregador.findByEmpregadorTipoIdent", query = "SELECT e FROM Empregador e WHERE e.empregadorTipoIdent = :empregadorTipoIdent") })
public class Empregador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "empregador_cei")
	private String empregadorCei;
	@Size(max = 255)
	@Column(name = "empregador_ident")
	private String empregadorIdent;
	@Size(max = 255)
	@Column(name = "empregador_local")
	private String empregadorLocal;
	@Size(max = 255)
	@Column(name = "empregador_razao")
	private String empregadorRazao;
	@Size(max = 255)
	@Column(name = "empregador_tipo_ident")
	private String empregadorTipoIdent;
	@OneToMany(mappedBy = "empregadorId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;
	@OneToMany(mappedBy = "empregadorId")
	@JsonIgnore
	private Collection<Rep> repCollection;

	public Empregador() {
	}

	public Empregador(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpregadorCei() {
		return empregadorCei;
	}

	public void setEmpregadorCei(String empregadorCei) {
		this.empregadorCei = empregadorCei;
	}

	public String getEmpregadorIdent() {
		return empregadorIdent;
	}

	public void setEmpregadorIdent(String empregadorIdent) {
		this.empregadorIdent = empregadorIdent;
	}

	public String getEmpregadorLocal() {
		return empregadorLocal;
	}

	public void setEmpregadorLocal(String empregadorLocal) {
		this.empregadorLocal = empregadorLocal;
	}

	public String getEmpregadorRazao() {
		return empregadorRazao;
	}

	public void setEmpregadorRazao(String empregadorRazao) {
		this.empregadorRazao = empregadorRazao;
	}

	public String getEmpregadorTipoIdent() {
		return empregadorTipoIdent;
	}

	public void setEmpregadorTipoIdent(String empregadorTipoIdent) {
		this.empregadorTipoIdent = empregadorTipoIdent;
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
		if (!(object instanceof Empregador)) {
			return false;
		}
		Empregador other = (Empregador) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Empregador[ id=" + id + " ]";
	}

	public Cmd toEmpregadorDTO() {
		EmpregadorCmd dto = new EmpregadorCmd();
		dto.seteCei(empregadorCei);
		dto.seteId(empregadorIdent);
		dto.seteLoc(empregadorLocal);
		dto.seteRS(empregadorRazao);
		dto.seteTpId(empregadorTipoIdent);
		return dto;
	}

	public static Empregador clear(Empregador empregador) {
		empregador.setRepCollection(null);
		return empregador;
	}

}
