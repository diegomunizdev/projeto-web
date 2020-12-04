package com.projetosAcademicos.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/") //Vai estar na raiz da aplicação
public class IndexController {
	
	@GetMapping //@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "API dos Carros";
	}
	
}
