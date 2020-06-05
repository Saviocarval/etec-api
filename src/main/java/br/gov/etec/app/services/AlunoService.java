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
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.AlunoRepository;
import br.gov.etec.app.repository.CursoReposity;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repository;
	@Autowired
	private CursoReposity repositoryCurso;
	
	public ResponseEntity<List<LinkedHashMap<String, Object>>> listarAlunos(){
		List<Aluno> aluno = new ArrayList<>();
		aluno = repository.findAll();
		List<LinkedHashMap<String, Object>> listaAlunos = new ArrayList<>();
		LinkedHashMap<String, Object> al = new LinkedHashMap<>();
		for (Aluno aluno2 : aluno) {
			al.put("id", aluno2.getId());
			al.put("nome", aluno2.getNome());
			al.put("rg", aluno2.getRg());
			al.put("cpf", aluno2.getCpf());
			al.put("email", aluno2.getEmail());
			al.put("data_nasc", aluno2.getData_nasc());
			al.put("curso", aluno2.getCurso().getNome());
			listaAlunos.add(al);			
		}
		repository.flush();
		return ResponseEntity.ok(listaAlunos);
	}
	
	public ResponseEntity<LinkedHashMap<String, Object>> incluirAluno(AlunoDto alunoDto){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senha = passwordEncoder.encode(alunoDto.getSenha());
		alunoDto.setSenha(senha);
		Curso curso = repositoryCurso.findById(alunoDto.getId_curso());
		Aluno aluno = repository.save(alunoDto.transformaAlunoDto(curso));
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		map.put("messeger", "Aluno criado com sucesso!");
		map.put("Id",aluno.getId());
		map.put("Nome",aluno.getNome());
		map.put("RG",aluno.getRg());
		map.put("CPF",aluno.getCpf());
		map.put("Email",aluno.getEmail());
		map.put("Data_Nascimento",aluno.getData_nasc());
		
		repository.flush();				
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
			
	}
}
