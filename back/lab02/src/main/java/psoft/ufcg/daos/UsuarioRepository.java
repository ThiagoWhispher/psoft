package psoft.ufcg.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psoft.ufcg.entities.Usuario;

@Repository
public interface UsuarioRepository<T, ID extends Serializable> extends JpaRepository<Usuario, String>{

}
