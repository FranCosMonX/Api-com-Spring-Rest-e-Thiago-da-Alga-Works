package com.francosmonx.wspag.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.domain.model.Parcelamento;
import com.francosmonx.wspag.domain.repository.ParcelamentoRepository;
import com.francosmonx.wspag.domain.service.ParcelamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {
	private final ParcelamentoRepository parcelamentoRepositorio;
	private final ParcelamentoService parcelamentoService;
	
	public ParcelamentoController(ParcelamentoRepository pR, ParcelamentoService pS) {
		this.parcelamentoRepositorio = pR;
		this.parcelamentoService = pS;
	}
	
	@GetMapping
	public List<Parcelamento> buscar(){
		return parcelamentoRepositorio.findAll();
	}
	
	@GetMapping("/{parcelamentoId}")
	public ResponseEntity<Parcelamento> buscar(@PathVariable Long parcelamentoId){
		return parcelamentoRepositorio.findById(parcelamentoId)
				.map(ResponseEntity :: ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento) {
		return parcelamentoService.cadastrar(parcelamento);
	}
}
