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

import com.api.rep.dto.comandos.InfoCmd;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "info")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Info.findAll", query = "SELECT i FROM Info i"),
		@NamedQuery(name = "Info.findById", query = "SELECT i FROM Info i WHERE i.id = :id"),
		@NamedQuery(name = "Info.findByCapacidadeBio", query = "SELECT i FROM Info i WHERE i.capacidadeBio = :capacidadeBio"),
		@NamedQuery(name = "Info.findByModeloBio", query = "SELECT i FROM Info i WHERE i.modeloBio = :modeloBio"),
		@NamedQuery(name = "Info.findByModeloProduto", query = "SELECT i FROM Info i WHERE i.modeloProduto = :modeloProduto"),
		@NamedQuery(name = "Info.findByNomeProduto", query = "SELECT i FROM Info i WHERE i.nomeProduto = :nomeProduto"),
		@NamedQuery(name = "Info.findByNumeroBiometrias", query = "SELECT i FROM Info i WHERE i.numeroBiometrias = :numeroBiometrias"),
		@NamedQuery(name = "Info.findByNumeroRep", query = "SELECT i FROM Info i WHERE i.numeroRep = :numeroRep"),
		@NamedQuery(name = "Info.findByNumeroUsuario", query = "SELECT i FROM Info i WHERE i.numeroUsuario = :numeroUsuario"),
		@NamedQuery(name = "Info.findByNumeroUsuarioBio", query = "SELECT i FROM Info i WHERE i.numeroUsuarioBio = :numeroUsuarioBio"),
		@NamedQuery(name = "Info.findByStatusBloqueio", query = "SELECT i FROM Info i WHERE i.statusBloqueio = :statusBloqueio"),
		@NamedQuery(name = "Info.findByStatusImpressora", query = "SELECT i FROM Info i WHERE i.statusImpressora = :statusImpressora"),
		@NamedQuery(name = "Info.findByTipoBio", query = "SELECT i FROM Info i WHERE i.tipoBio = :tipoBio"),
		@NamedQuery(name = "Info.findByUltimoNsr", query = "SELECT i FROM Info i WHERE i.ultimoNsr = :ultimoNsr"),
		@NamedQuery(name = "Info.findByVersaoApl", query = "SELECT i FROM Info i WHERE i.versaoApl = :versaoApl"),
		@NamedQuery(name = "Info.findByVersaoMrp", query = "SELECT i FROM Info i WHERE i.versaoMrp = :versaoMrp") })
public class Info implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Column(name = "capacidade_bio")
	private Integer capacidadeBio;
	@Size(max = 255)
	@Column(name = "modelo_bio")
	private String modeloBio;
	@Size(max = 255)
	@Column(name = "modelo_produto")
	private String modeloProduto;
	@Size(max = 255)
	@Column(name = "nome_produto")
	private String nomeProduto;
	@Column(name = "numero_biometrias")
	private Integer numeroBiometrias;
	@Size(max = 255)
	@Column(name = "numero_rep")
	private String numeroRep;
	@Column(name = "numero_usuario")
	private Integer numeroUsuario;
	@Column(name = "numero_usuario_bio")
	private Integer numeroUsuarioBio;
	@Column(name = "status_bloqueio")
	private Integer statusBloqueio;
	@Size(max = 255)
	@Column(name = "status_impressora")
	private String statusImpressora;
	@Size(max = 255)
	@Column(name = "tipo_bio")
	private String tipoBio;
	@Size(max = 255)
	@Column(name = "ultimo_nsr")
	private String ultimoNsr;
	@Size(max = 255)
	@Column(name = "versao_apl")
	private String versaoApl;
	@Size(max = 255)
	@Column(name = "versao_mrp")
	private String versaoMrp;
	@OneToMany(mappedBy = "infoId")
	@JsonIgnore
	private Collection<Rep> repCollection;

	public Info() {
	}

	public Info(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadeBio() {
		return capacidadeBio;
	}

	public void setCapacidadeBio(Integer capacidadeBio) {
		this.capacidadeBio = capacidadeBio;
	}

	public String getModeloBio() {
		return modeloBio;
	}

	public void setModeloBio(String modeloBio) {
		this.modeloBio = modeloBio;
	}

	public String getModeloProduto() {
		return modeloProduto;
	}

	public void setModeloProduto(String modeloProduto) {
		this.modeloProduto = modeloProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getNumeroBiometrias() {
		return numeroBiometrias;
	}

	public void setNumeroBiometrias(Integer numeroBiometrias) {
		this.numeroBiometrias = numeroBiometrias;
	}

	public String getNumeroRep() {
		return numeroRep;
	}

	public void setNumeroRep(String numeroRep) {
		this.numeroRep = numeroRep;
	}

	public Integer getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(Integer numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}

	public Integer getNumeroUsuarioBio() {
		return numeroUsuarioBio;
	}

	public void setNumeroUsuarioBio(Integer numeroUsuarioBio) {
		this.numeroUsuarioBio = numeroUsuarioBio;
	}

	public Integer getStatusBloqueio() {
		return statusBloqueio;
	}

	public void setStatusBloqueio(Integer statusBloqueio) {
		this.statusBloqueio = statusBloqueio;
	}

	public String getStatusImpressora() {
		return statusImpressora;
	}

	public void setStatusImpressora(String statusImpressora) {
		this.statusImpressora = statusImpressora;
	}

	public String getTipoBio() {
		return tipoBio;
	}

	public void setTipoBio(String tipoBio) {
		this.tipoBio = tipoBio;
	}

	public String getUltimoNsr() {
		return ultimoNsr;
	}

	public void setUltimoNsr(String ultimoNsr) {
		this.ultimoNsr = ultimoNsr;
	}

	public String getVersaoApl() {
		return versaoApl;
	}

	public void setVersaoApl(String versaoApl) {
		this.versaoApl = versaoApl;
	}

	public String getVersaoMrp() {
		return versaoMrp;
	}

	public void setVersaoMrp(String versaoMrp) {
		this.versaoMrp = versaoMrp;
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
		if (!(object instanceof Info)) {
			return false;
		}
		Info other = (Info) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Info[ id=" + id + " ]";
	}

	public InfoCmd toInfoCmd() {
		InfoCmd infoCmd = new InfoCmd();

		infoCmd.setInfCpBio(this.capacidadeBio.toString());
		infoCmd.setInfMBio(this.modeloBio);
		infoCmd.setInfMProd(this.modeloProduto);
		infoCmd.setInfNProd(this.nomeProduto);
		infoCmd.setInfNsr(this.ultimoNsr);
		infoCmd.setInfNumBio(this.numeroUsuarioBio.toString());
		infoCmd.setInfNumFunc(this.numeroUsuario.toString());
		infoCmd.setInfNumRep(this.numeroRep);
		infoCmd.setInfStatImp(this.statusImpressora);
		infoCmd.setInfStatRep(this.statusBloqueio.toString());
		infoCmd.setInfTpBio(this.tipoBio);
		infoCmd.setInfVerApl(this.versaoApl);
		infoCmd.setInfVerMrp(this.versaoMrp);
		infoCmd.setInfNumUsuBio(this.numeroBiometrias.toString());

		return infoCmd;
	}

}
