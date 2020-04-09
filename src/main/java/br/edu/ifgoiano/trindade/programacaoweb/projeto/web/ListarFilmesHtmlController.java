package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Filme;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FilmeRepository;

@Controller
@RequestMapping(path = "/administrador/filmes")
public class ListarFilmesHtmlController extends HtmlController<Filme, Integer> {

	@Autowired
	private FilmeRepository filmeRepository;
	
	@Override
	public String getNome() {
		return "filmes";
	}

	@Override
	protected JpaRepository<Filme, Integer> getRepository() {
		return filmeRepository;
	}
	
}
