package com.api.rep.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.entity.Rep;
import com.api.rep.service.ServiceException;
import com.api.rep.service.rep.RepService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Autowired
	private RepService repService;
	
	public Rep parseToken(String token) throws ServiceException {
		try {
			if (token == null || token.equals("") || token.length() < 10) {
				// throw new ServiceException(HttpStatus.UNAUTHORIZED);
				return null;
			}
			Claims body = Jwts.parser().setSigningKey(CONSTANTES.AUTH_KEY).parseClaimsJws(token).getBody();
			
			Rep rep = new Rep();
			rep.setNumeroSerie(body.getSubject());
			
			return repService.buscarPorNumeroSerie(rep);

		} catch (JwtException | ClassCastException e) {
			throw  new ServiceException(HttpStatus.UNAUTHORIZED);
		}
	}

	public String generateToken(String serie) {
		// TOKEN com 10 minuto de validade
		return Jwts.builder().setSubject(serie).signWith(SignatureAlgorithm.HS256, CONSTANTES.AUTH_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000 * 24)).compact();
	}

	public Rep extractToken(HttpServletRequest request) throws ServiceException {
		return this.parseToken(request.getHeader("Authorization"));

	}

}
