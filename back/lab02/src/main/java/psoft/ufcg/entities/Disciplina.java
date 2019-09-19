package psoft.ufcg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	private Double nota;
	private String comentarios;
	private Integer likes;

	public Disciplina(@JsonProperty("nome") String nome) {
		this.nome = nome;
		this.nota = 0.0;
		this.comentarios = "";
		this.likes = 0;
	}
	
	public Disciplina() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	@Override
	public String toString() {
		return "[id]: " + id + "\n" +
				"[nome]: " + nome + "\n" +
				"[nota]: " + nota + "\n" +
				"[comentarios]: " + comentarios + "\n" +
				"[likes]: " + likes + "\n";
	}

}
