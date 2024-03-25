package com.francosmonx.wspag.api.exceptionHandler;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.francosmonx.wspag.domain.exception.NegocioException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	//costumizando informações
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatus(status);
		problemDetail.setTitle("Um ou mais campos estao invalidos.");
		problemDetail.setType(URI.create("https://francosmonx.com/erros/campos-invalidos"));
		
		var fields = ex.getBindingResult().getAllErrors() //pega todos os objetos de erro da exceção definindo cada campo com algum erro
			.stream()//usando o stream para navegar pela lista
			//toMap precisa ter duas funções, para retornar o nome da chave do mapa e outra para o valor do mapa
			.collect(Collectors.toMap(error -> ((FieldError)error).getField(), 
					error -> error.getDefaultMessage()));
		
		problemDetail.setProperty("Fields", fields);
		
		return super.handleExceptionInternal(ex, problemDetail, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<String> capturar(NegocioException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
