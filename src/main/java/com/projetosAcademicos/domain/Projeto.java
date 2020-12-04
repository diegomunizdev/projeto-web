package com.projetosAcademicos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "area_do_projeto", length = 255)
	private String areaDoProjeto;
	
	@Column(name = "resumo" ,length = 3000)
	private String resumo;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@Column(name = "palavra_chave1", length = 50)
	private String palavraChave1;
	
	@Column(name = "palavra_chave2", length = 50)
	private String palavraChave2;
	
	@Column(name = "palavra_chave3", length = 50)
	private String palavraChave3;
	
	@Column(name = "url_documento", length = 255)
	private String urlDocumento;
	

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno ;
	
}
