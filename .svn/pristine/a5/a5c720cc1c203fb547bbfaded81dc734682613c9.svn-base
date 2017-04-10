package com.api.rep.rest.comandos;

import java.io.IOException;
import java.util.Collection;
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
import com.api.rep.dto.comunicacao.RespostaSevidorDTO;
import com.api.rep.entity.Empregado;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.EmpregadoService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Requisições Rest empregado.<br>
 * O Rep utiliza esta requisições para enviar a Lista de empregado ou um
 * empregado específico para o servidor
 * 
 * @author juliano.ezequiel
 *
 */
@RestController
public class EmpregadoRestController extends ApiRestController {

	@Autowired
	private EmpregadoService empregadoService;

	/**
	 * Consulta todos os empregados na base de dados
	 * 
	 * @return
	 */
	@RequestMapping(value = CONSTANTES.URL_EMPREGADO, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Collection<Empregado>> buscarTodos() {
		return new ResponseEntity<Collection<Empregado>>(this.empregadoService.listar(), HttpStatus.OK);
	}

	/**
	 * Recebe do rep o empregado previamente solicitado
	 * 
	 * @param empregadoCmd
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = CONSTANTES.URL_EMPREGADO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receber(@RequestParam("File") MultipartFile dados)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {
		this.empregadoService.receber(dados, this.getRepAutenticado());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Recebe do rep a lista com as empregados previamente solicitado
	 * 
	 * @param empregadoDTOList
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping(value = CONSTANTES.URL_LISTA_EMPREGADO, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberLista(@RequestParam("File") MultipartFile dados)
			throws ServiceException, JsonParseException, JsonMappingException, IOException {
		this.empregadoService.receberLista(dados, this.getRepAutenticado());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Recebe do Rep o dumping da lista de empregados
	 * 
	 * @param nsu
	 * @param arquivoListaEmpregados
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = CONSTANTES.URL_LISTA_EMPREGADO_DUMPING
			+ "/{nsu}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receberDumping(@PathVariable("nsu") Integer nsu,
			@RequestParam("File") MultipartFile arquivoListaEmpregados) throws ServiceException {
		this.empregadoService.receberDumping(arquivoListaEmpregados, this.getRepAutenticado(), nsu);
		return new ResponseEntity<RespostaSevidorDTO>(HttpStatus.OK);
	}

	/**
	 * Envia para Rep o dumping da lista de empregados
	 * 
	 * @param nsu
	 * @param arquivoListaEmpregados
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@RequestMapping(value = CONSTANTES.URL_LISTA_EMPREGADO_DUMPING
			+ "/{nsu}", produces = MediaType.MULTIPART_FORM_DATA_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> enviarDump(@PathVariable("nsu") Integer nsu) throws ServiceException, IOException {
		HashMap<String, Object> map = this.empregadoService.enviarDump(nsu, this.getRepAutenticado());
		return ResponseEntity.ok().contentLength((long) map.get("tamanho"))
				.contentType(MediaType.parseMediaType(MediaType.MULTIPART_FORM_DATA_VALUE)).body(map.get("dump"));
	}

}
