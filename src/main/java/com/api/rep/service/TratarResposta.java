package com.api.rep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dao.TarefaRepository;
import com.api.rep.dto.comunicacao.RespostaRepDTO;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.entity.Rep;
import com.api.rep.entity.Tarefa;
import com.api.rep.service.rep.RepService;

@Component
public class TratarResposta {

	public final static Logger LOGGER = LoggerFactory.getLogger(TratarResposta.class.getName());
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@Autowired
	private RepService repService;
	
	public TarefaRepository getTarefaRepository() {
		return tarefaRepository;
	}

	public RespostaSevidorDTO validarRespostaRep(RespostaRepDTO respostaRep, Rep repAutenticado) throws ServiceException {
		RespostaSevidorDTO respostaSevidorDTO = new RespostaSevidorDTO();
		// se existe um NSU
		if (respostaRep.getNSU() != null && !respostaRep.getStatus().isEmpty()) {
			// busca o NSU
			Rep rep = this.repService.buscarPorNumeroSerie(repAutenticado.getNumeroSerie());
			if (rep != null) {
				// Teste basico, verifica se existe um status ok na resposta do
				// rep
				if (respostaRep.getStatus().stream()
						.anyMatch(r -> r != CONSTANTES.STATUS_COM_REP.HTTPC_RESULT_FALHA.ordinal())) {
					Tarefa tarefa = this.getTarefaRepository().findOne(respostaRep.getNSU());
					// se foi uma resposta de sucesso, excluir a Tarefa
					if (tarefa != null) {

						// Remove os vinculos
						tarefa = Tarefa.clear(tarefa);

						this.getTarefaRepository().save(tarefa);
						this.getTarefaRepository().delete(tarefa);
						respostaSevidorDTO.setHttpStatus(HttpStatus.OK);
						LOGGER.info("Tarefa NSU : " + tarefa.getId() + " removida");
					}
				}
			} else {
				respostaSevidorDTO.setHttpStatus(HttpStatus.NOT_MODIFIED);
			}
		}
		return respostaSevidorDTO;
	}

}
