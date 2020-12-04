package com.projetosAcademicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosAcademicos.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findByMatricula(String matricula);
	

}
