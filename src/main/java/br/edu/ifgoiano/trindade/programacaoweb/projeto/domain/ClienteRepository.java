package br.edu.ifgoiano.trindade.programacaoweb.projeto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query(value="select * from cliente where prenome like ?1% order by prenome", nativeQuery=true)
	List<Cliente> findByPrenome(String prenome);
	
	@Query(value="select * from cliente where email like ?1% and endereco like ?2% order by prenome", nativeQuery=true)
	List<Cliente> findByEmailAndEndereco(String email, String endereco);
	
	@Query(value="select * from cliente where id = ?1", nativeQuery=true)
	Cliente findByIdCliente(Integer id);
	
}
