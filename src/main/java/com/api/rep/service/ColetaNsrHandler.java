package com.api.rep.service;

import java.util.Optional;

import org.springframework.data.domain.Example;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.entity.Empregado;
import com.api.rep.entity.Nsr;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.comandos.CmdHandler;
import com.api.rep.utils.Utils;

public class ColetaNsrHandler {

	private static Nsr nsr = new Nsr();

	public ColetaNsrHandler() {
		ColetaNsrHandler.nsr = new Nsr();
	}

	public enum NSR_HANDLER {

		TIPO_NENHUM() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return null;
			}
		},
		TIPO_CABECALHO() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return null;
			}
		},
		TIPO_EMPREGADOR() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return tipoEmpregador(registro, apiService);
			}
		},
		TIPO_MARCACAO() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return tipoMarcacao(registro);
			}
		},
		TIPO_RELOGIO() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return tipoRelogio(registro, apiService);
			}
		},

		TIPO_EMPREGADO() {

			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return tipoEmpregado(registro, apiService);
			}
		},
		TIPO_EVENTOS() {
			@Override
			public Nsr convert(String registro, ApiService apiService) {
				return tipoEventosSensiveis(registro);
			}
		};

		public abstract Nsr convert(String registro, ApiService apiService);

		public static NSR_HANDLER get(String registro) {
			Integer tipo = getTipoNsr(registro);
			if (tipo != null) {
				for (NSR_HANDLER nsr : values()) {
					if (tipo.equals(nsr.ordinal())) {
						return nsr;
					}
				}
			}
			return null;
		}

	}

	public static Integer getNumNsr(String registro) {
		try {
			return Integer.parseInt(registro.substring(0, 9));
		} catch (Exception e) {
			return null;
		}
	}

	private static Integer getTipoNsr(String registro) {
		try {
			return Integer.parseInt(registro.substring(9, 10));
		} catch (Exception e) {
			return null;
		}
	}

	private static Nsr tipoEmpregador(String registro, ApiService apiService) {

		ColetaNsrHandler.nsr = new Nsr();
		ColetaNsrHandler.nsr.setNumeroNsr(getNumNsr(registro));
		ColetaNsrHandler.nsr.setTipo(getTipoNsr(registro));
		ColetaNsrHandler.nsr.setDataGravacao(Utils.converterStringParaData(registro.substring(10, 18)));
		ColetaNsrHandler.nsr.setHorarioGravacao(Utils.converterStringParaHora(registro.substring(18, 22)));
		ColetaNsrHandler.nsr.setCpfResponsavel(registro.substring(22, 36));
		ColetaNsrHandler.nsr.setTipoIndentificador(Integer.parseInt(registro.substring(36, 37)));
		ColetaNsrHandler.nsr.setCnpjCpf(registro.substring(37, 51));
		ColetaNsrHandler.nsr.setCei(registro.substring(51, 63));
		ColetaNsrHandler.nsr.setRazaoSocial(registro.substring(63, 213));
		ColetaNsrHandler.nsr.setLocal(registro.substring(215, 313));

		Tarefa tarefa = new Tarefa();
		tarefa.setCpf(CONSTANTES.CPF_TESTE);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADOR.ordinal());
		tarefa.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefa.setRepId(apiService.getRep());

		Tarefa teste = apiService.getTarefaRepository().findOne(Example.of(tarefa));
		if (teste == null) {
			apiService.getTarefaRepository().save(tarefa);
		}
		return ColetaNsrHandler.nsr;

	}

	private static Nsr tipoMarcacao(String registro) {

		ColetaNsrHandler.nsr = new Nsr();
		ColetaNsrHandler.nsr.setNumeroNsr(getNumNsr(registro));
		ColetaNsrHandler.nsr.setTipo(getTipoNsr(registro));
		ColetaNsrHandler.nsr.setDataMarcacao(Utils.converterStringParaData(registro.substring(10, 18)));
		ColetaNsrHandler.nsr.setHorarioMarcacao(Utils.converterStringParaHora(registro.substring(18, 22)));
		ColetaNsrHandler.nsr.setPis(registro.substring(22, 34));

		return ColetaNsrHandler.nsr;
	}

	private static Nsr tipoRelogio(String registro, ApiService apiService) {

		ColetaNsrHandler.nsr = new Nsr();
		ColetaNsrHandler.nsr.setNumeroNsr(getNumNsr(registro));
		ColetaNsrHandler.nsr.setTipo(getTipoNsr(registro));
		ColetaNsrHandler.nsr.setDataAntesAjuste(Utils.converterStringParaData(registro.substring(10, 18)));
		ColetaNsrHandler.nsr.setHoraAntesAjuste(Utils.converterStringParaHora(registro.substring(18, 22)));
		ColetaNsrHandler.nsr.setDataAjustada(Utils.converterStringParaData(registro.substring(22, 30)));
		ColetaNsrHandler.nsr.setHoraAjustada(Utils.converterStringParaHora(registro.substring(30, 34)));
		ColetaNsrHandler.nsr.setCpfResponsavel(registro.substring(34, 45));

		Tarefa tarefa = new Tarefa();
		tarefa.setCpf(CONSTANTES.CPF_TESTE);
		tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.CONFIG_RELOGIO.ordinal());
		tarefa.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
		tarefa.setRepId(apiService.getRep());

		apiService.getTarefaRepository().save(tarefa);

		return ColetaNsrHandler.nsr;

	}

	private static Nsr tipoEmpregado(String registro, ApiService apiService) {

		ColetaNsrHandler.nsr = new Nsr();

		String pis = registro.substring(23, 35);

		ColetaNsrHandler.nsr.setNumeroNsr(getNumNsr(registro));
		ColetaNsrHandler.nsr.setTipo(getTipoNsr(registro));
		ColetaNsrHandler.nsr.setDataGravacao(Utils.converterStringParaData(registro.substring(10, 18)));
		ColetaNsrHandler.nsr.setHorarioGravacao(Utils.converterStringParaHora(registro.substring(18, 22)));
		ColetaNsrHandler.nsr.setTipoOperacao(registro.substring(22, 23));
		ColetaNsrHandler.nsr.setPis(pis);
		ColetaNsrHandler.nsr.setNomeEmpregado(registro.substring(35, 87));
		ColetaNsrHandler.nsr.setDadosEmpregado(registro.substring(87, 91));
		ColetaNsrHandler.nsr.setCpfResponsavel(registro.substring(91, 102));

		Optional<Empregado> empregado = apiService.getEmpregadoRespository().buscarPorPis(pis, apiService.getRep());

		// se for uma inclusao solicita o novo empregado
		if (ColetaNsrHandler.nsr.getTipoOperacao().equalsIgnoreCase("I")) {
			Tarefa tarefa = new Tarefa();
			tarefa.setCpf(CONSTANTES.CPF_TESTE);
			tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADO.ordinal());
			tarefa.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.RECEBER.ordinal());
			tarefa.setRepId(apiService.getRep());
			if (empregado.isPresent()) {
				tarefa.setEmpregadoId(empregado.get());
			} else {

				Empregado novoEmpregado = new Empregado();
				novoEmpregado.setEmpregadoPis(pis);
				apiService.getEmpregadoRespository().save(novoEmpregado);
				tarefa.setEmpregadoId(novoEmpregado);
				apiService.getTarefaRepository().save(tarefa);
			}
			// se fir uma exclusão e existir o regitro, solicita a exclusao da
			// base
		} else if (empregado.isPresent() && ColetaNsrHandler.nsr.getTipoOperacao().equalsIgnoreCase("E")) {
			if (empregado.get().getTarefaCollection().isEmpty()) {
				apiService.getEmpregadoRespository().delete(empregado.get());
			} else {
				empregado.get().getTarefaCollection().stream().forEach(t -> {
					Tarefa.clear(t);
					apiService.getTarefaRepository().delete(t);
				});
				apiService.getEmpregadoRespository().delete(empregado.get());
			}
		}

		return ColetaNsrHandler.nsr;
	}

	private static Nsr tipoEventosSensiveis(String registro) {

		ColetaNsrHandler.nsr = new Nsr();
		ColetaNsrHandler.nsr.setNumeroNsr(getNumNsr(registro));
		ColetaNsrHandler.nsr.setTipo(getTipoNsr(registro));
		ColetaNsrHandler.nsr.setDataGravacao(Utils.converterStringParaData(registro.substring(10, 18)));
		ColetaNsrHandler.nsr.setHorarioGravacao(Utils.converterStringParaHora(registro.substring(18, 22)));
		ColetaNsrHandler.nsr.setTipoEvento(registro.substring(22, registro.length() - 1));

		return ColetaNsrHandler.nsr;
	}

}
