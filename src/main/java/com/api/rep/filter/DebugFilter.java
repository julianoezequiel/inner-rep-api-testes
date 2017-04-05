package com.api.rep.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

public class DebugFilter extends GenericFilterBean {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DebugFilter.class.getName());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		LOGGER.info("------------------------");
		LOGGER.info("Origem requisição IP : " + req.getRemoteAddr());
		LOGGER.info("Método  : " + req.getMethod());
		LOGGER.info("URL  : " + req.getRequestURL());
//		LOGGER.info("------------------------");
		filterChain.doFilter(request, response);
	}

}
