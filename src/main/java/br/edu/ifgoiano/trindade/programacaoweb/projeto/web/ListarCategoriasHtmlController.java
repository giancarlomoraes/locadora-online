package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Categoria;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.CategoriaRepository;

@Controller
@RequestMapping(path = "/administrador/categorias")
public class ListarCategoriasHtmlController extends HtmlController<Categoria, Integer> {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public String getNome() {
		return "categorias";
	}

	@Override
	protected JpaRepository<Categoria, Integer> getRepository() {
		return categoriaRepository;
	}
	
}
