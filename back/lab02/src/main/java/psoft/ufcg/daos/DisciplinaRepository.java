package psoft.ufcg.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import psoft.ufcg.entities.Disciplina;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long>{

}
