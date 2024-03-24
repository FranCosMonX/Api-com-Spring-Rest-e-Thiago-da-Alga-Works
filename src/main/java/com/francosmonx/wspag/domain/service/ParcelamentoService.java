package com.francosmonx.wspag.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francosmonx.wspag.domain.exception.NegocioException;
import com.francosmonx.wspag.domain.model.Cliente;
import com.francosmonx.wspag.domain.model.Parcelamento;
import com.francosmonx.wspag.domain.repository.ClienteRepository;
import com.francosmonx.wspag.domain.repository.ParcelamentoRepository;

@Service
public class ParcelamentoService {
	private ParcelamentoRepository parcelamentoRepository;
	private CadastroClienteService clienteService;
	
	public ParcelamentoService(ParcelamentoRepository parcelamentoRepository, CadastroClienteService clienteService) {
		this.parcelamentoRepository = parcelamentoRepository;
		this.clienteService = clienteService;
	}
	
	@Transactional
	public Parcelamento cadastrar(Parcelamento parcelamento) {
		if(parcelamento.getId() != null) {
			throw new NegocioException("Parcelamento a ser cadastrado não possui codigo!");
		}
		
		Cliente cliente = clienteService.buscar(parcelamento.getCliente().getId());
		
		parcelamento.setCliente(cliente);
		parcelamento.setDataCriacao(LocalDateTime.now());
		return parcelamentoRepository.save(parcelamento);
	}
}
