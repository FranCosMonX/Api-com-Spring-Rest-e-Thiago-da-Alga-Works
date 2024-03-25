package com.francosmonx.wspag.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.francosmonx.wspag.api.model.ParcelamentoModel;
import com.francosmonx.wspag.domain.model.Parcelamento;
import com.francosmonx.wspag.domain.repository.ParcelamentoRepository;
import com.francosmonx.wspag.domain.service.ParcelamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {
	private final ParcelamentoRepository parcelamentoRepositorio;
	private final ParcelamentoService parcelamentoService;
	private final ModelMapper modelMapper;
	
	public ParcelamentoController(ParcelamentoRepository pR, ParcelamentoService pS, ModelMapper modelMapper) {
		this.parcelamentoRepositorio = pR;
		this.parcelamentoService = pS;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping
	public List<Parcelamento> buscar(){
		return parcelamentoRepositorio.findAll();
	}
	
	@GetMapping("/{parcelamentoId}")
	public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long parcelamentoId){
		return parcelamentoRepositorio.findById(parcelamentoId)
				.map(parcelamento -> {
					ParcelamentoModel parcelamentoModel = modelMapper.map(parcelamento, ParcelamentoModel.class);
					
					return ResponseEntity.ok(parcelamentoModel);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento) {
		return parcelamentoService.cadastrar(parcelamento);
	}
}
