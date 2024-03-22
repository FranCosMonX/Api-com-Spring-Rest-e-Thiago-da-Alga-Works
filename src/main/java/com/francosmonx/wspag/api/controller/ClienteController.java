package com.francosmonx.wspag.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//responsável por receber requisições HTTP
@RestController
public class ClienteController {
	
	@GetMapping("/cliente")//uri
	public String cliente() {
		return "Juliano";
	}
}
