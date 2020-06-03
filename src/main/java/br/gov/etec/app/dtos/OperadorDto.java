package br.gov.etec.app.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.gov.etec.app.entity.Operador;

@SuppressWarnings("deprecation")
public class OperadorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6361202385230325251L;
	
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotNull
	private int matricula;
	@NotBlank
	private String senha;
	
	public OperadorDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Operador tranformaLoginOperadorDto() {
		return new Operador(nome,email,matricula,senha);
	}


}
