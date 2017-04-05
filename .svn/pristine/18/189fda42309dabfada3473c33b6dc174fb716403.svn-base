package com.api.rep.service;

import org.springframework.http.HttpStatus;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus = HttpStatus.PRECONDITION_FAILED;

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ServiceException(HttpStatus httpStatus,String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
