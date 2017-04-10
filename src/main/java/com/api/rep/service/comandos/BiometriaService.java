package com.api.rep.service.comandos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.UsuarioBioRepository;
import com.api.rep.dto.comandos.ListaBio;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.entity.UsuarioBio;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.api.rep.service.tarefa.TarefaService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class BiometriaService extends ApiService {

	@Autowired
	private UsuarioBioRepository usuarioBioRepository;

	@Autowired
	private TarefaService tarefaService;

	/**
	 * Variável para armazenar a lista Bio
	 */
	public static HashMap<String, ListaBio> LISTA_BIO = new HashMap<>();

	/**
	 * Recebe a biometria do funcionário e salva na base de dados
	 * 
	 * @param entity
	 * @param repAutenticado
	 * @param nsu
	 * @throws ServiceException
	 */
	public void receber(MultipartFile entity, Rep repAutenticado, Integer nsu) throws ServiceException {
		LOGGER.info("Biometria Recebida.");
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		List<Tarefa> tarefas = this.getTarefaRepository().buscarPorNsu(nsu);
		List<UsuarioBio> usuarioBioList;
		if (!tarefas.isEmpty()) {
			try {
				Tarefa tarefa = tarefas.iterator().next();
				if (tarefa.getUsuarioBioId() != null) {

					InputStream data = entity.getInputStream();

					byte[] template = this.getDecriptoAES().decript(repAutenticado.getChaveAES(),
							IOUtils.toByteArray(data));
					UsuarioBio usuarioBio;
					usuarioBioList = this.usuarioBioRepository.buscarPorPis(tarefa.getUsuarioBioId().getPis());
					if (usuarioBioList.isEmpty()) {
						usuarioBio = new UsuarioBio();
						usuarioBio.setPis(tarefa.getEmpregadoId().getEmpregadoPis());
					} else {
						usuarioBio = usuarioBioList.iterator().next();
						usuarioBio.setPis(tarefa.getUsuarioBioId().getPis());
					}

					usuarioBio.setTemplate(template);

					this.usuarioBioRepository.saveAndFlush(usuarioBio);
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Recebe a lista biometrica e armazena em memoria
	 * 
	 * @param listaBio
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void receberListaBio(MultipartFile dados, Rep repAutenticado) throws IOException, ServiceException {

		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		ListaBio listaBio = this.getMapper().readValue(this.getServiceUtils().dadosCripto(repAutenticado, dados),
				ListaBio.class);

		if (listaBio != null && !listaBio.getPisList().isEmpty()) {
			LISTA_BIO.put(repAutenticado.getNumeroSerie(), listaBio);
			LOGGER.info("Total Funcionários :" + listaBio.getPisList().size());
			LOGGER.info(this.getMapper().writeValueAsString(listaBio));
		}

	}

	/**
	 * Envia a biometria do funionário para o Rep
	 * 
	 * @param nsu
	 * @param repAutenticado
	 * @return
	 * @throws ServiceException
	 */
	public HashMap<String, Object> enviar(Integer nsu, Rep repAutenticado) throws ServiceException, IOException {

		HashMap<String, Object> map = new HashMap<>();

		InputStreamResource isr = null;
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		List<Tarefa> tarefas = this.getTarefaRepository().buscarPorNsu(nsu);
		List<UsuarioBio> usuarioBioList;
		if (!tarefas.isEmpty()) {
			Tarefa tarefa = tarefas.iterator().next();
			if (tarefa.getUsuarioBioId() != null) {
				usuarioBioList = this.usuarioBioRepository.buscarPorPis(tarefa.getUsuarioBioId().getPis());
				if (!usuarioBioList.isEmpty() && usuarioBioList.get(0).getTemplate() != null) {

					byte[] dados = this.getCriptoAES().cripto(repAutenticado.getChaveAES(),
							usuarioBioList.get(0).getTemplate());
					InputStream inputStream = new ByteArrayInputStream(dados);

					isr = new InputStreamResource(inputStream);
					inputStream.close();
					map.put("arquivo", isr);
					map.put("tamanho", (long) dados.length);
				} else {
					throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Sem digital na base");
				}
			}
		}
		return map;
	}

	/**
	 * Retorna a lista Bio armazenada em memória
	 * 
	 * @param rep
	 * @return
	 * @throws ServiceException
	 */
	public Collection<ListaBio> getListaBio() throws ServiceException {
		return BiometriaService.LISTA_BIO.values();
	}

	/**
	 * Recebe a lista de usuários biometrico e agenda o recebimento das digitais
	 * dos usuário
	 * 
	 * @param listaBio
	 * @param repAutenticado
	 * @throws ServiceException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public void receberListaBioAgendarDigitais(MultipartFile dados, Rep repAutenticado)
			throws JsonParseException, JsonMappingException, IOException, ServiceException {

		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		ListaBio listaBio = this.getMapper().readValue(this.getServiceUtils().dadosCripto(repAutenticado, dados),
				ListaBio.class);

		Thread t = new Thread(new AgendarTarefasReceberBio(repAutenticado, listaBio));
		t.start();

	}

	/**
	 * Thread de agendamento para receber as digitais
	 * 
	 * @author juliano.ezequiel
	 *
	 */
	private class AgendarTarefasReceberBio implements Runnable {

		private Rep repAutenticado;
		private ListaBio listaBio;

		public AgendarTarefasReceberBio(Rep repAutenticado, ListaBio listaBio) {
			super();
			this.repAutenticado = repAutenticado;
			this.listaBio = listaBio;
		}

		@Override
		public void run() {
			if (this.listaBio != null && this.listaBio.getPisList() != null) {
				this.listaBio.getPisList().stream().forEach(pis -> {
					try {
						Tarefa tarefa = tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(),
								this.repAutenticado);
						tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.BIOMETRIA.ordinal());

						List<UsuarioBio> usuarioBioList = usuarioBioRepository.buscarPorPis(pis);
						UsuarioBio usuarioBio;
						if (!usuarioBioList.isEmpty()) {
							usuarioBio = usuarioBioList.iterator().next();
						} else {
							usuarioBio = new UsuarioBio();
							usuarioBio.setPis(pis);
						}

						usuarioBio = usuarioBioRepository.saveAndFlush(usuarioBio);

						tarefa.setUsuarioBioId(usuarioBio);
						tarefa = tarefaService.salvar(tarefa);
						LOGGER.info("Tarefa agendada receber biometria : " + getMapper().writeValueAsString(tarefa));
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}

		}
	}

	public void agendarTarefasEnvioBio(String numSerie) throws ServiceException {
		Rep repAutenticado = this.getRepService().buscarPorNumeroSerie(numSerie);
		Thread t = new Thread(new AgendarEnvioDeBiometrias(repAutenticado));
		t.start();
	}

	private class AgendarEnvioDeBiometrias implements Runnable {

		public AgendarEnvioDeBiometrias(Rep repAutenticado) {
			super();
			this.repAutenticado = repAutenticado;
		}

		private final Rep repAutenticado;

		@Override
		public void run() {
			List<UsuarioBio> usuarioBioList = usuarioBioRepository.findAll();

			usuarioBioList.stream().forEach(usuarioBio -> {
				Tarefa tarefa;
				try {
					tarefa = tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.ENVIAR.name(), this.repAutenticado);

					tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.BIOMETRIA.ordinal());
					tarefa.setUsuarioBioId(usuarioBio);
					tarefa = tarefaService.salvar(tarefa);
					LOGGER.info("Tarefa agendada receber biometria : " + getMapper().writeValueAsString(tarefa));
				} catch (ServiceException | JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

	}

}
