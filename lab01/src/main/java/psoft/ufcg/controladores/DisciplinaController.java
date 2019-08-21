package psoft.ufcg.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import psoft.ufcg.entities.Disciplina;
import psoft.ufcg.services.DisciplinaService;

@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> getSaudacao(@RequestParam("nome") String nome, @RequestParam("nota") String nota) {
		return new ResponseEntity<Disciplina>(disciplinaService.addDisciplina(nome, nota), HttpStatus.OK);
	}
	
	
}
