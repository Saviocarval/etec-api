package br.gov.etec.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoReposity;

@Service
public class CursoService {
	
	@Autowired
	CursoReposity repository;
	
	public ResponseEntity<List<Curso>> listarCursos(){
		List<Curso> curso = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
	
	public ResponseEntity<CursoDto> incluirCurso(CursoDto cursoDto){
		repository.save(cursoDto.transformaCursoDto());
		return ResponseEntity.status(HttpStatus.OK).body(cursoDto);
	}

}
