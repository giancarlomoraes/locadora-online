package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Filme;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FilmeRepository;

@RestController
@RequestMapping("/filme")
public class FilmeController extends AbstractController<Filme>{

	@Autowired
	private FilmeRepository rep;

	@Override
	public JpaRepository<Filme, Integer> getRepository() {
		return this.rep;
	}
	
	@GetMapping(path="/titulo/{titulo}")
	public List<Filme> getFilmeByTitulo(@PathVariable("titulo") String titulo) {
		return rep.findByTitulo(titulo);
	}
	
	@GetMapping(path="/categoria/{categoria}")
	public List<Filme> getClienteByPrenome(@PathVariable("categoria") String duracao) {
		return rep.findByCategoria(duracao);
	}
	
}
