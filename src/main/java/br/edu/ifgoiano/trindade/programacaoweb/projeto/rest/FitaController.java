package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Fita;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FitaRepository;

@RestController
@RequestMapping("/fita")
public class FitaController extends AbstractController<Fita>{

	@Autowired
	private FitaRepository rep;
	
	@Override
	public JpaRepository<Fita, Integer> getRepository() {
		return this.rep;
	}
	
}
