package psoft.ufcg.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import psoft.ufcg.comparators.ComparadorPorNota;
import psoft.ufcg.dto.DisciplinaDTO;
import psoft.ufcg.dto.DisciplinasDTO;
import psoft.ufcg.entities.Disciplina;

@Service
public class DisciplinaService {

	List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public DisciplinaDTO postDisciplina(Disciplina newDisciplina) {
		int id = disciplinas.size();
		disciplinas.add(newDisciplina);
		
		return new DisciplinaDTO(id, newDisciplina);
	}

	public DisciplinasDTO getDisciplinas() {
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		
		for(int id=0; id < this.disciplinas.size(); id++) {
			if(this.disciplinas.get(id) != null)
				disciplinas.add(new DisciplinaDTO(id, this.disciplinas.get(id)));
		}
		
		return new DisciplinasDTO(disciplinas);
	}
	
	public ResponseEntity<DisciplinaDTO> getDisciplina(int id){
		if(id < 0 || id >= this.disciplinas.size())
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
		
		Disciplina disciplina = this.disciplinas.get(id);
		if(disciplina != null)
			return new ResponseEntity<DisciplinaDTO>(new DisciplinaDTO(id, disciplina), HttpStatus.OK);
		else
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<DisciplinaDTO> putNomeInDisciplina(int id, String nome) {
		if(id < 0 || id >= this.disciplinas.size())
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
		
		Disciplina disciplina = this.disciplinas.get(id);
		if(disciplina != null) {
			disciplina.setNome(nome);
			return new ResponseEntity<DisciplinaDTO>(new DisciplinaDTO(id, disciplina), HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<DisciplinaDTO> putNotaInDisciplina(int id, double nota) {
		if(id < 0 || id >= this.disciplinas.size())
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
		
		Disciplina disciplina = this.disciplinas.get(id);
		if(disciplina != null) {
			disciplina.setNota(nota);
			return new ResponseEntity<DisciplinaDTO>(new DisciplinaDTO(id, disciplina), HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
		
	}

	public ResponseEntity<DisciplinaDTO> delDisciplina(int id) {
		if(id < 0 || id >= this.disciplinas.size())
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
		
		Disciplina disciplina = this.disciplinas.get(id);
		if(disciplina != null) {
			DisciplinaDTO disciplinaRet = new DisciplinaDTO(id, disciplina);
			this.disciplinas.set(id, null);
			return new ResponseEntity<DisciplinaDTO>(disciplinaRet, HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaDTO>(HttpStatus.NOT_FOUND);
	}
	
	public DisciplinasDTO getRankingDisciplinas() {
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		
		for(int id=0; id < this.disciplinas.size(); id++) {
			if(this.disciplinas.get(id) != null)
				disciplinas.add(new DisciplinaDTO(id, this.disciplinas.get(id)));
		}
		
		Collections.sort(disciplinas, new ComparadorPorNota());
				
		return new DisciplinasDTO(disciplinas);
	}
}
