package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Filme;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FilmeRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Fita;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FitaRepository;

@Controller
@RequestMapping(path = "/usuario")
public class ClienteHtmlController extends HtmlController<Filme, Integer> {

	@Autowired
	private FilmeRepository filmeRepository;
	
	@Autowired
	private FitaRepository fitaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/{id}")
	public ModelAndView listarFilmesReservados(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/" + getNome());
		List<Fita> lista = fitaRepository.findByIdCliente(id);
		int auxOpc = 1;
		mv.addObject("objetos", lista);
		mv.addObject("id", id);
		mv.addObject("opc", auxOpc);
		return mv;
	}
	
	@GetMapping("/{id}/locarFilme")
	public ModelAndView listarFilmes(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/locarFilme");
		List<Filme> lista = filmeRepository.findAll();
		mv.addObject("objetos", lista);
		mv.addObject("id", id);
		return mv;
	}
	
	@GetMapping("/{id}/locarFilme/reservar/{idfilme}")
	public ModelAndView listar(@PathVariable("id") Integer id, @PathVariable("idfilme") Integer idfilme) {
		Fita f = new Fita();
		f.setCliente(clienteRepository.findByIdCliente(id));
		f.setFilme(filmeRepository.findByIdFilme(idfilme));
		fitaRepository.save(f);
		return listarFilmesReservados(id);
	}
	
	@GetMapping("/{id}/removerFilme/{idfita}")
	public ModelAndView deletarFilme(@PathVariable("id") Integer id, @PathVariable("idfita") Integer idfita) {
		fitaRepository.deleteById(idfita);
		return listarFilmesReservados(id);
	}

	@Override
	public String getNome() {
		return "paginaInicial";
	}

	@Override
	protected JpaRepository<Filme, Integer> getRepository() {
		return filmeRepository;
	}

}
