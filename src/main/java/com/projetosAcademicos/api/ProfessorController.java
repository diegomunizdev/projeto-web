package com.projetosAcademicos.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosAcademicos.domain.Professor;
import com.projetosAcademicos.domain.dto.ProfessorDTO;
import com.projetosAcademicos.services.ProfessorService;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	@Secured("ROLE_USER")
	public ResponseEntity<List<ProfessorDTO>> get() {
		return ResponseEntity.ok(service.getProfessores());
	}
	
	@GetMapping("/{id}")
	@Secured("ROLE_USER")
	public ResponseEntity<Professor> get(@PathVariable("id") Long id) {
		Optional<Professor> professor = service.getProfessorById(id);
		return professor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/matricula/{matricula}")
	@Secured("ROLE_USER")
	public ResponseEntity<List<ProfessorDTO>> getProfessores(@PathVariable("matricula") Integer matricula) {
		List<ProfessorDTO> listaProfessores = service.getProfessorByMatricula(matricula);
		return listaProfessores.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaProfessores);
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public String cadastrarProfessor(@Validated @RequestBody Professor professor) {
		Professor c = service.cadastrar(professor);
		return "Professor salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	@Secured("ROLE_ADMIN")
	public String atualizarProfessor(@Validated @PathVariable("id") Long id, @RequestBody Professor professor) {
		Professor c = service.atualizar(professor, id);
		return "Professor atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	@Secured("ROLE_ADMIN")
	public String removerProfessor(@PathVariable("id") Long id) {
		service.remover(id);
		return "Professor removido com sucesso. ";
	}
	
}
