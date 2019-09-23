package psoft.ufcg.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.dtos.DisciplinaIdNome;
import psoft.ufcg.dtos.DisciplinaIdNomeComentarios;
import psoft.ufcg.dtos.DisciplinaIdNomeLikes;
import psoft.ufcg.dtos.DisciplinaIdNomeNota;
import psoft.ufcg.entities.Disciplina;
import psoft.ufcg.services.DisciplinaService;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping("/api/disciplinas")
	public ResponseEntity<List<DisciplinaIdNome>> getDisciplinas(){
		return new ResponseEntity<List<DisciplinaIdNome>>(disciplinaService.getDisciplinas(), HttpStatus.OK);
	}
	
	@GetMapping("/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") Long id){
		Optional<Disciplina> disciplinaOpt = this.disciplinaService.getDisciplina(id);
		
		if(disciplinaOpt.isPresent())
			return new ResponseEntity<Disciplina>(disciplinaOpt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/disciplinas/likes/{id}")
	public ResponseEntity<DisciplinaIdNomeLikes> putDisciplinaLikes(@PathVariable("id") Long id){
		Optional<Disciplina> disciplinaOpt = this.disciplinaService.getDisciplina(id);
		
		if(disciplinaOpt.isPresent()) {
			Disciplina disciplina = disciplinaOpt.get();
			disciplina.setLikes(disciplina.getLikes()+1);
			this.disciplinaService.updateDisciplina(disciplina);
			
			DisciplinaIdNomeLikes disciplinaDTO = new DisciplinaIdNomeLikes(disciplina.getId(),
					disciplina.getNome(), disciplina.getLikes());
			return new ResponseEntity<DisciplinaIdNomeLikes>(disciplinaDTO, HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaIdNomeLikes>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/disciplinas/nota/{id}")
	public ResponseEntity<DisciplinaIdNomeNota> putDisciplinaNota(@PathVariable("id") Long id, @RequestBody Disciplina disciplinaNota){
		Optional<Disciplina> disciplinaOpt = this.disciplinaService.getDisciplina(id);
		
		if(disciplinaOpt.isPresent()) {
			Disciplina disciplina = disciplinaOpt.get();
			disciplina.setNota(disciplinaNota.getNota());
			this.disciplinaService.updateDisciplina(disciplina);
			
			DisciplinaIdNomeNota disciplinaDTO = new DisciplinaIdNomeNota(disciplina.getId(),
					disciplina.getNome(), disciplina.getNota());
			return new ResponseEntity<DisciplinaIdNomeNota>(disciplinaDTO, HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaIdNomeNota>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/disciplinas/comentarios/{id}")
	public ResponseEntity<DisciplinaIdNomeComentarios> putDisciplinaComentario(@PathVariable("id") Long id, @RequestBody Disciplina disciplinaComentario){
		Optional<Disciplina> disciplinaOpt = this.disciplinaService.getDisciplina(id);
		
		if(disciplinaOpt.isPresent()) {
			Disciplina disciplina = disciplinaOpt.get();
			disciplina.setComentarios(disciplina.getComentarios() + "\n" + disciplinaComentario.getComentarios());
			this.disciplinaService.updateDisciplina(disciplina);
			
			DisciplinaIdNomeComentarios disciplinaDTO = new DisciplinaIdNomeComentarios(disciplina.getId(),
					disciplina.getNome(), disciplina.getComentarios());
			return new ResponseEntity<DisciplinaIdNomeComentarios>(disciplinaDTO, HttpStatus.OK);
		}else
			return new ResponseEntity<DisciplinaIdNomeComentarios>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/api/disciplinas/ranking/notas")
	public ResponseEntity<List<Disciplina>> getRankingDisciplinasNota(){
		return new ResponseEntity<List<Disciplina>>(disciplinaService.getRankingDisciplinasNota(), HttpStatus.OK);
	}
	
	@GetMapping("/api/disciplinas/ranking/likes")
	public ResponseEntity<List<Disciplina>> getRankingDisciplinasLikes(){
		return new ResponseEntity<List<Disciplina>>(disciplinaService.getRankingDisciplinasLikes(), HttpStatus.OK);
	}
	
}
