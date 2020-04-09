package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.CategoriaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FilmeRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FitaRepository;

public class InterfaceGrafica {

	@Autowired
	private FitaRepository fitaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	private Scanner sc = new Scanner(System.in);

	public ArrayList<String> carregarClientes() {

		List<Cliente> clientes = clienteRepository.findAll();
		ArrayList<String> nomes = new ArrayList<String>();

		for (Cliente cliente : clientes) {
			nomes.add(cliente.getPrenome());
		}

		return nomes;
	}

	public void mostrarTelinha() {
		//Mostra a tela principal
		System.out.println("Olá! Seja bem-vindo(a)" + "\n1 - Cadastrar Cliente" + "\n2 - Inserir/Deletar Filme" + "\n3 - Login"
				+ "\n4 - Relatórios" + "\n5 - Sair");
	}

	public int lerInt() {
		//lê um inteiro
		int retorno = sc.nextInt();
		return retorno;
	}

	public String lerString() {
		//lê uma String
		String retorno = sc.nextLine();
		return retorno;
	}
	//Método que converte minutos para horas (e minutos)
	public String minutosParaHoras(Integer numero) {
		
		if (numero < 60) {
			int minutos = numero;
			return minutos + " minutos";
		} else if (numero == 60) {
			return "1 hora";
		} else if (numero > 60 && numero < 120) {
			int horas = (int) numero / 60;
			numero = numero % 60;
			int minutos = numero;
			return horas + " hora e " + minutos + " minutos";
		} else if (numero >= 120 && numero % 60 == 0) {
			int auxHoras = (int)numero / 60;
			return auxHoras + " horas";
		} else if(numero > 120){
			int horas = (int) numero / 60;
			numero = numero % 60;
			int minutos = numero;
			return horas + " horas e " + minutos + " minutos";
		}
		return numero + "";
		
	}

}
