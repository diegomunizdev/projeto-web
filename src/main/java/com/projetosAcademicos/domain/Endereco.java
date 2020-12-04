package com.projetosAcademicos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rua", length = 255)
	private String rua;
	
	@Column(name = "numero", length = 8)
	private String numero;
	
	@Column(name = "cep",length = 14)
	private String cep;
	
	@Column(name = "cidade", length = 50)
	private String cidade;
	
	@Column(name = "estado",length = 50)
	private String estado;
	
	@Column(name = "pais",length = 50)
	private String pais;
	

}
