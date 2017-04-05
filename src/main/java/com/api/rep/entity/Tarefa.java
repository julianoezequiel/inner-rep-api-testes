/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rep.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.Cmd;
import com.api.rep.dto.comunicacao.ComandoDeEnvio;
import com.api.rep.service.comandos.CmdHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author juliano.ezequiel
 */
@Entity
@Table(name = "tarefa")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t"),
		@NamedQuery(name = "Tarefa.findById", query = "SELECT t FROM Tarefa t WHERE t.id = :id"),
		@NamedQuery(name = "Tarefa.findByCpf", query = "SELECT t FROM Tarefa t WHERE t.cpf = :cpf"),
		@NamedQuery(name = "Tarefa.findByTentativas", query = "SELECT t FROM Tarefa t WHERE t.tentativas = :tentativas"),
		@NamedQuery(name = "Tarefa.findByTipoOperacao", query = "SELECT t FROM Tarefa t WHERE t.tipoOperacao = :tipoOperacao"),
		@NamedQuery(name = "Tarefa.findByTipoTarefa", query = "SELECT t FROM Tarefa t WHERE t.tipoTarefa = :tipoTarefa"),
		@NamedQuery(name = "Tarefa.findByTipoUrl", query = "SELECT t FROM Tarefa t WHERE t.tipoUrl = :tipoUrl") })
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Size(max = 255)
	@Column(name = "cpf")
	private String cpf;
	@Lob
	@Column(name = "status")
	private byte[] status;
	@Column(name = "tentativas")
	private Integer tentativas;
	@Column(name = "tipo_operacao")
	private Integer tipoOperacao;
	@Column(name = "tipo_tarefa")
	private Integer tipoTarefa;
	@Column(name = "tipo_url")
	private Integer tipoUrl;
	@JoinColumn(name = "coleta_dumping_id", referencedColumnName = "id")
	@ManyToOne
	private ColetaDumping coletaDumpingId;
	@JoinColumn(name = "configuracoes_rede_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesRede configuracoesRedeId;
	@JoinColumn(name = "empregador_id", referencedColumnName = "id")
	@ManyToOne
	private Empregador empregadorId;
	@JoinColumn(name = "ajustes_bio_id", referencedColumnName = "id")
	@ManyToOne
	private AjustesBio ajustesBioId;
	@JoinColumn(name = "relogio_id", referencedColumnName = "id")
	@ManyToOne
	private Relogio relogioId;
	@JoinColumn(name = "configuracoes_web_server_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesWebServer configuracoesWebServerId;
	@JoinColumn(name = "horario_verao_id", referencedColumnName = "id")
	@ManyToOne
	private HorarioVerao horarioVeraoId;
	@JoinColumn(name = "rep_id", referencedColumnName = "id")
	@ManyToOne
	@JsonIgnore
	private Rep repId;
	@JoinColumn(name = "coleta_id", referencedColumnName = "id")
	@ManyToOne
	private Coleta coletaId;
	@JoinColumn(name = "empregado_id", referencedColumnName = "id")
	@ManyToOne
	private Empregado empregadoId;
	@JoinColumn(name = "configuracoes_cartoes_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesCartoes configuracoesCartoesId;
	@JoinColumn(name = "configuracoes_senha_id", referencedColumnName = "id")
	@ManyToOne
	private ConfiguracoesSenha configuracoesSenhaId;

	@JoinColumn(name = "usuario_bio_id", referencedColumnName = "id")
	@ManyToOne
	private UsuarioBio usuarioBioId;

	public Tarefa() {
	}

	public Tarefa(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public byte[] getStatus() {
		return status;
	}

	public void setStatus(byte[] status) {
		this.status = status;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public Integer getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(Integer tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Integer getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(Integer tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public Integer getTipoUrl() {
		return tipoUrl;
	}

	public void setTipoUrl(Integer tipoUrl) {
		this.tipoUrl = tipoUrl;
	}

	public ColetaDumping getColetaDumpingId() {
		return coletaDumpingId;
	}

	public void setColetaDumpingId(ColetaDumping coletaDumpingId) {
		this.coletaDumpingId = coletaDumpingId;
	}

	public ConfiguracoesRede getConfiguracoesRedeId() {
		return configuracoesRedeId;
	}

	public void setConfiguracoesRedeId(ConfiguracoesRede configuracoesRedeId) {
		this.configuracoesRedeId = configuracoesRedeId;
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

	public Relogio getRelogioId() {
		return relogioId;
	}

	public void setRelogioId(Relogio relogioId) {
		this.relogioId = relogioId;
	}

	public ConfiguracoesWebServer getConfiguracoesWebServerId() {
		return configuracoesWebServerId;
	}

	public void setConfiguracoesWebServerId(ConfiguracoesWebServer configuracoesWebServerId) {
		this.configuracoesWebServerId = configuracoesWebServerId;
	}

	public HorarioVerao getHorarioVeraoId() {
		return horarioVeraoId;
	}

	public void setHorarioVeraoId(HorarioVerao horarioVeraoId) {
		this.horarioVeraoId = horarioVeraoId;
	}

	public Rep getRepId() {
		return repId;
	}

	public void setRepId(Rep repId) {
		this.repId = repId;
	}

	public Coleta getColetaId() {
		return coletaId;
	}

	public void setColetaId(Coleta coletaId) {
		this.coletaId = coletaId;
	}

	public Empregado getEmpregadoId() {
		return empregadoId;
	}

	public void setEmpregadoId(Empregado empregadoId) {
		this.empregadoId = empregadoId;
	}

	public ConfiguracoesCartoes getConfiguracoesCartoesId() {
		return configuracoesCartoesId;
	}

	public void setConfiguracoesCartoesId(ConfiguracoesCartoes configuracoesCartoesId) {
		this.configuracoesCartoesId = configuracoesCartoesId;
	}

	public ConfiguracoesSenha getConfiguracoesSenhaId() {
		return configuracoesSenhaId;
	}

	public void setConfiguracoesSenhaId(ConfiguracoesSenha configuracoesSenhaId) {
		this.configuracoesSenhaId = configuracoesSenhaId;
	}

	public UsuarioBio getUsuarioBioId() {
		return usuarioBioId;
	}

	public void setUsuarioBioId(UsuarioBio usuarioBioId) {
		this.usuarioBioId = usuarioBioId;
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
		if (!(object instanceof Tarefa)) {
			return false;
		}
		Tarefa other = (Tarefa) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.api.rep.entity.Tarefa[ id=" + id + " ]";
	}

	/**
	 * Converte a entidade para objeto DTO
	 * 
	 * @return ComandoDeEnvio
	 */
	public ComandoDeEnvio toComandoDeEnvio() {
		ComandoDeEnvio dto = new ComandoDeEnvio();
		if (this.tipoOperacao != null) {
			dto.settOp(CONSTANTES.TIPO_OPERACAO.get(this.tipoOperacao).ordinal());
		}
		if (this.tipoTarefa != null) {
			dto.setUrl(CmdHandler.TIPO_CMD.get(this.tipoTarefa).getUrl(tipoUrl == null ? 0 : tipoUrl));
			dto.settCmd(CmdHandler.TIPO_CMD.get(this.tipoTarefa).ordinal());
		}
		dto.setCpf(cpf);
		dto.setdCmd(this.toComandoDTO());
		dto.setNsu(this.id);
		return dto;
	}

	/**
	 * Converte a Tarefa para o tipo de dado específico
	 * 
	 * @return DadosComando
	 */
	public Cmd toComandoDTO() {

		if (this.coletaId != null) {
			return this.coletaId.toColetaCmd();
		} else if (this.configuracoesRedeId != null) {
			return this.configuracoesRedeId.toConfiguracoesRedeCmd();
		} else if (this.empregadoId != null) {
			return this.empregadoId.toEmpregadoDTO();
		} else if (this.empregadorId != null) {
			return this.empregadorId.toEmpregadorDTO();
		} else if (this.configuracoesCartoesId != null) {
			return this.configuracoesCartoesId.toConfiguracoesCartoesCmd();
		} else if (this.configuracoesSenhaId != null) {
			return this.configuracoesSenhaId.toConfiguracaoCmd();
		} else if (this.relogioId != null) {
			return this.relogioId.toRelogioCmd();
		} else if (this.horarioVeraoId != null) {
			return this.horarioVeraoId.toHorarioVeraoCmd();
		} else if (this.ajustesBioId != null) {
			return this.ajustesBioId.toAjustesBioCmd();
		} else if (this.configuracoesWebServerId != null) {
			return this.configuracoesWebServerId.toConfigurcacoesWebServer();
		} else if (this.coletaDumpingId != null) {
			return this.coletaDumpingId.toColetaDumpingCmd();
		} else if (this.usuarioBioId != null) {
			return this.usuarioBioId.toUsuarioBioCmd();
		} else {
			return null;
		}
	}

	public static Tarefa clear(Tarefa tarefa) {
		tarefa.setColetaId(null);
		tarefa.setConfiguracoesRedeId(null);
		tarefa.setEmpregadoId(null);
		tarefa.setEmpregadorId(null);
		tarefa.setRepId(null);
		tarefa.setConfiguracoesCartoesId(null);
		tarefa.setConfiguracoesSenhaId(null);
		tarefa.setRelogioId(null);
		tarefa.setHorarioVeraoId(null);
		tarefa.setAjustesBioId(null);
		tarefa.setConfiguracoesWebServerId(null);
		tarefa.setColetaDumpingId(null);
		return tarefa;

	}
}
