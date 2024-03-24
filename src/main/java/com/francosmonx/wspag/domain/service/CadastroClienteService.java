package com.francosmonx.wspag.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.repository.ClienteRepository;

/**
 * - neste pacote contem as regras de negocios
 * - Muito usado principalmente quando precisa trabalhar com varias entidades ou injetar objetos, como um repositorio.
 *
 * - "se tiver uma regra de negocio, não precisará mexer na classe do controlador"
 */

@Service
public class CadastroClienteService {
	private ClienteRepository clienteRepository;
	
	public CadastroClienteService(ClienteRepository clienteR) {
		this.clienteRepository = clienteR;
	}
	
	//para tirar a função de cadastro do controlador
	@Transactional //do spring.framework - ou realiza tudo ou dá o desfaz tudo o que foi feito para manter a integridade
	public Cliente salvar(Cliente cliente) {//essemetodo deve ser executado dentro de uma transação
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
