package com.francosmonx.wspag.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francosmonx.wspag.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	//criar um metodo de modo a fazer o Spring entregar uma implementação
	//mas tem que obedecer à sintaxe
	List<Cliente> findByNome(String nome);
}
