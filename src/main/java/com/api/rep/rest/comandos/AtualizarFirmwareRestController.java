package com.api.rep.rest.comandos;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.AtualizarFirmwareService;

@RestController
public class AtualizarFirmwareRestController extends ApiRestController {

	@Autowired
	private AtualizarFirmwareService atualizarFirmwareService;

	@RequestMapping(value = CONSTANTES.URL_ATUALIZACAO_FW
			+ "/{nsu}", produces = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> enviarFirmware(@PathVariable("nsu") Integer nsu) throws ServiceException {
		HashMap<String, Object> map = this.atualizarFirmwareService.enviarFirmware(nsu, this.getRepAutenticado());
		return ResponseEntity.ok().contentLength((long) map.get("tamanho"))
				.contentType(MediaType.parseMediaType(MediaType.MULTIPART_FORM_DATA_VALUE)).body(map.get("fw"));
	}

	@RequestMapping(value = CONSTANTES.URL_ATUALIZACAO_PAGINAS
			+ "/{nsu}", produces = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> enviarPaginas(@PathVariable("nsu") Integer nsu) throws ServiceException {
		HashMap<String, Object> map = this.atualizarFirmwareService.enviarPaginas(nsu, this.getRepAutenticado());
		return ResponseEntity.ok().contentLength((long) map.get("tamanho"))
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(map.get("paginas"));
	}

	@RequestMapping(value = "/enviar/arquivos", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> uploadArquivo(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile arquivoBiometria) throws ServiceException {
		return new ResponseEntity<>(this.atualizarFirmwareService.uploadArquivo(name, arquivoBiometria), HttpStatus.OK);
	}
}
