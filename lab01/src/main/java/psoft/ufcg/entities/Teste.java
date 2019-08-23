package psoft.ufcg.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Teste{
	
	private String greet;

	@JsonCreator
	public Teste(String greet) {
		this.greet = greet;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
	
}