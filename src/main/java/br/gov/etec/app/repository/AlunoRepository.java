package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.etec.app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	Aluno findByEmailAndSenha(String email, String senha);
	@Query(value = "select * from aluno where cpf = :cpf", nativeQuery = true)
	Aluno findByCpf(@Param("cpf") String cpf);
	
	
}
