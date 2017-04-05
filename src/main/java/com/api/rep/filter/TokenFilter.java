package com.api.rep.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.entity.Rep;
import com.api.rep.service.ServiceException;
import com.api.rep.service.rep.RepService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class TokenFilter extends GenericFilterBean {

	private final static Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class.getName());

	@Autowired
	private RepService repService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("Authorization");

		if (token == null || token.equals("") || token.length() < 10) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Token inexistente ou inválido");
		} else {

			// token valido
			try {
				Claims body = Jwts.parser().setSigningKey(CONSTANTES.AUTH_KEY).parseClaimsJws(token).getBody();

				Rep rep = this.repService.buscarPorNumeroSerie(body.getSubject());
				LOGGER.info("Número Série Rep : " + rep.getNumeroSerie());

			} catch (JwtException | ClassCastException | ServiceException e) {
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "não autorizado");
			}

		}
		filterChain.doFilter(request, response);

	}

}
