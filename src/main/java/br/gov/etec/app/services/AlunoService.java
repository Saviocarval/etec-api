package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public ResponseEntity<LinkedHashMap<String, Object>> incluirAluno(AlunoDto alunoDto){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senha = passwordEncoder.encode(alunoDto.getSenha());
		alunoDto.setSenha(senha);		
		Aluno aluno = repository.save(alunoDto.transformaAlunoDto());
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		map.put("messeger", "Aluno criado com sucesso!");
		map.put("Id",aluno.getId());
		map.put("Nome",aluno.getNome());
		map.put("RG",aluno.getRg());
		map.put("CPF",aluno.getCpf());
		map.put("Email",aluno.getEmail());
		map.put("Data_Nascimento",aluno.getData_nasc());
		map.put("Id_curso",aluno.getId_curso());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
			
	}
}
