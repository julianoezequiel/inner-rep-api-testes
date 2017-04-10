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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.comandos.Cmd;
import com.api.rep.dto.comandos.EmpregadoCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "empregado")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Empregado.findAll", query = "SELECT e FROM Empregado e"),
		@NamedQuery(name = "Empregado.findById", query = "SELECT e FROM Empregado e WHERE e.id = :id"),
		@NamedQuery(name = "Empregado.findByEmpregadoCartaoBarras", query = "SELECT e FROM Empregado e WHERE e.empregadoCartaoBarras = :empregadoCartaoBarras"),
		@NamedQuery(name = "Empregado.findByEmpregadoCartaoProx", query = "SELECT e FROM Empregado e WHERE e.empregadoCartaoProx = :empregadoCartaoProx"),
		@NamedQuery(name = "Empregado.findByEmpregadoCartaoTeclado", query = "SELECT e FROM Empregado e WHERE e.empregadoCartaoTeclado = :empregadoCartaoTeclado"),
		@NamedQuery(name = "Empregado.findByEmpregadoNome", query = "SELECT e FROM Empregado e WHERE e.empregadoNome = :empregadoNome"),
		@NamedQuery(name = "Empregado.findByEmpregadoNomeExibe", query = "SELECT e FROM Empregado e WHERE e.empregadoNomeExibe = :empregadoNomeExibe"),
		@NamedQuery(name = "Empregado.findByEmpregadoPis", query = "SELECT e FROM Empregado e WHERE e.empregadoPis = :empregadoPis"),
		@NamedQuery(name = "Empregado.findByEmpregadoSenha", query = "SELECT e FROM Empregado e WHERE e.empregadoSenha = :empregadoSenha") })
public class Empregado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "empregado_cartao_barras")
	private String empregadoCartaoBarras;
	@Size(max = 255)
	@Column(name = "empregado_cartao_prox")
	private String empregadoCartaoProx;
	@Size(max = 255)
	@Column(name = "empregado_cartao_teclado")
	private String empregadoCartaoTeclado;
	@Size(max = 255)
	@Column(name = "empregado_nome")
	private String empregadoNome;
	@Size(max = 255)
	@Column(name = "empregado_nome_exibe")
	private String empregadoNomeExibe;
	@Size(max = 255)
	@Column(name = "empregado_pis")
	private String empregadoPis;
	@Size(max = 255)
	@Column(name = "empregado_senha")
	private String empregadoSenha;
	@JoinColumn(name = "rep_id", referencedColumnName = "id")
	@ManyToOne
	private Rep repId;
	@OneToMany(mappedBy = "empregadoId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;
	@OneToMany(mappedBy = "empregadoId")
	@JsonIgnore
	private Collection<Rep> repCollection;

	public Empregado() {
	}

	public Empregado(Integer id) {
		this.id = id;
	}

	public Empregado(String pis) {
		this.empregadoPis = pis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpregadoCartaoBarras() {
		return empregadoCartaoBarras;
	}

	public void setEmpregadoCartaoBarras(String empregadoCartaoBarras) {
		this.empregadoCartaoBarras = empregadoCartaoBarras;
	}

	public String getEmpregadoCartaoProx() {
		return empregadoCartaoProx;
	}

	public void setEmpregadoCartaoProx(String empregadoCartaoProx) {
		this.empregadoCartaoProx = empregadoCartaoProx;
	}

	public String getEmpregadoCartaoTeclado() {
		return empregadoCartaoTeclado;
	}

	public void setEmpregadoCartaoTeclado(String empregadoCartaoTeclado) {
		this.empregadoCartaoTeclado = empregadoCartaoTeclado;
	}

	public String getEmpregadoNome() {
		return empregadoNome;
	}

	public void setEmpregadoNome(String empregadoNome) {
		this.empregadoNome = empregadoNome;
	}

	public String getEmpregadoNomeExibe() {
		return empregadoNomeExibe;
	}

	public void setEmpregadoNomeExibe(String empregadoNomeExibe) {
		this.empregadoNomeExibe = empregadoNomeExibe;
	}

	public String getEmpregadoPis() {
		return empregadoPis;
	}

	public void setEmpregadoPis(String empregadoPis) {
		this.empregadoPis = empregadoPis;
	}

	public String getEmpregadoSenha() {
		return empregadoSenha;
	}

	public void setEmpregadoSenha(String empregadoSenha) {
		this.empregadoSenha = empregadoSenha;
	}

	public Rep getRepId() {
		return repId;
	}

	public void setRepId(Rep repId) {
		this.repId = repId;
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
		if (!(object instanceof Empregado)) {
			return false;
		}
		Empregado other = (Empregado) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Empregado[ id=" + id + " ]";
	}

	public Cmd toEmpregadoDTO() {
		EmpregadoCmd dto = new EmpregadoCmd();
		dto.setfCB(empregadoCartaoBarras);
		dto.setfCP(empregadoCartaoProx);
		dto.setfCT(empregadoCartaoTeclado);
		dto.setfNome(empregadoNome);
		dto.setfNEx(empregadoNomeExibe);
		dto.setfPis(empregadoPis);
		dto.setfSenha(empregadoSenha);
		return dto;
	}
}
