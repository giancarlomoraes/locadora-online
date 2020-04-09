package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FitaRepository extends JpaRepository<Fita, Integer> {
	
	@Query(value="select * from fita inner join filme on fita.id_filme = filme.id inner join cliente on fita.id_cliente = cliente.id where cliente.id = ?1", nativeQuery=true)
	List<Fita> findByIdCliente(Integer id);
	
	@Query(value="select * from cliente where id = ?1", nativeQuery=true)
	Fita findByIdFita(Integer id);
	
}
