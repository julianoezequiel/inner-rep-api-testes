package com.api.rep.service.comandos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.EmpregadoRepository;
import com.api.rep.dto.comandos.EmpregadoCmd;
import com.api.rep.entity.Empregado;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class EmpregadoService extends ApiService {

	public static HashMap<String, byte[]> dumpingMap = new HashMap<>();

	private Rep rep;

	@Autowired
	private EmpregadoRepository empregadoRespository;

	public Collection<Empregado> listar() {
		return this.empregadoRespository.findAll();
	}

	public Empregado buscarPorId(Integer id) {
		return this.empregadoRespository.findOne(id);
	}

	public String excluirPorId(Integer id) {
		// TODO: inserir nova Tarefa de envio para o REP
		this.empregadoRespository.delete(id);
		return "Empregado excluido com sucesso";
	}

	public Empregado salvar(Empregado empregado, Rep repAutenticado) throws ServiceException {

		this.rep = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		if (empregado.getEmpregadoPis() != null) {

			// se ja existir atualiza o registro
			Optional<Empregado> e = this.empregadoRespository.buscarPorPis(empregado.getEmpregadoPis(), this.rep);

			if (e.isPresent()) {
				empregado.setId(e.get().getId());
			}

			// buscao o Rep atual
			repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);

			// cria a Tarefa
			Tarefa tarefa = new Tarefa();
			tarefa.setCpf("04752873982");
			tarefa.setRepId(repAutenticado);
			tarefa.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.ENVIAR.ordinal());
			tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADO.ordinal());

			// salva ou atualiza o empregado
			empregado = this.empregadoRespository.save(empregado);
			// vincula o empregado a pendencia
			tarefa.setEmpregadoId(empregado);
			// sava a pendencia
			this.getTarefaRepository().save(tarefa);

			return empregado;
		} else {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Empregado inválido");
		}

	}

	public void receber(MultipartFile dados, Rep repAutenticado)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {

		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		EmpregadoCmd empregadorDTO = this.getMapper()
				.readValue(this.getServiceUtils().dadosCripto(repAutenticado, dados), EmpregadoCmd.class);

		LOGGER.info("----------- Funcionário recebido --------------");
		LOGGER.info("Nome : " + empregadorDTO.getfNome());
		LOGGER.info("Nome exibição : " + empregadorDTO.getfNEx());
		LOGGER.info("Pis : " + empregadorDTO.getfPis());
		LOGGER.info("Número Teclado : " + empregadorDTO.getfCT());
		LOGGER.info("Número prox : " + empregadorDTO.getfCP());
		LOGGER.info("Número barras : " + empregadorDTO.getfCB());
		LOGGER.info("Senha : " + empregadorDTO.getfSenha());

		Optional<Empregado> empregado = this.getEmpregadoRespository().buscarPorPis(empregadorDTO.getfPis(), this.rep);
		if (empregado.isPresent()) {
			Empregado empregado2 = empregadorDTO.toEmpregado();
			empregado2.setId(empregado.get().getId());
			empregado2.setRepId(this.rep);
			this.getEmpregadoRespository().save(empregado2);
		}

	}

	public void receberLista(MultipartFile dados, Rep repAutenticado)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		String dadosDecrip = this.getServiceUtils().dadosCripto(repAutenticado, dados); 
		List<EmpregadoCmd> empregadoDTOList = this.getMapper().readValue(dadosDecrip,	this.getMapper().getTypeFactory().constructCollectionType(List.class, EmpregadoCmd.class));

		this.rep = this.getRepService().buscarPorNumeroSerie(repAutenticado);

		LOGGER.info("Lista Recebida");

		empregadoDTOList.stream().forEach(e -> {
			try {
				LOGGER.info("Empregado : " + this.getMapper().writeValueAsString(e));
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Optional<Empregado> empregadoOptional = this.empregadoRespository.buscarPorPis(e.getfPis(), this.rep);

			Empregado empregado = e.toEmpregado();
			if (empregadoOptional.isPresent()) {
				empregado.setId(empregadoOptional.get().getId());
			}
			empregado.setRepId(this.rep);
			this.empregadoRespository.save(empregado);
		});
	}
	
	
	public void receberDumping(MultipartFile entity, Rep repAutenticado, Integer nsu)
			throws ServiceException {
		try {
			repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
			
			InputStream data = entity.getInputStream();

			byte[] template = this.getDecriptoAES().decript(repAutenticado.getChaveAES(),
					IOUtils.toByteArray(data)); 
			LOGGER.info("Tamanho dump empregados armazenado : " + template.length);
			EmpregadoService.dumpingMap.put(repAutenticado.getNumeroSerie(), template);

			LOGGER.info("Dumping de empregados recebido");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Object> enviarDump(Integer nsu, Rep repAutenticado) throws ServiceException, IOException {
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		List<Tarefa> tarefas = this.getTarefaRepository().buscarPorNsu(nsu);
		InputStreamResource isr = null;
		HashMap<String, Object> map = new HashMap<>();

		if (!tarefas.isEmpty()) {

			if (EmpregadoService.dumpingMap.containsKey(repAutenticado.getNumeroSerie())) {
				
				byte[] dados = EmpregadoService.dumpingMap.get(repAutenticado.getNumeroSerie());
				LOGGER.info("Tamanho dump empregados lido : " + dados.length);
				byte[] dadoscripto = this.getCriptoAES().cripto(repAutenticado.getChaveAES(), dados);
				InputStream inputStream = new ByteArrayInputStream(dadoscripto);

				isr = new InputStreamResource(inputStream);
				inputStream.close();
				map.put("dump", isr);
				map.put("tamanho", (long) dadoscripto.length);
			} else {
				throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "não existe dump na memória do servidor");
			}
		}
		return map;
	}

}
