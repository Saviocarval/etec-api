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

import br.gov.etec.app.dtos.OperadorDto;
import br.gov.etec.app.entity.Operador;
import br.gov.etec.app.services.OperadorService;

@RestController
@RequestMapping("/api/operador")
public class OperadorController {
	
	@Autowired
	OperadorService service;
	
	@GetMapping
	public ResponseEntity<List<Operador>> listarOperadores(){
		return service.listarOperadores();
	}
	
	@PostMapping
	public ResponseEntity<LinkedHashMap<String, Object>> listarOperadores(@RequestBody @Valid OperadorDto operadorDto){
		return service.listarOperadores(operadorDto);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<LinkedHashMap<String, String>> logar(@RequestBody OperadorDto operadorDto){
		return service.login(operadorDto);
	}
	
	

}
