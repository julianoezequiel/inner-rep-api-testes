package com.api.rep.rest.comandos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.IdentificadoresCmd;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.IndentificadoresService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class IdentificadoresRestController extends ApiRestController {

	@Autowired
	private IndentificadoresService indentificadoresService;

	@RequestMapping(value = CONSTANTES.URL_IDENTFICACAO, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberConfigIdentificadores(@RequestBody IdentificadoresCmd identificadoresCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Identificadores : " + this.getMapper().writeValueAsString(identificadoresCmd));
		this.indentificadoresService.salvar(identificadoresCmd, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
}
