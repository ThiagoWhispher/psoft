package psoft.ufcg.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Disciplina {
	private String nome;
	private Double nota;
	
	@JsonCreator
	public Disciplina(String nome, Double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "[nome]: " + getNome() + "\n" +
				"[nota]: " + getNota() + "\n";
	}
	
	
}
