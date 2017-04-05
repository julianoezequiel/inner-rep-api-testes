package com.api.rep.dto.comunicacao;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class RespostaSevidorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

	public RespostaSevidorDTO(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}

	public RespostaSevidorDTO() {
	}

	public synchronized HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public synchronized void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
