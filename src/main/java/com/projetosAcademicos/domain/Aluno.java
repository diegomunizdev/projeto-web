package com.projetosAcademicos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "nome", length = 255)
	private String nome;
	// length = 13 não considerava os símbolos ("." e "-")
	@Column(name = "cpf", length = 20)
	private String cpf;
	
	@Column(name = "curso", length = 255)
	private String curso;
	
	@JsonIgnore // usado para evitar referência ciclica
	@ManyToMany(mappedBy = "alunos")
	private List<Projeto> projetos = new ArrayList<>();
	
	
		
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_endereco_id", foreignKey = @ForeignKey(name = "fk_endereco"), referencedColumnName = "id")
	private Endereco endereco;
	
}
