package br.gov.etec.app.dtos;

import java.io.Serializable;

public class CursoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4126300812484790031L;

	
	private String nome;
	private String descricao;
		
	public CursoDto() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "CursoDto [nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	

}
