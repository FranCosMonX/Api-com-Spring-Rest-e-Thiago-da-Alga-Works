package com.francosmonx.wspag.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.francosmonx.wspag.api.model.ParcelamentoModel;
import com.francosmonx.wspag.domain.model.Parcelamento;

/**
 * componente do spring que não tem uma semantica bem definida (o que ele vai fazer)
 */
@Component
public class ParcelamentoAssembler {
	private ModelMapper modelMapper;
	
	public ParcelamentoAssembler (ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public ParcelamentoModel toModel(Parcelamento parcelamento) {
		return modelMapper.map(parcelamento, ParcelamentoModel.class);
	}
}
