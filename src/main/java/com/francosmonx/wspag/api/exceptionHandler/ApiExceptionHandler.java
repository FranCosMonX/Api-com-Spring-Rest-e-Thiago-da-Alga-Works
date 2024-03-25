package com.francosmonx.wspag.api.exceptionHandler;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
	
	private MessageSource messageSource;
	
	public ApiExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatus(status);
		problemDetail.setTitle("Um ou mais campos estao invalidos.");
		problemDetail.setType(URI.create("https://francosmonx.com/erros/campos-invalidos"));
		
		var fields = ex.getBindingResult().getAllErrors() 
			.stream()
			.collect(Collectors.toMap(error -> ((FieldError)error).getField(), 
					error -> messageSource.getMessage(error,LocaleContextHolder.getLocale()))); //passa o erro e o local de onde esta sendo executado a aplicação
		
		problemDetail.setProperty("Fields", fields);
		
		return super.handleExceptionInternal(ex, problemDetail, headers, status, request);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ProblemDetail handleNegocio(NegocioException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle(e.getMessage());
		problemDetail.setType(URI.create("https://francosmonx.com/erros/regra-de-negocio"));
		
		return problemDetail;
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ProblemDetail handleDataIntegrityViolation(DataIntegrityViolationException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);//nao excluir algo porque esta sendo usado em outro local
		problemDetail.setTitle("Recurso está em uso");
		problemDetail.setType(URI.create("https://francosmonx.com/erros/recurso-em-uso"));
		
		return problemDetail;
	}
}
