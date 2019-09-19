package psoft.ufcg.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import psoft.ufcg.daos.DisciplinaRepository;
import psoft.ufcg.dtos.DisciplinaIdNome;
import psoft.ufcg.entities.Disciplina;
import psoft.ufcg.utils.Lab02ApplicationConstants;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository<Disciplina, Long> disciplinaRepository;

	@PostConstruct
	public void initAlunos() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/disciplinas.json");
		try {
			List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);

			if (this.disciplinaRepository.count() != Lab02ApplicationConstants.QUANT_DISCIPLINAS) {
				this.disciplinaRepository.deleteAll();
				this.disciplinaRepository.saveAll(disciplinas);
				System.out.println("Disciplinas salvas no banco de dados");
			}
		} catch (IOException e) {
			System.out.println("Não foi possível salvar as disciplinas: " + e.getMessage());
		}
	}

	public List<DisciplinaIdNome> getDisciplinas() {
		List<Disciplina> disciplinasBD = this.disciplinaRepository.findAll();
		List<DisciplinaIdNome> disciplinasDTO = new ArrayList<DisciplinaIdNome>();

		for (Disciplina disciplina : disciplinasBD)
			disciplinasDTO.add(new DisciplinaIdNome(disciplina.getId(), disciplina.getNome()));
		
		return disciplinasDTO;
	}

	public Optional<Disciplina> getDisciplina(Long id) {
		return this.disciplinaRepository.findById(id);
	}

	public boolean existsDisciplina(Long id) {
		return this.disciplinaRepository.findById(id).isPresent();
	}

	public void updateDisciplina(Disciplina disciplina) {
		this.disciplinaRepository.save(disciplina);
	}

	public List<Disciplina> getRankingDisciplinasLikes() {
		return this.disciplinaRepository.findAll(new Sort(Sort.Direction.DESC, "likes"));
	}

	public List<Disciplina> getRankingDisciplinasNota() {
		return this.disciplinaRepository.findAll(new Sort(Sort.Direction.DESC, "nota"));
	}

}
