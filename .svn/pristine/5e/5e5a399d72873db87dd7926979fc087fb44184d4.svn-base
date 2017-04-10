/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.api.rep.dto.RepMonitor;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "rep")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Rep.findAll", query = "SELECT r FROM Rep r"),
		@NamedQuery(name = "Rep.findById", query = "SELECT r FROM Rep r WHERE r.id = :id"),
		@NamedQuery(name = "Rep.findByChaveComunicacao", query = "SELECT r FROM Rep r WHERE r.chaveComunicacao = :chaveComunicacao"),
		@NamedQuery(name = "Rep.findByNumeroSerie", query = "SELECT r FROM Rep r WHERE r.numeroSerie = :numeroSerie"),
		@NamedQuery(name = "Rep.findByStatus", query = "SELECT r FROM Rep r WHERE r.status = :status"),
		@NamedQuery(name = "Rep.findByUltimaConexao", query = "SELECT r FROM Rep r WHERE r.ultimaConexao = :ultimaConexao"),
		@NamedQuery(name = "Rep.findByUltimoIp", query = "SELECT r FROM Rep r WHERE r.ultimoIp = :ultimoIp"),
		@NamedQuery(name = "Rep.findByUltimoNsr", query = "SELECT r FROM Rep r WHERE r.ultimoNsr = :ultimoNsr") })
