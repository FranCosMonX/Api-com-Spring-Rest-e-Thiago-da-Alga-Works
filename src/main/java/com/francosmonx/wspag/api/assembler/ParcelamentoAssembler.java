package com.francosmonx.wspag.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.francosmonx.wspag.api.model.ParcelamentoModel;
import com.francosmonx.wspag.api.model.input.ParcelamentoModelInput;
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
	
	public List<ParcelamentoModel> toCollectionModel(List<Parcelamento> parcelamentos){
		return parcelamentos.stream()
				.map(p -> toModel(p))
				.toList();
	}
	
	/**
	 * Converte parcelamentoInput em Parcelamento
	 * @param parcelamentoInput
	 * @return
	 */
	public Parcelamento toEntity(ParcelamentoModelInput parcelamentoInput) {
		return modelMapper.map(parcelamentoInput, Parcelamento.class);
	}
}
