package com.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res,
			final FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;

		final String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			throw new ServletException(
					"Missing or invalid Authorization header.");
		}

		final String token = authHeader;

		try {
			final Claims claims = Jwts.parser().setSigningKey("dacasecretkey")
					.parseClaimsJws(token).getBody();
			request.setAttribute("claims", claims);
		} catch (final SignatureException e) {
			throw new ServletException("Invalid token.");
		}

		chain.doFilter(req, res);
	}

}