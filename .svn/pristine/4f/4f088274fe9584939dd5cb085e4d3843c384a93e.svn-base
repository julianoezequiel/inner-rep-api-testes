package com.api.rep.rest.rep;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.dto.RepMonitor;
import com.api.rep.dto.comunicacao.RepDTO;
import com.api.rep.service.ServiceException;
import com.api.rep.service.rep.RepService;

@RestController
@RequestMapping(value = "cadastro/rep")
public class RepRestController {

	@Autowired
	private RepService repService;

	/**
	 * Lista os Rep cadastrados
	 * 
	 * @return
	 */
	@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Collection<RepDTO>> buscarTodos() {
		return new ResponseEntity<Collection<RepDTO>>(this.repService.buscarTodos(), HttpStatus.OK);
	}

	/**
	 * Lista um Rep pelo Id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<RepDTO> buscar(@PathVariable("id") Integer id) {
		return new ResponseEntity<RepDTO>(this.repService.buscar(id), HttpStatus.OK);
	}

	/**
	 * Lista um Rep pelo número de série
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "numserie/{numSerie}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<RepDTO> buscar(@PathVariable("numSerie") String numSerie) throws ServiceException {
		return new ResponseEntity<RepDTO>(new RepDTO(this.repService.buscarPorNumeroSerie(numSerie)), HttpStatus.OK);
	}

	/**
	 * Atualiza um Rep pelo id
	 * 
	 * @param id
	 * @param repDTO
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<RepDTO> salvar(@RequestBody RepDTO repDTO) throws ServiceException {
		return new ResponseEntity<RepDTO>(this.repService.atualizar(repDTO), HttpStatus.CREATED);
	}

	/**
	 * Insere um Rep novo
	 * 
	 * @param id
	 * @param repDTO
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<RepDTO> salvarRep(@RequestBody RepDTO repDTO) throws ServiceException {
		return new ResponseEntity<RepDTO>(this.repService.salvarUnico(repDTO), HttpStatus.CREATED);
	}

	@RequestMapping(value = "multirep", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<RepDTO> salvarRepMult(@RequestBody RepDTO repDTO) throws ServiceException {
		return new ResponseEntity<RepDTO>(this.repService.salvar(repDTO), HttpStatus.CREATED);
	}

	/**
	 * Exclui um Rep pelo id
	 * 
	 * @param id
	 * @return {@link RepDTO}
	 * @throws ServiceException
	 */
	@RequestMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable Integer id) throws ServiceException {
		return new ResponseEntity<String>(this.repService.excluir(id), HttpStatus.OK);
	}

	/**
	 * Realiza o monitoramento dos rep
	 * 
	 * @return
	 */
	@RequestMapping(value = "/monitoramento", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Collection<RepMonitor>> buscarRepMonitoramento() {
		return new ResponseEntity<Collection<RepMonitor>>(this.repService.buscarRepMonitoramento(), HttpStatus.OK);
	}
}
