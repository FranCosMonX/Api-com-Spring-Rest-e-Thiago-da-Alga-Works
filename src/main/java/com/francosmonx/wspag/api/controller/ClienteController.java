package com.francosmonx.wspag.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	
	public ClienteController(ClienteRepository repositorio) {
		this.clienteRepository = repositorio;
	}
	
	@GetMapping
	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente clienteAtualizado) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteAtualizado.setId(clienteId);
		return ResponseEntity.ok(clienteRepository.save(clienteAtualizado));
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();//melhor maneira de retornar o codigo HTTP de uma ação, sem devolver nada
	}
}
