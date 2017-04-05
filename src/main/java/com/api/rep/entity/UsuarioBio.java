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

import com.api.rep.dto.comandos.UsuarioBioCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "usuario_bio")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "UsuarioBio.findAll", query = "SELECT u FROM UsuarioBio u"),
		@NamedQuery(name = "UsuarioBio.findById", query = "SELECT u FROM UsuarioBio u WHERE u.id = :id"),
		@NamedQuery(name = "UsuarioBio.findByPis", query = "SELECT u FROM UsuarioBio u WHERE u.pis = :pis") })
public class UsuarioBio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "pis")
	private String pis;
	@Lob
	@Column(name = "template")
	private byte[] template;

	@OneToMany(mappedBy = "usuarioBioId")
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;

	public UsuarioBio() {
	}

	public UsuarioBio(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public byte[] getTemplate() {
		return template;
	}

	public void setTemplate(byte[] template) {
		this.template = template;
	}

	public Collection<Tarefa> getTarefaCollection() {
		return tarefaCollection;
	}

	public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
		this.tarefaCollection = tarefaCollection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		if (!(object instanceof UsuarioBio)) {
			return false;
		}
		UsuarioBio other = (UsuarioBio) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.UsuarioBio[ id=" + id + " ]";
	}

	public UsuarioBioCmd toUsuarioBioCmd() {
		UsuarioBioCmd cmd = new UsuarioBioCmd();
		cmd.setfPis(pis);
		return cmd;
	}

}
