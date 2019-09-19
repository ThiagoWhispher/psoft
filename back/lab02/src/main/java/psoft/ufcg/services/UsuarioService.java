package psoft.ufcg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psoft.ufcg.daos.UsuarioRepository;
import psoft.ufcg.entities.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository<Usuario, String> usuarioRepository;

	public Optional<Usuario> getUsuario(String email) {
		return this.usuarioRepository.findById(email);
	}

	private boolean existsUsuario(Usuario usuario) {
		return usuarioRepository.findById(usuario.getEmail()).isPresent();
	}
	
	public boolean addUsuario(Usuario usuario) {
		boolean canCreate = !existsUsuario(usuario); 
		
		if(canCreate) this.usuarioRepository.save(usuario);
		
		return canCreate;
	}

	public void deleteUsuario(String email) {
		this.usuarioRepository.deleteById(email);
	}

	public Optional<Usuario> findById(String email) {
		return this.usuarioRepository.findById(email);
	}
	
}
