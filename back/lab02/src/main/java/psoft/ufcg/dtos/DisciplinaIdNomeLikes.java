package psoft.ufcg.dtos;

public class DisciplinaIdNomeLikes {
	private Long id;
	private String nome;
	private Integer likes;

	public DisciplinaIdNomeLikes(Long id, String nome, Integer likes) {
		this.id = id;
		this.nome = nome;
		this.likes = likes;
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

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

}
