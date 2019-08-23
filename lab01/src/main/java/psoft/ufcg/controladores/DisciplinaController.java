package psoft.ufcg.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.dto.DisciplinaDTO;
import psoft.ufcg.entities.Disciplina;
import psoft.ufcg.entities.Teste;
import psoft.ufcg.services.DisciplinaService;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@RequestMapping("/v1/api/teste")
	public ResponseEntity<Teste> getTest() {
		return new ResponseEntity<Teste>(new Teste("Hii, i'm Spring Boot Application"), HttpStatus.OK);
	}

	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody Disciplina newDisciplina) {
		return new ResponseEntity<Disciplina>(disciplinaService.addDisciplina(newDisciplina), HttpStatus.OK);
	}

	
	@RequestMapping("/v1/api/disciplinas")
	public ResponseEntity<List<DisciplinaDTO>> getDisciplinas(){
		return new ResponseEntity<List<DisciplinaDTO>>(disciplinaService.getDisciplinas(), HttpStatus.OK);
	}
	
}
