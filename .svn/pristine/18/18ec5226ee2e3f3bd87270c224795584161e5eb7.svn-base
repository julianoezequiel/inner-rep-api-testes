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
import com.api.rep.dto.comandos.InfoCmd;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.InfoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class InfoRestController extends ApiRestController {

	@Autowired
	private InfoService infoService;

	@RequestMapping(value = CONSTANTES.URL_INFO, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberInfo(@RequestBody InfoCmd infoCmd)
			throws ServiceException, JsonProcessingException {
		LOGGER.info("Informações do Rep : " + this.getMapper().writeValueAsString(infoCmd));
		this.infoService.salvar(infoCmd,this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
}
