package psoft.ufcg.controllers;

import java.util.Optional;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.entities.Usuario;
import psoft.ufcg.services.JWTService;
import psoft.ufcg.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private JWTService jwtService;

	@PostMapping("/login")
	public LoginResponse authenticate(@RequestBody Usuario usuario) throws ServletException {
		Optional<Usuario> authUsuario = usuarioService.getUsuario(usuario.getEmail());
		if (!authUsuario.isPresent())
			throw new ServletException("Usuario nao encontrado!");
		verifyPassword(usuario, authUsuario);

		String token = jwtService.generateToken(authUsuario.get().getEmail());
		return new LoginResponse(token);

	}

	@DeleteMapping("/usuarios")
	public ResponseEntity<Usuario> deleteUsuario(@RequestHeader("authorization") String authorizationToken) {
		Optional<Usuario> usuario = null;
		try {
			String emailSubjectToken = jwtService.getSubjectToken(authorizationToken);
			usuario = usuarioService.findById(emailSubjectToken);
			usuarioService.deleteUsuario(emailSubjectToken);
		} catch (ServletException e) {

		}
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);

	}

	private void verifyPassword(Usuario usuario, Optional<Usuario> authUsuario) throws ServletException {
		if (!authUsuario.get().getSenha().equals(usuario.getSenha())) {
			throw new ServletException("Senha invalida!");
		}
	}

	private class LoginResponse {
		private String token;

		public LoginResponse(String token) {
			this.setToken(token);
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}
}
