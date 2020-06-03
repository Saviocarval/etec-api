package br.gov.etec.app.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.services.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
		
	@Autowired
	AlunoService service;
	
	@GetMapping()
	public ResponseEntity<List<Aluno>> listaAlunos(){
		return service.listarAlunos();
	}
		
	@PostMapping()
	public ResponseEntity<LinkedHashMap<String,Object>> cadAluno(@RequestBody @Valid AlunoDto alunoDto) {
		return service.incluirAluno(alunoDto);			 
	}
	
	
		
}
