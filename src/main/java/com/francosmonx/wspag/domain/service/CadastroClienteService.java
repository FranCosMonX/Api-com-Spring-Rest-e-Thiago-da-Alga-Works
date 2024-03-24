package com.francosmonx.wspag.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francosmonx.wspag.domain.exception.NegocioException;
import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	private ClienteRepository clienteRepository;
	
	public CadastroClienteService(ClienteRepository clienteR) {
		this.clienteRepository = clienteR;
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
			throw new NegocioException("Email ja em uso");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
