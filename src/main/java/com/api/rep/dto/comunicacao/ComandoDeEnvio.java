package com.api.rep.dto.comunicacao;

import java.io.Serializable;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.Cmd;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.comandos.CmdHandler;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Os comandos que o Rep executa seguem o padrão desta classe. Os nomes das
 * propriedades devem estar exatamente com as siglas: "nsu", "url", "cpf",
 * "tCmd", "tOp", "dCmd" e seguir esta ordem.
 * 
 * @author juliano.ezequiel
 *
 */
@JsonPropertyOrder(value = { "nsu", "url", "cpf", "tCmd", "tOp", "dCmd" })
public class ComandoDeEnvio implements Serializable {

	private static final long serialVersionUID = -6765797816369891472L;

	private Integer nsu;
	private String url;
	private Integer tOp;
	private Integer tCmd;
	private String cpf;

	private Cmd dCmd;

	public ComandoDeEnvio() {
	}

	public ComandoDeEnvio(CONSTANTES.TIPO_OPERACAO TIPO_OPERACAO, CmdHandler.TIPO_CMD TIPO_CMD, Integer nsu) {
		super();
		this.tOp = TIPO_OPERACAO.ordinal();
		this.tCmd = TIPO_CMD.ordinal();
		this.nsu = nsu;
	}

	public ComandoDeEnvio(Tarefa tarefa) {
		super();
		this.tOp = CONSTANTES.TIPO_OPERACAO.get(tarefa.getTipoOperacao()).ordinal();
		this.nsu = tarefa.getId();
		this.url = CmdHandler.TIPO_CMD.get(tarefa.getTipoTarefa()).getUrl(tarefa.getTipoUrl());
	}

	public Integer getNsu() {
		return nsu;
	}

	public void setNsu(Integer nsu) {
		this.nsu = nsu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer gettOp() {
		return tOp;
	}

	public void settOp(Integer tipoOperacao) {
		this.tOp = tipoOperacao;
	}

	public Cmd getdCmd() {
		return dCmd;
	}

	public void setdCmd(Cmd cmd) {
		this.dCmd = cmd;
	}

	public Integer gettCmd() {
		return tCmd;
	}

	public void settCmd(Integer tipoComando) {
		this.tCmd = tipoComando;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Tarefa toTarefa() {
		Tarefa tarefa = new Tarefa();
		this.dCmd.getClass().getSuperclass();
		return tarefa;
	}

}
