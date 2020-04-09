package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "categoria")
@JsonIdentityInfo(
		scope = Categoria.class,
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Categoria extends Domain{

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Filme> filmes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	
	
	
	
}