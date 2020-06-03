package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
	Operador findByEmail(String email);
}
