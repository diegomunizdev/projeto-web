package com.projetosAcademicos.domain.dto;



import java.io.Serializable;
import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Professor;
import com.projetosAcademicos.domain.Projeto;

import lombok.Data;

@Data
public class ProjetoDTO implements Serializable{
		private static final long serialVersionUID = 1L;


	private Long id;
	
	
	private String titulo;
	private String areaDoProjeto;
	private String resumo;
	private Professor professor;
	private String palavraChave1;
	private String palavraChave2;
	private String palavraChave3;
	private String urlDocumento;
	private Aluno aluno;
	
	
	public ProjetoDTO(Projeto c) {
		this.id = c.getId();
		this.titulo = c.getTitulo();
		this.areaDoProjeto = c.getAreaDoProjeto();
		this.resumo = c.getResumo();
		this.professor = c.getProfessor();
		this.palavraChave1 = c.getPalavraChave1();
		this.palavraChave2 = c.getPalavraChave2();
		this.palavraChave3 = c.getPalavraChave3();
		this.urlDocumento = c.getUrlDocumento();
		this.aluno = c.getAluno();
	}
}
