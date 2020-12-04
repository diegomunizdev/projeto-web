package com.projetosAcademicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosAcademicos.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	List<Professor> findByMatricula(Integer matricula);
		

	
	

}
