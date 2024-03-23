package com.francosmonx.wspag.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	public ClienteController(ClienteRepository repositorio) {
		this.clienteRepository = repositorio;
	}
	
	@GetMapping("/clientes")
	public List<Cliente> clientes() {
		return clienteRepository.findByNomeContaining("Ai");
	}
}
