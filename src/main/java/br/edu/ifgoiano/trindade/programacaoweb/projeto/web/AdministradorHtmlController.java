package br.edu.ifgoiano.trindade.programacaoweb.projeto.web;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;

@Controller
@RequestMapping(path = "/administrador")
public class AdministradorHtmlController extends HtmlController<Cliente, Integer> {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public String getNome() {
		return "administrador";
	}

	@Override
	protected JpaRepository<Cliente, Integer> getRepository() {
		return clienteRepository;
	}

	
	
}