public class Rep implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "chave_comunicacao")
	private String chaveComunicacao;
	@Size(max = 255)
	@Column(name = "numero_serie")
	private String numeroSerie;
	@Size(max = 255)
	@Column(name = "status")
	private String status;
	@Column(name = "ultima_conexao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaConexao;
	@Size(max = 255)
	@Column(name = "ultimo_ip")
	private String ultimoIp;
	@Column(name = "ultimo_nsr")
	private Integer ultimoNsr;
	@Column(name = "chave_aes")
	@Lob
	private Integer[] chaveAES;
	@Column(name = "chave_rsa_publica")
	@Lob
	private Integer[] chaveRSAPublica;
	@Column(name = "expoente")
	@Lob
	private Integer expoente;
	@Column(name = "chave_rsa_privada")
	@Lob
	private byte[] chaveRSAPrivada;
	@Column(name = "chave_publica")
	private String chavePublica;
	@OneToMany(mappedBy = "repId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Collection<Empregado> empregadoCollection;
	@OneToMany(mappedBy = "repId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Collection<Tarefa> tarefaCollection;
	@OneToMany(mappedBy = "repId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Collection<Nsr> nsrCollection;
	@JoinColumn(name = "configuracoes_senha_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesSenha configuracoesSenhaId;
	@JoinColumn(name = "empregador_id", referencedColumnName = "id")
	@ManyToOne
	private Empregador empregadorId;
	@JoinColumn(name = "ajustes_bio_id", referencedColumnName = "id")
	@ManyToOne
	private AjustesBio ajustesBioId;
	@JoinColumn(name = "indentificadores_id", referencedColumnName = "id")
	@ManyToOne
	private Identificadores indentificadoresId;
	@JoinColumn(name = "configuracoes_cartoes_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesCartoes configuracoesCartoesId;
	@JoinColumn(name = "info_id", referencedColumnName = "id")
	@ManyToOne
	private Info infoId;
	@JoinColumn(name = "relogio_id", referencedColumnName = "id")
	@ManyToOne
	private Relogio relogioId;
	@JoinColumn(name = "horario_verao_id", referencedColumnName = "id")
	@ManyToOne
	private HorarioVerao horarioVeraoId;
	@JoinColumn(name = "configuracoes_rede_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesRede configuracoesRedeId;
	@JoinColumn(name = "configuracoes_web_server_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesWebServer configuracoesWebServerId;
	@JoinColumn(name = "empregado_id", referencedColumnName = "id")
	@ManyToOne
	private Empregado empregadoId;

	public Rep() {
	}

	public Rep(Integer id) {
		this.id = id;
	}

	public Rep(Integer id2, String numeroSerie2, String chaveComunicacao2) {
		this.id = id2;
		this.numeroSerie = numeroSerie2;
		this.chaveComunicacao = chaveComunicacao2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChaveComunicacao() {
		return chaveComunicacao;
	}

	public void setChaveComunicacao(String chaveComunicacao) {
		this.chaveComunicacao = chaveComunicacao;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUltimaConexao() {
		return ultimaConexao;
	}

	public void setUltimaConexao(Date ultimaConexao) {
		this.ultimaConexao = ultimaConexao;
	}

	public String getUltimoIp() {
		return ultimoIp;
	}

	public void setUltimoIp(String ultimoIp) {
		this.ultimoIp = ultimoIp;
	}

	public Integer getUltimoNsr() {
		return ultimoNsr;
	}

	public void setUltimoNsr(Integer ultimoNsr) {
		this.ultimoNsr = ultimoNsr;
	}

	@XmlTransient
	public Collection<Empregado> getEmpregadoCollection() {
		return empregadoCollection;
	}

	public void setEmpregadoCollection(Collection<Empregado> empregadoCollection) {
		this.empregadoCollection = empregadoCollection;
	}

	@XmlTransient
	public Collection<Tarefa> getTarefaCollection() {
		return tarefaCollection;
	}

	public void setTarefaCollection(Collection<Tarefa> tarefaCollection) {
		this.tarefaCollection = tarefaCollection;
	}

	@XmlTransient
	public Collection<Nsr> getNsrCollection() {
		return nsrCollection;
	}

	public void setNsrCollection(Collection<Nsr> nsrCollection) {
		this.nsrCollection = nsrCollection;
	}

	public ConfiguracoesSenha getConfiguracoesSenhaId() {
		return configuracoesSenhaId;
	}

	public void setConfiguracoesSenhaId(ConfiguracoesSenha configuracoesSenhaId) {
		this.configuracoesSenhaId = configuracoesSenhaId;
	}

	public Empregador getEmpregadorId() {
		return empregadorId;
	}

	public void setEmpregadorId(Empregador empregadorId) {
		this.empregadorId = empregadorId;
	}

	public AjustesBio getAjustesBioId() {
		return ajustesBioId;
	}

	public void setAjustesBioId(AjustesBio ajustesBioId) {
		this.ajustesBioId = ajustesBioId;
	}

	public Identificadores getIndentificadoresId() {
		return indentificadoresId;
	}

	public void setIndentificadoresId(Identificadores indentificadoresId) {
		this.indentificadoresId = indentificadoresId;
	}

	public ConfiguracoesCartoes getConfiguracoesCartoesId() {
		return configuracoesCartoesId;
	}

	public void setConfiguracoesCartoesId(ConfiguracoesCartoes configuracoesCartoesId) {
		this.configuracoesCartoesId = configuracoesCartoesId;
	}

	public Info getInfoId() {
		return infoId;
	}

	public void setInfoId(Info infoId) {
		this.infoId = infoId;
	}

	public Relogio getRelogioId() {
		return relogioId;
	}

	public void setRelogioId(Relogio relogioId) {
		this.relogioId = relogioId;
	}

	public HorarioVerao getHorarioVeraoId() {
		return horarioVeraoId;
	}

	public void setHorarioVeraoId(HorarioVerao horarioVeraoId) {
		this.horarioVeraoId = horarioVeraoId;
	}

	public ConfiguracoesRede getConfiguracoesRedeId() {
		return configuracoesRedeId;
	}

	public void setConfiguracoesRedeId(ConfiguracoesRede configuracoesRedeId) {
		this.configuracoesRedeId = configuracoesRedeId;
	}

	public ConfiguracoesWebServer getConfiguracoesWebServerId() {
		return configuracoesWebServerId;
	}

	public void setConfiguracoesWebServerId(ConfiguracoesWebServer configuracoesWebServerId) {
		this.configuracoesWebServerId = configuracoesWebServerId;
	}

	public Empregado getEmpregadoId() {
		return empregadoId;
	}

	public void setEmpregadoId(Empregado empregadoId) {
		this.empregadoId = empregadoId;
	}

	public Integer[] getChaveAES() {
		return chaveAES;
	}

	public void setChaveAES(Integer[] chaveAES) {
		this.chaveAES = chaveAES;
	}

	public Integer[] getChaveRSAPublica() {
		return chaveRSAPublica;
	}

	public void setChaveRSAPublica(Integer[] chaveRSA) {
		this.chaveRSAPublica = chaveRSA;
	}

	public String getChavePublica() {
		return chavePublica;
	}

	public void setChavePublica(String chavePublica) {
		this.chavePublica = chavePublica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public byte[] getChaveRSAPrivada() {
		return chaveRSAPrivada;
	}

	public void setChaveRSAPrivada(byte[] chaveRSAPrivada) {
		this.chaveRSAPrivada = chaveRSAPrivada;
	}

	public Integer getExpoente() {
		return expoente;
	}

	public void setExpoente(Integer expoente) {
		this.expoente = expoente;
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
		if (!(object instanceof Rep)) {
			return false;
		}
		Rep other = (Rep) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Rep[ id=" + id + " ]";
	}

	public RepMonitor toRepStatus() {
		RepMonitor repMonitor = new RepMonitor();
		repMonitor.setId(id);
		repMonitor.setChaveComunicacao(chaveComunicacao);
		repMonitor.setNumeroSerie(numeroSerie);
		repMonitor.setStatus(status);
		repMonitor.setUltimoIp(ultimoIp);
		return repMonitor;
	}

	public Rep clear(Rep rep) {
		rep.setAjustesBioId(null);
		rep.setConfiguracoesCartoesId(null);
		rep.setConfiguracoesRedeId(null);
		rep.setConfiguracoesSenhaId(null);
		rep.setConfiguracoesWebServerId(null);
		rep.setEmpregadoId(null);
		rep.setEmpregadorId(null);
		rep.setHorarioVeraoId(null);
		rep.setIndentificadoresId(null);
		return rep;
	}

}
