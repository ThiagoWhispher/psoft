package psoft.ufcg.comparators;

import java.util.Comparator;

import psoft.ufcg.entities.Disciplina;

public class ComparadorPorNota implements Comparator<Disciplina>{

	@Override
	public int compare(Disciplina o1, Disciplina o2) {
		return o2.getNota().compareTo(o1.getNota());
	}


}
