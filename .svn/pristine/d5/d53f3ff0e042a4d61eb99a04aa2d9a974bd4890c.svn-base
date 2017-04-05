package com.api.rep.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.api.rep.contantes.CONSTANTES;
import com.api.rep.entity.Rep;
import com.api.rep.service.ServiceException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	public Rep parseToken(String token) {
		try {
			if (token == null || token.equals("") || token.length() < 10) {
				// throw new ServiceException(HttpStatus.UNAUTHORIZED);
				return null;
			}
			Claims body = Jwts.parser().setSigningKey(CONSTANTES.AUTH_KEY).parseClaimsJws(token).getBody();

			Rep rep = new Rep();
			rep.setNumeroSerie(body.getSubject());

			return rep;

		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}

	public String generateToken(String serie) {
		// TOKEN com 10 minuto de validade
		return Jwts.builder().setSubject(serie).signWith(SignatureAlgorithm.HS256, CONSTANTES.AUTH_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000 * 1000)).compact();
	}

	public Rep extractToken(HttpServletRequest request) throws ServiceException {
		return this.parseToken(request.getHeader("Authorization"));

	}

}
