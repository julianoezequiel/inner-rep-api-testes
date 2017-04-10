package com.api.rep.service.rep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.ConfiguracoesRedeRepository;
import com.api.rep.dao.InfoRepository;
import com.api.rep.dao.RepRepository;
import com.api.rep.dao.TarefaRepository;
import com.api.rep.dto.RepMonitor;
import com.api.rep.dto.comunicacao.RepDTO;
import com.api.rep.entity.ConfiguracoesRede;
import com.api.rep.entity.Info;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.CmdHandler;

@Service
public class RepService {

	@Autowired
	private RepRepository repRepository;

	@Autowired
	private ConfiguracoesRedeRepository configuracoesRedeRepository;

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private InfoRepository infoRepository;

	// busca todos os rep existentes na base
	public Collection<RepDTO> buscarTodos() {
		Collection<Rep> reps = repRepository.findAll();
		Collection<RepDTO> listaDTO = new ArrayList<>();
		reps.stream().forEach(rep -> {
			listaDTO.add(new RepDTO(rep));
		});
		return listaDTO;
	}

	public Collection<Rep> buscarTodosRep() {
		return this.repRepository.findAll();
	}

	public Rep getRep() throws ServiceException {
		List<Rep> listRep = this.repRepository.findAll();
		if (!listRep.isEmpty()) {
			return listRep.iterator().next();
		} else {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Não existe Rep Cadastrado");
		}
	}

	public Rep buscarPorNumeroSerie(String numSerie) throws ServiceException {
		Rep repTeste = new Rep();
		repTeste.setNumeroSerie(numSerie);
		Rep rep = this.repRepository.findOne(Example.of(repTeste));
//		Rep rep = this.repRepository.buscarPorNumeroSerie(numSerie);
		if (rep == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}
		return rep;
	}

	public Rep buscarPorNumeroSerie(Rep rep) throws ServiceException {

		if (rep == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não cadastrado");
		}
		return this.buscarPorNumeroSerie(rep.getNumeroSerie());
	}

