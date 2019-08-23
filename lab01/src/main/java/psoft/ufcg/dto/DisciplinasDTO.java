package psoft.ufcg.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DisciplinasDTO {

	List<DisciplinaDTO> disciplinas;
	
	@JsonCreator
	public DisciplinasDTO(List<DisciplinaDTO> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<DisciplinaDTO> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaDTO> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
