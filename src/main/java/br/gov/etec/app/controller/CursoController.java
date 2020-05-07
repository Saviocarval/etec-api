package br.gov.etec.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoReposity;

@RestController
public class CursoController {
	
	@Autowired
	CursoReposity repository;
	
	
	@GetMapping
	@RequestMapping("/")
	public String inicio() {
		return "";
	}
	
	
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastrarCurso(@RequestBody CursoDto cursoDto){
		Curso curso = this.dtoEntity(cursoDto);
		repository.save(curso);		
	}
	
	private Curso dtoEntity(CursoDto dto) {
		Curso c = new Curso();
		c.setNome(dto.getNome());
		c.setDescricao(dto.getDescricao());
		return c;
	}
	
	@GetMapping
	@RequestMapping("/listarcursos")
	public List<Curso> listaCursos() {
		return repository.findAll();
		
	}

}
