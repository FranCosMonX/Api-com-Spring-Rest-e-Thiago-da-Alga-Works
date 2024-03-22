package com.francosmonx.wspag.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;
@RestController
public class ClienteController {
	
	@GetMapping("/cliente")
	public Cliente cliente() {
		var cli = new Cliente();

		cli.setNome("Juliano");
		cli.setId(1);
		cli.setEmail("juliano.dev@hotmail.com");
		cli.setTelefone("000900000000");
		return cli;
	}
}
