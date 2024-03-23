package com.francosmonx.wspag.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
public class ClienteController {
	//usado para fazer operações com o BD, de modo resumido.
	@PersistenceContext//o proprio framework injeta uma instancia. Não precisa criar uma nova
	private EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente> clientes() {
		List<Cliente> clientes = manager.createQuery("from Cliente", Cliente.class).getResultList();
		return clientes;//busca informando o tipo que é para ser retornado
	}
}
