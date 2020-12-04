package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Endereco;
import lombok.Data;

@Data
public class EnderecoDTO {
	
	private Long id;
	private String rua;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	public EnderecoDTO(Endereco e) {
		this.id = e.getId();
		this.rua = e.getRua();
		this.numero = e.getNumero();
		this.cep = e.getCep();
		this.cidade = e.getCidade();
		this.estado = e.getEstado();
		this.pais = e.getPais();
	}
}
