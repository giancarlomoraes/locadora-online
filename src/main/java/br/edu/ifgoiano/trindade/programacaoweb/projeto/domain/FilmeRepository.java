package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
	
	@Query(value="select * from filme where titulo like ?1% order by titulo", nativeQuery=true)
	List<Filme> findByTitulo(String titulo);
	
	@Query(value="select * from filme join categoria on categoria.id = filme.id_categoria where categoria.nome like ?1% order by nome", nativeQuery=true)
	List<Filme> findByCategoria(String categoria);
	
	@Query(value="select * from filme where id = ?1", nativeQuery=true)
	Filme findByIdFilme(Integer idfilme);
}
