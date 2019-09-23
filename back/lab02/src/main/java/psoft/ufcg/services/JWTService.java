package psoft.ufcg.services;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import psoft.ufcg.utils.Lab02ApplicationConstants;

@Service
public class JWTService {

	public String generateToken(String email) {
		return Jwts.builder().setSubject(email)
				.signWith(SignatureAlgorithm.HS512, Lab02ApplicationConstants.TOKEN_KEY)
				.setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000)).compact();
	}
	
	public String getSubjectToken(String authorizationHeader) throws ServletException {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer "))
			throw new ServletException("Token inexistente ou mal formatado!");

		String token = authorizationHeader.substring(Lab02ApplicationConstants.TOKEN_INDEX);

		String subject = null;
		try {
			subject = Jwts.parser().setSigningKey(Lab02ApplicationConstants.TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
		} catch (SignatureException e) {
			throw new ServletException("Token invalido ou expirado!");
		}
		return subject;
	}
}
