package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Categoria;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController extends AbstractController<Categoria> {

	@Autowired
	private CategoriaRepository rep;

	@Override
	public JpaRepository<Categoria, Integer> getRepository() {
		return this.rep;
	}

	
}
