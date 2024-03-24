package com.francosmonx.wspag.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francosmonx.wspag.domain.model.Parcelamento;
import com.francosmonx.wspag.domain.repository.ParcelamentoRepository;

@Service
public class ParcelamentoService {
	private ParcelamentoRepository parcelamentoRepository;
	
	public ParcelamentoService(ParcelamentoRepository parcelamentoRepository) {
		this.parcelamentoRepository = parcelamentoRepository;
	}
	
	@Transactional
	public Parcelamento cadastrar(Parcelamento parcelamento) {
		parcelamento.setDataCriacao(LocalDateTime.now());//colocando o tempo no parcelamento
		return parcelamentoRepository.save(parcelamento);
	}
}
