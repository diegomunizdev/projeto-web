package com.projetosAcademicos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosAcademicos.domain.Projeto;
import com.projetosAcademicos.domain.dto.ProjetoDTO;
import com.projetosAcademicos.repositories.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public List<ProjetoDTO> getProjetos(){
		return projetoRepository.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Projeto> getProjetoById(Long id) {
		return projetoRepository.findById(id);
	}
	
		
	public Projeto cadastrar(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	public Projeto atualizar(Projeto projeto, Long id) {
		
		Optional<Projeto> optional = getProjetoById(id);
		if (optional.isPresent()) {
			Projeto projetoBD = optional.get();
			projetoBD.setTitulo(projeto.getTitulo());
			projetoBD.setAreaDoProjeto(projeto.getAreaDoProjeto());
			projetoBD.setResumo(projeto.getResumo());
			projetoBD.setProfessor(projeto.getProfessor());
			projetoBD.setPalavraChave1(projeto.getPalavraChave1());
			projetoBD.setPalavraChave2(projeto.getPalavraChave2());
			projetoBD.setPalavraChave3(projeto.getPalavraChave3());
			projetoBD.setUrlDocumento(projeto.getUrlDocumento());
			projetoBD.setAlunos(projeto.getAlunos());
			
			projetoRepository.save(projetoBD);
			return projetoBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o aluno informado");
		}
	}
	
	public void remover(Long id) {
		Optional<Projeto> projeto = getProjetoById(id);
		if(projeto.isPresent()) {
			projetoRepository.deleteById(id);
		}
	}

}
