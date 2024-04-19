package com.laundry.Test.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class ErrorTracker {
  
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> error404 () {
		
		return ResponseEntity.notFound().build();
		}
	@ExceptionHandler(MethodArgumentNotValidException.class)
 	public ResponseEntity<?> error400 (MethodArgumentNotValidException ex) {
		var errors = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(errors.stream().map(DadosErrors::new).toList());
 	}
	public record DadosErrors(String campo, String message) {
  
		public DadosErrors(FieldError error) {
			this(error.getField(),error.getDefaultMessage());
		}	
	}
}