	// inclui um rep na base
	public RepDTO salvar(RepDTO repDTO) throws ServiceException {

		if (repDTO.getNumeroSerie() == null || repDTO.getNumeroSerie().equals("")) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Número de série obrigatório");
		}
		if (repDTO.getChaveComunicacao() == null || repDTO.getChaveComunicacao().equals("")) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Chave de comunicação obrigatória");
		}
		Rep rep;
		Rep repTeste = this.repRepository.buscarPorNumeroSerie(repDTO.getNumeroSerie());
		if (repTeste != null) {
			rep = repTeste;
			rep.setNumeroSerie(repDTO.getNumeroSerie());
			rep.setChaveComunicacao(repDTO.getChaveComunicacao());
		} else {
			rep = repDTO.getRep();
		}
		ConfiguracoesRede configuracoesRede = new ConfiguracoesRede();
		configuracoesRede = this.configuracoesRedeRepository.save(configuracoesRede);

		Info info = new Info();
		info = this.infoRepository.save(info);

		rep.setConfiguracoesRedeId(configuracoesRede);
		rep.setInfoId(info);
		rep = this.repRepository.save(rep);

		// agenda o recebimento das configurações de Rede
		Tarefa tarefaConfigRede = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaConfigRede.setRepId(rep);
		tarefaConfigRede.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_REDE.ordinal());
		tarefaConfigRede.setConfiguracoesRedeId(configuracoesRede);
		this.tarefaRepository.save(tarefaConfigRede);

		// agenda o recebimento das info
		Tarefa tarefaInfo = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaInfo.setRepId(rep);
		tarefaInfo.setTipoTarefa(CmdHandler.TIPO_CMD.INFO.ordinal());
		this.tarefaRepository.save(tarefaInfo);

		return new RepDTO(rep);
	}

	public RepDTO salvarUnico(RepDTO repDTO) throws ServiceException {

		if (repDTO.getNumeroSerie() == null || repDTO.getNumeroSerie().equals("")) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Número de série obrigatório");
		}
		if (repDTO.getChaveComunicacao() == null || repDTO.getChaveComunicacao().equals("")) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Chave de comunicação obrigatória");
		}
		Rep repTeste = this.repRepository.buscarPorNumeroSerie(repDTO.getNumeroSerie());
		if (repTeste != null) {
			this.repRepository.delete(repTeste);
		}
		Rep rep = repDTO.getRep();
		ConfiguracoesRede configuracoesRede = new ConfiguracoesRede();
		configuracoesRede = this.configuracoesRedeRepository.save(configuracoesRede);

		Info info = new Info();
		info = this.infoRepository.save(info);

		rep.setConfiguracoesRedeId(configuracoesRede);
		rep.setInfoId(info);
		rep = this.repRepository.save(rep);

		// agenda o recebimento das configurações de Rede
		Tarefa tarefaConfigRede = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaConfigRede.setRepId(rep);
		tarefaConfigRede.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_REDE.ordinal());
		tarefaConfigRede.setConfiguracoesRedeId(configuracoesRede);
		this.tarefaRepository.save(tarefaConfigRede);

		// agenda o recebimento das info
		Tarefa tarefaInfo = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaInfo.setRepId(rep);
		tarefaInfo.setTipoTarefa(CmdHandler.TIPO_CMD.INFO.ordinal());
		this.tarefaRepository.save(tarefaInfo);

		return new RepDTO(rep);
	}

	public RepDTO atualizar(RepDTO repDTO) throws ServiceException {

		if (repDTO.getNumeroSerie() == null) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Número de série obrigatório");
		}

		Rep rep = this.buscarPorNumeroSerie(repDTO.getNumeroSerie());
		if (rep == null) {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Número não encontrado");
		}
		repDTO.setId(rep.getId());
		ConfiguracoesRede configuracoesRede = new ConfiguracoesRede();
		configuracoesRede = this.configuracoesRedeRepository.save(configuracoesRede);

		Info info = new Info();
		info = this.infoRepository.save(info);

		rep = repDTO.getRep();
		rep.setConfiguracoesRedeId(configuracoesRede);
		rep.setInfoId(info);
		rep = this.repRepository.save(rep);

		// agenda o recebimento das configurações de Rede
		Tarefa tarefaConfigRede = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaConfigRede.setRepId(rep);
		tarefaConfigRede.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_REDE.ordinal());
		tarefaConfigRede.setConfiguracoesRedeId(configuracoesRede);
		this.tarefaRepository.save(tarefaConfigRede);

		// agenda o recebimento das info
		Tarefa tarefaInfo = new Tarefa();
		tarefaConfigRede.setCpf(CONSTANTES.CPF_TESTE);
		tarefaConfigRede.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefaInfo.setRepId(rep);
		tarefaInfo.setTipoTarefa(CmdHandler.TIPO_CMD.INFO.ordinal());
		this.tarefaRepository.save(tarefaInfo);

		return new RepDTO(rep);
	}

	public Rep salvar(Rep rep) {
		return this.repRepository.save(rep);
	}

	public String excluir(Integer id) throws ServiceException {
		Rep rep = this.repRepository.findOne(id);
		if (rep != null) {
			this.repRepository.delete(rep);
			return "Rep excluído com sucesso";
		} else {
			throw new ServiceException(HttpStatus.NO_CONTENT, "Rep não cadastrado");
		}
	}

	public Collection<RepMonitor> buscarRepMonitoramento() {
		List<RepMonitor> list = new ArrayList<>();
		this.repRepository.findAll().stream().forEach(r -> {
			list.add(r.toRepStatus());
		});
		return list;
	}

	public RepDTO buscar(Integer id) {
		return new RepDTO(this.repRepository.findOne(id));
	}

}
