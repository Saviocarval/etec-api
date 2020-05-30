package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	@Column
	private String nome;
	@Column
	private String rg;
	@Column(unique = true)
	private String cpf;
	@Column
	private String email;
	@Column
	private Date data_nasc;
	@Column
	private long id_curso;
	@Column
	private String senha;
		
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	
		
	public Aluno(String nome, String rg, String cpf, String email, Date data_nasc, long id_curso, String senha) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.data_nasc = data_nasc;
		this.id_curso = id_curso;
		this.senha = senha;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public long getId_curso() {
		return id_curso;
	}

	public void setId_curso(long id_curso) {
		this.id_curso = id_curso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public String toString() {
		return "Aluno: id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email+ ", data_nasc=" + data_nasc + ",";
	}
	
	
	
}