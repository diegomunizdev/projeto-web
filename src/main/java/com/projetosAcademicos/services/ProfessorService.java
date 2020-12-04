package com.projetosAcademicos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosAcademicos.domain.Professor;
import com.projetosAcademicos.domain.dto.ProfessorDTO;
import com.projetosAcademicos.repositories.ProfessorRepository;


@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<ProfessorDTO> getProfessores(){
		return professorRepository.findAll().stream().map(ProfessorDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Professor> getProfessorById(Long id) {
		
		return professorRepository.findById(id);
	}
	
	public List<ProfessorDTO> getProfessorByMatricula(Integer matricula) {
		
		return professorRepository.findByMatricula(matricula).stream().map(ProfessorDTO::new).collect(Collectors.toList());
	}
	
	public Professor cadastrar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor atualizar(Professor professor, Long id) {
		
		Optional<Professor> optional = getProfessorById(id);
		if (optional.isPresent()) {
			Professor professorBD = optional.get();
			professorBD.setNome(professor.getNome());
			professorBD.setMatricula(professor.getMatricula());			
			professorBD.setCurso(professor.getCurso());
			professorBD.setEndereco(professor.getEndereco());
			
			
			professorRepository.save(professorBD);
			return professorBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o aluno informado");
		}
	}
	
	public void remover(Long id) {
		Optional<Professor> professor = getProfessorById(id);
		if(professor.isPresent()) {
			professorRepository.deleteById(id);
		}
	}

}
