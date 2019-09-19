package psoft.ufcg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.entities.Usuario;
import psoft.ufcg.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> addUsuario(@RequestBody Usuario usuario){
		boolean wasCreated = usuarioService.addUsuario(usuario);
		
		HttpStatus responseStatus = wasCreated? HttpStatus.CREATED : HttpStatus.FORBIDDEN;
		
		return new ResponseEntity<Object>(responseStatus); 
	}
	
}
