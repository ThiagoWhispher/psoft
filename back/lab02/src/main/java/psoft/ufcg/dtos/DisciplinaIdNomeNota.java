package psoft.ufcg.dtos;

public class DisciplinaIdNomeNota {
	private Long id;
	private String nome;
	private Double nota;
	
	public DisciplinaIdNomeNota(Long id, String nome, Double nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

}
