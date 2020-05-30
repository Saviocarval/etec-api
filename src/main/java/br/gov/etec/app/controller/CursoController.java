package br.gov.etec.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.services.CursoService;

@RestController
@RequestMapping("/curso/api")
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>>  listaCursos() {
		return service.listarCursos();		
	}
				
	@PostMapping
	public ResponseEntity<CursoDto> cadastrarCurso(@RequestBody CursoDto cursoDto){
		return service.incluirCurso(cursoDto);
	}
	
	
	
}
