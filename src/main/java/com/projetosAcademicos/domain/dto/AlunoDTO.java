package com.projetosAcademicos.domain.dto;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Endereco;
import com.projetosAcademicos.domain.Projeto;

import lombok.Data;

@Data
public class AlunoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String matricula;
	private String nome;
	private String cpf;
	private String curso;
	private Endereco endereco;
	private List<Projeto> projetos = new ArrayList<>();
	
	public AlunoDTO(Aluno c) {
		this.id = c.getId();
		this.matricula = c.getMatricula();
		this.nome = c.getNome();
		this.cpf = c.getCpf();
		this.curso = c.getCurso();
		this.endereco = c.getEndereco();
		this.projetos = c.getProjetos();
	}
}
