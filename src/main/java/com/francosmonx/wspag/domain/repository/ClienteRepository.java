package com.francosmonx.wspag.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francosmonx.wspag.domain.model.Cliente;

/*
 * necessario para trabalhar com o jakarta
 * */

@Repository //é um componente do spring, mas com uma semantica muito bem definida
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
