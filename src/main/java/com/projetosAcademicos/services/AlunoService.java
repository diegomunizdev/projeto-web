package com.projetosAcademicos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.dto.AlunoDTO;
import com.projetosAcademicos.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoDTO> getAlunos() {
		return alunoRepository.findAll().stream().map(AlunoDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Aluno> getAlunoById(Long id) {
		return alunoRepository.findById(id);
	}
	
	public List<AlunoDTO> getAlunoByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula).stream().map(AlunoDTO::new).collect(Collectors.toList());
	}
	
	public Aluno cadastrar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizar(Aluno aluno, Long id) {
		
		Optional<Aluno> optional = getAlunoById(id);
		if (optional.isPresent()) {
			Aluno alunoBD = optional.get();
			alunoBD.setMatricula(aluno.getMatricula());
			alunoBD.setNome(aluno.getNome());
			alunoBD.setCpf(aluno.getCpf());
			alunoBD.setCurso(aluno.getCurso());
			alunoBD.setEndereco(aluno.getEndereco());
			
			alunoRepository.save(alunoBD);
			return alunoBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o aluno informado");
		}
	}
	
	public void remover(Long id) {
		Optional<Aluno> aluno = getAlunoById(id);
		if(aluno.isPresent()) {
			alunoRepository.deleteById(id);
		}
	}

}
