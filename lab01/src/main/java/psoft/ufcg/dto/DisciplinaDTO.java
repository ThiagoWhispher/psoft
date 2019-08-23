package psoft.ufcg.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import psoft.ufcg.entities.Disciplina;

public class DisciplinaDTO extends Disciplina{
	
	private int id;
	
	@JsonCreator
	public DisciplinaDTO(int id, String nome, double nota) {
		super(nome, nota);
		this.id = id;
	}
	
	public DisciplinaDTO(int id, Disciplina disciplina) {
		this(id, disciplina.getNome(), disciplina.getNota());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[id]: " + getId() + "\n" + super.toString();
	}
	
}
