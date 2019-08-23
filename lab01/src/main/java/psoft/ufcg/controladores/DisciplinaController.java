package psoft.ufcg.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.dto.DisciplinaDTO;
import psoft.ufcg.dto.DisciplinasDTO;
import psoft.ufcg.entities.Disciplina;
import psoft.ufcg.entities.NomeDisciplina;
import psoft.ufcg.entities.NotaDisciplina;
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
	public ResponseEntity<Disciplina> postDisciplina(@RequestBody Disciplina newDisciplina) {
		return new ResponseEntity<Disciplina>(disciplinaService.postDisciplina(newDisciplina), HttpStatus.OK);
	}

	@RequestMapping("/v1/api/disciplinas")
	public ResponseEntity<DisciplinasDTO> getDisciplinas(){
		return new ResponseEntity<DisciplinasDTO>(disciplinaService.getDisciplinas(), HttpStatus.OK);
	}
	
	@RequestMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<DisciplinaDTO> getDisciplina(@PathVariable("id") int id){
		return disciplinaService.getDisciplina(id);
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<DisciplinaDTO> putNomeInDisciplina(@PathVariable("id") int id, @RequestBody NomeDisciplina nmDisciplina){
		return disciplinaService.putNomeInDisciplina(id, nmDisciplina.getNome());
	}
	
	@PutMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<DisciplinaDTO> putNotaInDisciplina(@PathVariable("id") int id, @RequestBody NotaDisciplina ntDisciplina){
		return disciplinaService.putNotaInDisciplina(id, ntDisciplina.getNota());
	}
	
	@RequestMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<DisciplinasDTO> getRankingDisciplinas(){
		return new ResponseEntity<DisciplinasDTO>(disciplinaService.getRankingDisciplinas(), HttpStatus.OK);
	}
	
	@DeleteMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<DisciplinaDTO> delDisciplina(@PathVariable("id") int id){
		return disciplinaService.delDisciplina(id);
	}
	
}
