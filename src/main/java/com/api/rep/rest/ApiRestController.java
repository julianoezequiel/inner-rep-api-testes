package com.api.rep.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rep.entity.Rep;
import com.api.rep.service.ServiceException;
import com.api.rep.service.rep.RepService;
import com.api.rep.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ApiRestController {

	public final static Logger LOGGER = LoggerFactory.getLogger(ApiRestController.class.getName());

	@Autowired
	private RepService repService;

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ObjectMapper mapper;

	public JwtUtil getJwtutil() {
		return jwtutil;
	}

	public void setJwtutil(JwtUtil jwtutil) {
		this.jwtutil = jwtutil;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * Extrai do token o número serial do Rep e cria om objeto Rep
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Rep getRepAutenticado() throws ServiceException {
		Rep rep = this.getJwtutil().extractToken(this.getRequest());
		if (rep == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Token inválido");
		}
		return rep;
	}

	public Rep buscarRepPorNumSerie(String numSerie) throws ServiceException {
		Rep rep = this.repService.buscarPorNumeroSerie(numSerie);
		if (rep == null) {
			throw new ServiceException(HttpStatus.UNAUTHORIZED, "Rep não encontrado");
		}
		return rep;
	}
}
