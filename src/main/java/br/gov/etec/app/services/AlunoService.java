package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository repository;
	
	public ResponseEntity<List<Aluno>> listarAlunos(){
		List<Aluno> aluno = new ArrayList<>();
		aluno = repository.findAll();
		repository.flush();
		return ResponseEntity.ok(aluno);
	}
	
	public ResponseEntity<AlunoDto> incluirAluno(AlunoDto alunoDto){
		repository.save(alunoDto.transformaAlunoDto());
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoDto);
			
	}
}
