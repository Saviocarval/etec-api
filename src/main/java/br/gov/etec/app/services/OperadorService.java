package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.gov.etec.app.dtos.OperadorDto;
import br.gov.etec.app.entity.Operador;
import br.gov.etec.app.repository.OperadorRepository;

@Service
public class OperadorService {
	@Autowired
	OperadorRepository repository;
	
	public ResponseEntity<List<Operador>> listarOperadores(){
		List<Operador> operador = new ArrayList<>();
		operador = repository.findAll();
		
		return ResponseEntity.ok(operador);		
	}
	
	public ResponseEntity<LinkedHashMap<String, Object>> listarOperadores(OperadorDto operadorDto){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String senhaEm = passwordEncoder.encode(operadorDto.getSenha());
		
		operadorDto.setSenha(senhaEm);
		
		Operador operador = repository.save(operadorDto.tranformaLoginOperadorDto());
		
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		
		map.put("Messeger", "Operador criado com sucesso!");
		map.put("Id", operador.getId());
		map.put("Nome", operador.getNome());
		map.put("Email", operador.getEmail());
		map.put("Matricula", operador.getMatricula());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	public ResponseEntity<LinkedHashMap<String, String>> login(OperadorDto operadorDto) {
		Operador operador = repository.findByEmail(operadorDto.getEmail());
		if(operador != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(operadorDto.getSenha(), operador.getSenha())) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			map.put("messeger", "Unauthorized. A senha está incorreta");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
			
		}
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("messeger", "Not found. Operador não localizado");
		repository.flush();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
