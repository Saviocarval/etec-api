package br.gov.etec.app.controller;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoReposity;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoReposity repository;
	
	@GetMapping("listar")
	public List<Curso> listaCursos() {
		return repository.findAll();
		
	}
				
	@PostMapping("/cadastrar")
	public void cadastrarCurso(@RequestBody CursoDto cursoDto){
		Curso curso = this.dtoEntity(cursoDto);
		repository.save(curso);
	}
	
	@GetMapping("/{id}")
	public Object cadastrarCurso(@PathVariable("id") Long id){
		return	repository.findById(id);
	}
	
	private Curso dtoEntity(CursoDto dto) {
		Curso c = new Curso();
		c.setNome(dto.getNome());
		c.setDescricao(dto.getDescricao());
		return c;
	}
	
}
