package br.edu.ifgoiano.trindade.programacaoweb.projeto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Categoria;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.CategoriaRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Cliente;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.ClienteRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Filme;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FilmeRepository;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.Fita;
import br.edu.ifgoiano.trindade.programacaoweb.projeto.domain.FitaRepository;

@Component
public class Principal implements CommandLineRunner {

	@Autowired
	private FitaRepository fitaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {

//		for (int i = 0; i < 50; i++) {
//			System.out.println();
//		}

//		// Instancia uma Interface Gráfica
//		InterfaceGrafica ig = new InterfaceGrafica();
//
//		int auxWhile = 0;
//		// Inicia o while
//		while (auxWhile != 5) {
//			// Limpa as variáveis
//			String prenome = "";
//			String sobrenome = "";
//			String email = "";
//			String telefone = "";
//			String endereco = "";
//
//			String nome = "";
//
//			String titulo = "";
//			String duracao = "";
//			String categoria = "";
//			// Puxa do banco de dados as lists
//			List<Cliente> clientes = clienteRepository.findAll();
//			List<Fita> fitas = fitaRepository.findAll();
//			List<Filme> filmes = filmeRepository.findAll();
//
//			ig.mostrarTelinha();
//			Scanner sc = new Scanner(System.in);
//
//			String aux = "";
//			int auxDuracao = 0;
//
//			aux = ig.lerString();
//			// Entra no try que vai tratar se o usuário está digitando um número
//			try {
//				Integer.parseInt(aux);
//
//				// Menu 1
//				if (Integer.parseInt(aux) == 1) {
//					// Lê os dados de um Cliente
//					System.out.println("Para se cadastrar informe: Nome, Sobrenome, Email, Telefone, Endereco");
//
//					prenome = ig.lerString();
//					sobrenome = ig.lerString();
//					email = ig.lerString();
//					telefone = ig.lerString();
//					endereco = ig.lerString();
//					// Cadastra só se respeitar o tamanho do varchar no banco
//					if (prenome.length() <= 20 && sobrenome.length() <= 50 && email.length() <= 50
//							&& telefone.length() <= 11 && endereco.length() <= 100) {
//						Cliente c = new Cliente();
//						c.setPrenome(prenome);
//						c.setSobrenome(sobrenome);
//						c.setEmail(email);
//						c.setTelefone(telefone);
//						c.setEndereco(endereco);
//						c = clienteRepository.save(c);
//					} else {
//						// Caso extrapole, joga uma mensagem na tela
//						System.out.println("Dados extrapolaram o tamanho permitido");
//					}
//
//					// Menu 2
//				} else if (Integer.parseInt(aux) == 2) {
//
//					System.out.println("1 - Inserir filme" + "\n2 - Deletar Filme");
//
//					int menu2item2 = ig.lerInt();
//
//					if (menu2item2 == 1) {
//						// Lê os dados da Categoria (nome) e do Filme (título e
//						// duração)
//						System.out.println("Para inserir um filme informe: Categoria, Título e Duração (em minutos)");
//						// Cadastra só se respeitar o tamanho do varchar no
//						// banco
//						if (nome.length() <= 20 && titulo.length() <= 50 && duracao.length() <= 20) {
//							nome = ig.lerString();
//
//							Categoria ctg = new Categoria();
//							ctg.setNome(nome);
//
//							ctg = categoriaRepository.save(ctg);
//
//							titulo = ig.lerString();
//							auxDuracao = ig.lerInt();
//							duracao = ig.minutosParaHoras(auxDuracao);
//
//							Filme fm = new Filme();
//							fm.setTitulo(titulo);
//							fm.setDuracao(duracao);
//							fm.setCategoria(ctg);
//
//							fm = filmeRepository.save(fm);
//						} else {
//							// Caso extrapole, joga uma mensagem na tela
//							System.out.println("Dados extrapolaram o tamanho permitido");
//						}
//					} else if (menu2item2 == 2) {
//						System.out.println("Digite o id do filme a ser deletado");
//						ig.lerString();
//						String id = ig.lerString();
//						filmeRepository.deleteById(Integer.parseInt(id));
//
//					}
//
//					// Menu 3
//				} else if (Integer.parseInt(aux) == 3) {
//					System.out.println("Para se identificar digite seu email");
//
//					email = ig.lerString();
//					for (int i = 0; i < clientes.size(); i++) {
//
//						if (clientes.get(i).getEmail().equals(email)) {
//							// Entra quando o email digitado for igual à um já
//							// cadastrado
//							System.out.println(
//									"Email encontrado \n1 - Locar filme \n2 - Devolver filme \n3 - Editar email \n4 - Deletar Cliente");
//
//							int menu2item1 = ig.lerInt();
//							// Lista os filmes, para o usuário locar algunm
//							if (menu2item1 == 1) {
//								System.out.println("Lista de Filmes abaixo\n");
//
//								for (Filme filme : filmes) {
//									System.out.println(
//											filme.getId() + " - " + filme.getTitulo() + " " + filme.getDuracao());
//								}
//
//								System.out.println("Digite o número do filme que deseja locar");
//								int auxmenu2item1 = ig.lerInt();
//								// Cria uma fita que junta a chave estrangeira
//								// do Cliente e do Filme
//								Fita ft = new Fita();
//
//								ft.setCliente(clientes.get(i));
//								ft.setFilme(filmes.get(auxmenu2item1 - 1));
//
//								ft = fitaRepository.save(ft);
//
//							} else if (menu2item1 == 2) {
//
//								System.out.println("Digite o numero da fita que deseja devolver");
//
//								ig.lerString();
//								String numero = ig.lerString();
//								// Deleta pelo ID da fita
//								for (Fita fita : fitas) {
//
//									if (fita.getId() == Integer.parseInt(numero)) {
//										fitaRepository.deleteById(fita.getId());
//										System.out.println("Devolvida");
//									}
//								}
//
//							} else if (menu2item1 == 3) {
//								// Altera o email pelo ID digitado
//								Cliente c = new Cliente();
//								System.out.println("Digite o id do cliente que deseja mudar o email");
//								ig.lerString();
//								String codigo = ig.lerString();
//								for (Cliente cliente : clientes) {
//									if (cliente.getId() == Integer.parseInt(codigo)) {
//										c.setId(Integer.parseInt(codigo));
//										System.out.println("Digite o novo email");
//										email = ig.lerString();
//										c.setPrenome(cliente.getPrenome());
//										c.setSobrenome(cliente.getSobrenome());
//										c.setEmail(email);
//										c.setTelefone(cliente.getTelefone());
//										c.setEndereco(cliente.getEndereco());
//										clienteRepository.save(c);
//									}
//								}
//							} else if (menu2item1 == 4) {
//								// Deleta por ID
//								System.out.println("Digite o id do cliente a ser deletado");
//								ig.lerString();
//								String id = ig.lerString();
//								clienteRepository.deleteById(Integer.parseInt(id));
//							}
//						}else{
//							System.out.println("Email não encontrado");
//						}
//					}
//				} else if (Integer.parseInt(aux) == 4) {
//					System.out.println("1 - Mostrar cliente procurando pelo nome"
//							+ "\n2 - Mostrar cliente procurando pelo email e pelo endereco" + "\n3 - Mostrar filme procurando pelo titulo"
//							+ "\n4 - Mostrar todos os filmes com certa categoria");
//					int menu4 = ig.lerInt();
//
//					if (menu4 == 1) {
//						// Mostra o Cliente procurando pelo nome
//						ig.lerString();
//						prenome = ig.lerString();
//						for (Cliente cliente : clienteRepository.findByPrenome(prenome)) {
//							System.out.println("Nome " + cliente.getPrenome() + " Sobrenome " + cliente.getSobrenome());
//							System.out.println(cliente.getEmail());
//							System.out.println(cliente.getTelefone());
//							System.out.println(cliente.getEndereco());
//
//						}
//					} else if (menu4 == 2) {
//						// Mostra o Cliente procurando email e pelo endereco
//						ig.lerString();
//						email = ig.lerString();
//						endereco = ig.lerString();
//						for (Cliente cliente : clienteRepository.findByEmailAndEndereco(email, endereco)) {
//							System.out.println("Nome " + cliente.getPrenome() + " Sobrenome " + cliente.getSobrenome());
//							System.out.println(cliente.getEmail());
//							System.out.println(cliente.getTelefone());
//							System.out.println(cliente.getEndereco());
//						}
//					} else if (menu4 == 3) {
//						// Mostra o Filme procurando pelo titulo
//						ig.lerString();
//						titulo = ig.lerString();
//						for (Filme filme : filmeRepository.findByTitulo(titulo)) {
//							System.out.println("Filme " + filme.getTitulo() + " Duração " + filme.getDuracao());
//						}
//					} else if (menu4 == 4) {
//						// Mostra todos os filmes com certa categoria
//
//						ig.lerString();
//						categoria = ig.lerString();
//						for (Filme filme : filmeRepository
//								.findByCategoria(categoria)) {
//							System.out.println("Filme " + filme.getTitulo() + " Duração " + filme.getDuracao());
//						}
//					}
//
//				} else if (Integer.parseInt(aux) == 5) {
//					// Sai do while
//					auxWhile = 5;
//				}
//			} catch (Exception e) {
//				// Joga a mensagem de erro quando o usuário digitar texto ao
//				// invés de um número
//				System.out.println("Erro, digite um número \n");
//			}
//			// Limpa o Buffer do scanner
//			sc.reset();
//		}

	}

}
