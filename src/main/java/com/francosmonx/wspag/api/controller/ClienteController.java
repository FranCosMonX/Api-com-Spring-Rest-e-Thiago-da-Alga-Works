package com.francosmonx.wspag.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired //o Spring fornece uma instancia
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}
}
