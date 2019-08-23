package psoft.ufcg.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import psoft.ufcg.dto.DisciplinaDTO;
import psoft.ufcg.entities.Disciplina;

@Service
public class DisciplinaService {

	List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public DisciplinaDTO addDisciplina(Disciplina newDisciplina) {
		int id = disciplinas.size();
		disciplinas.add(newDisciplina);
		
		return new DisciplinaDTO(id, newDisciplina);
	}

	public List<DisciplinaDTO> getDisciplinas() {
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		
		for(int id=0; id < disciplinas.size(); id++) {
			if(this.disciplinas.get(id) != null) {
				disciplinas.add(new DisciplinaDTO(id, this.disciplinas.get(id)));
			}
		}
		return disciplinas;
	}
	
}
