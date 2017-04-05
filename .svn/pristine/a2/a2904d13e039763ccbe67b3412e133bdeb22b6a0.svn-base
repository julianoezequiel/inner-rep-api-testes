package com.api.rep.rest.comandos;

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

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.dto.comandos.EmpregadorCmd;
import com.api.rep.entity.Empregador;
import com.api.rep.rest.ApiRestController;
import com.api.rep.service.ServiceException;
import com.api.rep.service.comandos.EmpregadorService;

@RestController
@RequestMapping(value = CONSTANTES.URL_EMPREGADOR)
public class EmpregadorRestController extends ApiRestController {

	@Autowired
	private EmpregadorService empregadorService;

	// TODO: Converter os objetos empregador em EmpregadorCmd

	/**
	 * Busca todos os Empregador, independente do numero do Rep
	 * 
	 * @return
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public ResponseEntity<Collection<Empregador>> buscarTodos() {
		return new ResponseEntity<Collection<Empregador>>(this.empregadorService.listar(), HttpStatus.OK);
	}

	/**
	 * Método utilizado para cadastrar um empregador
	 * 
	 * @param empregador
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "cadastro", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Empregador> salvar(@RequestBody Empregador empregador) throws ServiceException {
		return new ResponseEntity<Empregador>(this.empregadorService.salvar(empregador, this.getRepAutenticado()),
				HttpStatus.CREATED);
	}

	/**
	 * Método utilizado para atualizar um empregador
	 * 
	 * @param empregador
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "cadastro", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Empregador> atualizar(@RequestBody Empregador empregador) throws ServiceException {
		return new ResponseEntity<Empregador>(this.empregadorService.salvar(empregador, this.getRepAutenticado()),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "cadastro/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable Integer id) throws ServiceException {
		return new ResponseEntity<String>(this.empregadorService.excluirPorId(id), HttpStatus.OK);
	}

	/**
	 * Recebe do Rep o empregador
	 * 
	 * @param empregadorCmd
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> receber(@RequestBody EmpregadorCmd empregadorCmd) throws ServiceException {
		this.empregadorService.receber(empregadorCmd, this.getRepAutenticado());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
