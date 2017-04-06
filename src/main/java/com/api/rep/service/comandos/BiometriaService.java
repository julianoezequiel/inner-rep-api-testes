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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.UsuarioBioRepository;
import com.api.rep.dto.comandos.ListaBio;
import com.api.rep.entity.Empregado;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.entity.UsuarioBio;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.api.rep.service.tarefa.TarefaService;

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
		UsuarioBio usuarioBio;
		if (!tarefas.isEmpty()) {
			try {
				Tarefa tarefa = tarefas.iterator().next();
				if (tarefa.getUsuarioBioId() != null) {

					InputStream data = entity.getInputStream();

					byte[] template = this.getDecriptoAES().decript(repAutenticado.getChaveAES(),
							IOUtils.toByteArray(data));

					usuarioBio = this.usuarioBioRepository.buscarPorPis(tarefa.getUsuarioBioId().getPis());
					if (usuarioBio == null) {
						usuarioBio = new UsuarioBio();
						usuarioBio.setPis(tarefa.getEmpregadoId().getEmpregadoPis());
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
		UsuarioBio usuarioBio;
		if (!tarefas.isEmpty()) {
			Tarefa tarefa = tarefas.iterator().next();
			if (tarefa.getUsuarioBioId() != null) {
				usuarioBio = this.usuarioBioRepository.buscarPorPis(tarefa.getUsuarioBioId().getPis());
				if (usuarioBio != null) {

					byte[] dados = this.getCriptoAES().cripto(repAutenticado.getChaveAES(), usuarioBio.getTemplate());
					InputStream inputStream = new ByteArrayInputStream(dados);

					isr = new InputStreamResource(inputStream);
					inputStream.close();
					map.put("arquivo", isr);
					map.put("tamanho", (long) dados.length);
					// convFile.deleteOnExit();
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
	 */
	public void receberListaBioAgendarDigitais(ListaBio listaBio, Rep repAutenticado) {

		if (listaBio != null && listaBio.getPisList() != null) {
			listaBio.getPisList().stream().forEach(pis -> {
				try {
					Tarefa tarefa = tarefaService.tarefaTeste(CONSTANTES.TIPO_OPERACAO.RECEBER.name(), repAutenticado);
					tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.BIOMETRIA.ordinal());
					Empregado empregado = new Empregado(pis);
					tarefa.setEmpregadoId(empregado);
					this.tarefaService.salvar(tarefa);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

	}

}
