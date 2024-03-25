package com.francosmonx.wspag.api.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francosmonx.wspag.domain.exception.NegocioException;

/**
 * componente spring que é capaz de capturar todas as exceções da aplicação
 */

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<String> capturar(NegocioException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
