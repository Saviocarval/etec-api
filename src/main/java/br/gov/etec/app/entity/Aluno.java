package br.gov.etec.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_aluno")
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
	private String senha;
	@ManyToOne
	@JoinColumn(name = "curso",referencedColumnName = "id",nullable = false)
	private Curso curso;
		
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Aluno(String nome, String rg, String cpf, String email, Date data_nasc, long id_curso, String senha,
			Curso curso) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.data_nasc = data_nasc;
		this.senha = senha;
		this.curso = curso;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "Aluno: id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email+ ", data_nasc=" + data_nasc + ",";
	}
	
	
	
}
