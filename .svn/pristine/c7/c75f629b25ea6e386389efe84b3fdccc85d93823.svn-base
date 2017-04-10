package com.api.rep.service.comandos;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.EmpregadorRepository;
import com.api.rep.dto.comandos.EmpregadorCmd;
import com.api.rep.entity.Empregador;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class EmpregadorService extends ApiService {

	@Autowired
	private EmpregadorRepository empregadorRepository;

	public Collection<Empregador> listar() {
		return this.empregadorRepository.findAll();
	}

	public Empregador buscarPorId(Integer id) {
		return this.empregadorRepository.findOne(id);
	}

	public String excluirPorId(Integer id) {
		// TODO:inserir nova Tarefa de envio para o rep
		this.empregadorRepository.delete(id);
		return "Empregador excluido com sucesso";
	}

	public List<Empregador> buscarPorIndentificador(String identificador) {
		return this.empregadorRepository.buscarPorIndentificador(identificador);
	}

	public Empregador salvar(Empregador empregador, Rep rep) throws ServiceException {
		// TODO:validar todos os dados do empregador
		if (empregador.getEmpregadorIdent() != null) {

			rep = this.getRepService().buscarPorNumeroSerie(rep);

			Empregador e = rep.getEmpregadorId();
			if (e != null) {
				empregador.setId(e.getId());
			}
			Tarefa tarefa = new Tarefa();
			tarefa.setCpf(CONSTANTES.CPF_TESTE);
			tarefa.setRepId(rep);
			tarefa.setTipoOperacao(CONSTANTES.TIPO_OPERACAO.ENVIAR.ordinal());
			tarefa.setTipoTarefa(CmdHandler.TIPO_CMD.EMPREGADOR.ordinal());

			empregador = this.empregadorRepository.save(empregador);

			rep.setEmpregadorId(empregador);

			this.getRepService().salvar(rep);

			tarefa.setEmpregadorId(empregador);
			this.getTarefaRepository().save(tarefa);
			return empregador;
		} else {
			throw new ServiceException(HttpStatus.PRECONDITION_FAILED, "Empregador Inválido");
		}
	}

	public void receber(MultipartFile dados, Rep rep)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {

		rep = this.getRepService().buscarPorNumeroSerie(rep);

		EmpregadorCmd empregadorCmd = this.getMapper().readValue(this.getServiceUtils().dadosCripto(rep, dados),
				EmpregadorCmd.class);

		LOGGER.info("----------- Empresa recebida --------------");
		LOGGER.info("Razão : " + empregadorCmd.geteRS());
		LOGGER.info("Identificador : " + empregadorCmd.geteId());
		LOGGER.info("Cei : " + empregadorCmd.geteCei());
		LOGGER.info("Local : " + empregadorCmd.geteLoc());
		LOGGER.info("Tipo ident : " + empregadorCmd.geteTpId());

		Empregador empregador2 = empregadorCmd.toEmpregador();

		if (rep.getEmpregadorId() != null) {
			empregador2.setId(rep.getEmpregadorId().getId());
		}
		this.empregadorRepository.save(empregador2);

	}

}
