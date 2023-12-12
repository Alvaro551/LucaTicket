package com.ejemplos.spring.controller.error;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.response.UsuarioResponseADD;

/**
 * Clase que maneja excepciones globales personalizadas en la aplicación.
 */

@RestControllerAdvice
public class CustomGlobalExceptionHandler   {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(CustomResponse.createConflictResponse("El correo electrónico ya está en uso", null));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> handleIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.badRequest()
				.body(CustomResponse.createCustomResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
		return ResponseEntity.badRequest().body(CustomResponse.createCustomResponse(HttpStatus.BAD_REQUEST.value(),
				"Solicitud sin cuerpo o cuerpo malformado", null));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> handleAllExceptions(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(CustomResponse.createInternalServerErrorResponse("Error al crear el usuario"));
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomResponse<UsuarioResponseADD>> handleNoHandlerFoundException(NoHandlerFoundException e) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body(new CustomResponse<>(HttpStatus.NOT_FOUND.value(), "No se encontró el endpoint: " + e.getRequestURL(), null));
	}

}
