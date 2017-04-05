package com.api.rep.service.comandos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.dao.IdentificadoresRepository;
import com.api.rep.dto.comandos.IdentificadoresCmd;
import com.api.rep.entity.Identificadores;
import com.api.rep.entity.Rep;
import com.api.rep.service.ApiService;
import com.api.rep.service.ServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class IndentificadoresService extends ApiService {

	@Autowired
	private IdentificadoresRepository identificadoresRepository;

	public void salvar(MultipartFile dados, Rep repAutenticado)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {
		
		repAutenticado = this.getRepService().buscarPorNumeroSerie(repAutenticado);
		IdentificadoresCmd identificadoresCmd = this.getMapper().readValue(
				this.getServiceUtils().dadosCripto(repAutenticado, dados), IdentificadoresCmd.class);
		LOGGER.info("Identificadores : " + this.getMapper().writeValueAsString(identificadoresCmd));
		Identificadores identificadores = identificadoresCmd.toIdentificadores();
		identificadores.setId(
				repAutenticado.getIndentificadoresId() != null ? repAutenticado.getIndentificadoresId().getId() : null);
		this.identificadoresRepository.save(identificadores);

	}

}
