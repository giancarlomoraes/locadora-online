package br.edu.ifgoiano.trindade.programacaoweb.projeto.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends AbstractController<Cliente> {

	@Autowired
	private ClienteRepository rep;

	@Override
	public JpaRepository<Cliente, Integer> getRepository() {
		return this.rep;
	}
	
	@GetMapping(path="/prenome/{prenome}")
	public List<Cliente> getClienteByPrenome(@PathVariable("prenome") String prenome) {
		return rep.findByPrenome(prenome);
	}
	
	@GetMapping(path="/email/{email}/endereco/{endereco}")
	public List<Cliente> getClienteByEmailAndTelefone(
			@PathVariable("email") String email,
			@PathVariable("endereco") String endereco
	){
		return rep.findByEmailAndEndereco(email, endereco);
	}
	
	
	
}
