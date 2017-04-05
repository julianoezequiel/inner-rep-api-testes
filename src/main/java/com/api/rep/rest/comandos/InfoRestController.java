package com.api.rep.rest.comandos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.InfoService;

@RestController
public class InfoRestController extends ApiRestController {

	@Autowired
	private InfoService infoService;

	@RequestMapping(value = CONSTANTES.URL_INFO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberInfo(@RequestParam("File") MultipartFile dados)
			throws ServiceException, IOException {
		this.infoService.salvar(dados, this.getRepAutenticado());
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}
}
