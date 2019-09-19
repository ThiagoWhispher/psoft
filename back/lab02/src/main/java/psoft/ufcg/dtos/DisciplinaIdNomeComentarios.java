package psoft.ufcg.dtos;

public class DisciplinaIdNomeComentarios {
	private Long id;
	private String nome;
	private String comentarios;

	public DisciplinaIdNomeComentarios(Long id, String nome, String comentarios) {
		this.id = id;
		this.nome = nome;
		this.comentarios = comentarios;
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
