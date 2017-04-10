package com.api.rep.service.status;

import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.VerificacaoCmd;
import com.api.rep.dto.comunicacao.ComandoDeEnvio;
import com.api.rep.dto.comunicacao.RespostaRepDTO;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.dto.comunicacao.StatusDTO;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.CmdHandler;
import com.api.rep.service.comandos.ColetaService;
import com.api.rep.service.comandos.ConfiguracaoService;
import com.api.rep.service.rep.RepService;
import com.api.rep.service.tarefa.TarefaService;
import com.api.rep.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class StatusService extends ApiService {

	@Autowired
	private ConfiguracaoService configuracaoService;

	@Autowired
	private RepService repService;

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private ColetaService coletaService;

	@Value("${coleta.auto}")
	Boolean coletaAuto;

	@Value("${coleta.config}")
	Boolean coletaConfig;

	/**
	 * Valida as informações enviados pelo status do Rep
	 * 
	 * @param status
	 * @param rep
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	public byte[] validarStatus(HttpServletRequest request, MultipartFile dados, Rep rep)
			throws ServiceException, IOException {
		try {
			rep = this.getRepService().buscarPorNumeroSerie(rep);

			StatusDTO status = this.getMapper().readValue(this.getServiceUtils().dadosCripto(rep, dados),
					StatusDTO.class);

			rep = validarDadosEntrada(status, rep);

			atualizarStatus(rep, request);

			// agendamento auto das configuracoes
			if (coletaConfig) {
				this.configuracaoService.validarAlteracoesConfiguracoes(rep, status);
			}
			// agendamento auto da coleta
			if (coletaAuto) {
				this.tarefaService.agendarReceberColeta(rep, status);
			}

			// retorna a próxima Tarefa para o rep
			String proximaTarefa = this.getMapper().writeValueAsString(proximaTarefa(rep));
			// System.out.println(proximaTarefa);
			byte[] proxTarefa = Utils.stringToByteM16(proximaTarefa);
			// System.out.println("size " + proxTarefa.length);
			byte[] cripto = this.getCriptoAES().cripto(rep.getChaveAES(), proxTarefa);
			// System.out.println(Arrays.toString(cripto));
			// System.out.println("size cripto " + cripto.length);
			return cripto;
		} catch (Exception e) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED);
		}

	}

	/**
	 * busca a próxima Tarefa para Rep executar
	 * 
	 * @param rep
	 * @return
	 * @throws ServiceException
	 * @throws JsonProcessingException
	 */
	private ComandoDeEnvio proximaTarefa(Rep rep) throws ServiceException, JsonProcessingException {

		rep = this.getRepService().buscarPorNumeroSerie(rep.getNumeroSerie());

		ComandoDeEnvio dto = null;

		if (rep.getTarefaCollection().iterator().hasNext()) {
			dto = rep.getTarefaCollection().iterator().next().getId() != null ? rep.getTarefaCollection().stream()
					.sorted(Comparator.comparing(Tarefa::getId)).iterator().next().toComandoDeEnvio()
					: rep.getTarefaCollection().iterator().next().toComandoDeEnvio();
		}

		if (dto != null) {
			if (CmdHandler.TIPO_CMD.VERIFICA_LISTA_BIO.ordinal() == dto.gettCmd()) {
				VerificacaoCmd verificacaoCmd = new VerificacaoCmd();
				verificacaoCmd.setVerTipo(2);
				dto.setdCmd(verificacaoCmd);
			}
			LOGGER.info("Tarefa NSU : {} - Tipo Tarefa : {} - Operação : {}", new Object[] { dto.getNsu(),
					CmdHandler.TIPO_CMD.get(dto.gettCmd()), CONSTANTES.TIPO_OPERACAO.get(dto.gettOp()) });
			LOGGER.info("Dados do comando - " + this.getMapper().writeValueAsString(dto.getdCmd()));
			LOGGER.info("------------------------");

			return dto;
		} else {
			dto = new ComandoDeEnvio();
			dto.settOp(CONSTANTES.TIPO_OPERACAO.NENHUMA.ordinal());
			LOGGER.info("Sem pendencia");
			LOGGER.info("------------------------");
			return dto;
		}
	}

	/**
	 * Valida os dados recebido pelo status
	 * 
	 * @param status
	 * @param rep
	 * @return {@link Rep}
	 * @throws ServiceException
	 */
	private Rep validarDadosEntrada(StatusDTO status, Rep rep) throws ServiceException {
		if (status == null || status.getUltimoNsr() == null || status.getUltimoNsr() == null) {
			throw new ServiceException(HttpStatus.PARTIAL_CONTENT, "Status inválido");
		}

		if (rep == null) {
			throw new ServiceException(HttpStatus.EXPECTATION_FAILED, "Erro ao realizar a operação");
		}

		// busca na base a referencia do rep
		rep = this.getRepService().buscarPorNumeroSerie(rep);

		return rep;

	}

	/**
	 * Valida o resultado de uma tarefa executada pelo Rep
	 * 
	 * @param respostaRep
	 * @param repAutenticado
	 * @return {@link RespostaSevidorDTO}
	 * @throws ServiceException
	 */
	public RespostaSevidorDTO validarRespostaRep(RespostaRepDTO respostaRep, Rep repAutenticado)
			throws ServiceException {

		RespostaSevidorDTO respostaSevidorDTO = new RespostaSevidorDTO();
		try {
			// se existe um NSU
			if (respostaRep != null && respostaRep.getNSU() != null && !respostaRep.getStatus().isEmpty()) {
				// busca o NSU
				Rep rep = this.getRepService().buscarPorNumeroSerie(repAutenticado);

				if (rep != null) {
					// Teste basico, verifica se existe um status ok na resposta
					// do
					// rep
					Tarefa tarefa = this.getTarefaRepository().findOne(respostaRep.getNSU());

					if (respostaRep.getStatus().stream()
							.anyMatch(r -> r != CONSTANTES.STATUS_COM_REP.HTTPC_RESULT_FALHA.ordinal())) {

						// se foi uma resposta de sucesso, excluir a Tarefa
						if (tarefa != null) {
							// salva o arquivo do dump da coleta
							if (tarefa.getTipoTarefa().equals(CmdHandler.TIPO_CMD.COLETA_DUMPING.ordinal())) {
								coletaService.salvarArquivoDumpEmDisco(tarefa.getId());
							}

							// Remove os vínculos
							tarefa = Tarefa.clear(tarefa);
							this.getTarefaRepository().save(tarefa);
							this.getTarefaRepository().delete(tarefa);
							respostaSevidorDTO.setHttpStatus(HttpStatus.OK);
							LOGGER.info("Tarefa NSU : " + tarefa.getId() + " removida");

						}
					} else {
						tarefa.setTentativas(tarefa.getTentativas() == null ? 0 : tarefa.getTentativas() + 1);
						this.getTarefaRepository().save(tarefa);
					}

				} else {
					respostaSevidorDTO.setHttpStatus(HttpStatus.UNAUTHORIZED);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return respostaSevidorDTO;
	}

	private void atualizarStatus(Rep rep, HttpServletRequest request) {
		rep.setUltimoIp(request.getRemoteAddr());
		rep.setUltimaConexao(new Date());
		this.repService.salvar(rep);
	}

}
