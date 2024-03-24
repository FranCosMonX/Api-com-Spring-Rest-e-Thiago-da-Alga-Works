package com.francosmonx.wspag.domain.service;

import java.util.Optional;

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
		//há um problema no momento da edição, ja que estou usando esta funcionalidade para atualizar dados do cliente alem de o cadastrar
		//para corrigir, irei filtrar, do que me é retornado, APENAS os clientes que não estao "se editando"
		if(clienteRepository.findByEmail(cliente.getEmail())
				.filter(c -> !c.equals(cliente))
				.isPresent()) {
			throw new NegocioException("Email ja em uso");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
