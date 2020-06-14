package br.gov.etec.app.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.response.Response;
import br.gov.etec.app.services.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
		
	@Autowired
	AlunoService service;
	
	
	@GetMapping()
	public ResponseEntity<Response<List<LinkedHashMap<String,Object>>>> listar( ){		
		return service.listar();
	}
		
	@PostMapping()
	public ResponseEntity<Response<LinkedHashMap<String, Object>>> cadastrar(@RequestBody @Valid AlunoDto alunoDto,BindingResult result) {
		return service.cadastrar(alunoDto,result);			 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Response<Aluno>> listarPorId(@PathVariable @Valid long id){
		return service.litarPorId(id);
	}
		
}
