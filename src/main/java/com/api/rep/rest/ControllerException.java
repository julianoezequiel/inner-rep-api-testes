package com.api.rep.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.rep.service.ServiceException;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<?> handleException(ServiceException se) {
		return new ResponseEntity<RespostaException>(new RespostaException(se.getMessage(), se.getHttpStatus()),
				se.getHttpStatus());
	}

	@SuppressWarnings("unused")
	private class RespostaException {

		public String message;
		public HttpStatus httpStatus;

		public RespostaException(String message, HttpStatus httpStatus) {
			super();
			this.message = message != null ? message : "";
			this.httpStatus = httpStatus !=null ? httpStatus:HttpStatus.ACCEPTED;
		}

	}
}
