package psoft.ufcg.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import psoft.ufcg.utils.Lab02ApplicationConstants;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String headerAuthorization = req.getHeader("Authorization");

		if (headerAuthorization == null || !headerAuthorization.startsWith("Bearer "))
			throw new ServletException("Token inexistente ou mal formatado!");

		String token = headerAuthorization.substring(Lab02ApplicationConstants.TOKEN_INDEX);

		try {
			Jwts.parser().setSigningKey(Lab02ApplicationConstants.TOKEN_KEY).parseClaimsJws(token).getBody();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}

		chain.doFilter(request, response);
	}
}
