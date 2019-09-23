package psoft.ufcg.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import psoft.ufcg.utils.Lab02ApplicationConstants;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String headerAuthorization = req.getHeader("Authorization");

		if (headerAuthorization == null || !headerAuthorization.startsWith("Bearer ")) {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}else {
			String token = headerAuthorization.substring(Lab02ApplicationConstants.TOKEN_INDEX);

			try {
				Jwts.parser().setSigningKey(Lab02ApplicationConstants.TOKEN_KEY).parseClaimsJws(token).getBody();
			} catch (SignatureException | ExpiredJwtException | MalformedJwtException | PrematureJwtException
					| UnsupportedJwtException | IllegalArgumentException e) {
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
				return;
			}

			chain.doFilter(request, response);
		}
	}
}
