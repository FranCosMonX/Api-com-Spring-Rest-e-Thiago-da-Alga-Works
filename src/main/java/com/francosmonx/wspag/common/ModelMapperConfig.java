package com.francosmonx.wspag.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * declarado como componente spring -> configuração
 */
@Configuration
public class ModelMapperConfig {
	//indica que o Bean será instanciado, inicializado e configurado e será gerenciado pelo spring
	//logo, poderá ser injetado
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
