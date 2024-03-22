package com.francosmonx.wspag.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;
@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> clientes() {
		var cli = new Cliente();

		cli.setNome("Juliano Henrique");
		cli.setId(1);
		cli.setEmail("juliano.dev@hotmail.com");
		cli.setTelefone("000900000000");
		
		var cli1 = new Cliente();
		cli1.setNome("eduardo");
		cli1.setId(2);
		cli1.setEmail("eduardo.dev@hotmail.com");
		cli1.setTelefone("000900000001");
		return Arrays.asList(cli,cli1);//criação de listas resumida
	}
}
