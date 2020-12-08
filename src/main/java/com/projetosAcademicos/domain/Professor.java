package com.projetosAcademicos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name="professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "nome", length = 255)
	private String nome;
	
	@Column(name = "matricula")
	private Integer matricula;
	
	@Column(name = "curso", length = 255)
	private String curso;
	
	@JsonIgnore // usado para evitar referência ciclica
	@OneToMany(mappedBy = "professor")
	private List<Projeto> projetos = new ArrayList<>();
	
	 @NotNull()	  
	 @OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "endereco_id")
	 private Endereco endereco;
	 
}
