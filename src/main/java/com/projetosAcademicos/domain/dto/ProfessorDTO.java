package com.projetosAcademicos.domain.dto;



import java.io.Serializable;

import com.projetosAcademicos.domain.Endereco;
import com.projetosAcademicos.domain.Professor;

import lombok.Data;

@Data
public class ProfessorDTO implements Serializable{
		private static final long serialVersionUID = 1L;


	private Long id;
	
	
	private String nome;
	private Integer matricula;
	private String curso;
	private Endereco endereco;
	
	
	public ProfessorDTO(Professor c) {
		this.id = c.getId();
		this.matricula = c.getMatricula();
		this.nome = c.getNome();		
		this.curso = c.getCurso();
		this.endereco = c.getEndereco();
		
	}
}
