package com.api.rep.service.tarefa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.contantes.CONSTANTES.TIPO_OPERACAO;
import com.api.rep.dao.ColetaRepository;
import com.api.rep.dao.NsrRepository;
import com.api.rep.dao.TarefaRepository;
import com.api.rep.dto.comunicacao.ComandoDeEnvio;
import com.api.rep.dto.comunicacao.StatusDTO;
import com.api.rep.entity.Coleta;
import com.api.rep.entity.Nsr;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.CmdHandler;

@Service
public class TarefaService extends ApiService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private NsrRepository nsrRepository;

	@Autowired
	private ColetaRepository coletaRepository;

	public void excluir(Integer id) {
		this.getTarefaRepository().delete(id);
	}

	public void excluirTodas() {
		this.tarefaRepository.deleteAll();
	}

	public void excluir(Tarefa tarefa) {
		this.getTarefaRepository().delete(tarefa);
	}

	public Tarefa getTarefa(Integer nsu) {
		List<Tarefa> list = this.tarefaRepository.buscarPorNsu(nsu);
		if (!list.isEmpty()) {
			return list.iterator().next();
		} else {
			return null;
		}
	}

	public Tarefa salvar(Tarefa tarefa) {
		return this.tarefaRepository.save(tarefa);
	}

	public Tarefa tarefaTeste(String operacao, Rep rep) throws ServiceException {
		Tarefa tarefa = null;
		if (rep != null) {
			rep = this.getRepService().buscarPorNumeroSerie(rep.getNumeroSerie());
			tarefa = new Tarefa();
			tarefa.setCpf(CONSTANTES.CPF_TESTE);
			tarefa.setTipoOperacao(getOperacao(operacao));
			tarefa.setRepId(rep);
		}
		return tarefa;

	}

	public int getOperacao(String s) {
		if (s.equalsIgnoreCase("receber")) {
			return CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal();
		} else if (s.equalsIgnoreCase("enviar")) {
			return CONSTANTES.TIPO_OPERACAO.ENVIAR.ordinal();
		} else if (s.equalsIgnoreCase("excluir")) {
			return CONSTANTES.TIPO_OPERACAO.EXCLUIR.ordinal();
		} else {
			return CONSTANTES.TIPO_OPERACAO.NENHUMA.ordinal();
		}
	}

	public Collection<ComandoDeEnvio> buscarTarefas(Rep rep) throws ServiceException {

		if (rep != null && rep.getNumeroSerie() != null) {
			rep = this.getRepService().buscarPorNumeroSerie(rep.getNumeroSerie());
		}

		Collection<ComandoDeEnvio> tarefasList = new ArrayList<>();

		if (rep != null && !rep.getTarefaCollection().isEmpty()) {
			rep.getTarefaCollection().stream().forEach(r -> {
				tarefasList.add(r.toComandoDeEnvio());
			});

			return tarefasList;

		} else {
			return null;
		}
	}

	public Collection<Tarefa> buscarTarefas() {
		return this.getTarefaRepository().findAll();
	}

	public void agendarReceberColeta(Rep rep, StatusDTO status) {

		// ultimo Nsr
		Nsr ultimoNsrColetado = this.nsrRepository.buscarUltimoNsr(rep.getId()); //

		if (ultimoNsrColetado == null) {
			ultimoNsrColetado = new Nsr();
			ultimoNsrColetado.setNumeroNsr(status.getUltimoNsr() > 100 ? status.getUltimoNsr() - 100 : 0);
		} else if (ultimoNsrColetado.getNumeroNsr() + 100 < status.getUltimoNsr()) {
			ultimoNsrColetado.setNumeroNsr(status.getUltimoNsr() - 100);
		}
		LOGGER.info("Ultimo NSR " + ultimoNsrColetado.getNumeroNsr());
		if (ultimoNsrColetado.getNumeroNsr() < status.getUltimoNsr()) {

			List<Tarefa> tarefaList = this.getTarefaRepository().buscarPorRep(rep);

			Tarefa tarefa = tarefaList.stream()
					.filter(p -> p.getId() != null && (p.getTipoTarefa().equals(CmdHandler.TIPO_CMD.COLETA.ordinal())
							&& p.getTipoOperacao().equals(TIPO_OPERACAO.RECEBER.ordinal())))
					.findFirst().orElse(new Tarefa());
			// se ja existe uma Tarefa do tipo coleta, atualiza o range
			// de coleta
			if (tarefa.getColetaId() != null) {
				tarefa.getColetaId().setColetaNsrInicio(ultimoNsrColetado.getNumeroNsr());
				tarefa.getColetaId().setColetaNsrFim(status.getUltimoNsr());
			} else {
				tarefa.setRepId(rep);
				tarefa.setColetaId(this.coletaRepository
						.save(new Coleta(ultimoNsrColetado.getNumeroNsr(), status.getUltimoNsr())));
				tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.COLETA.ordinal());
				tarefa.setTipoOperacao(TIPO_OPERACAO.RECEBER.ordinal());
			}

			this.getTarefaRepository().save(tarefa);
		}
	}

}
