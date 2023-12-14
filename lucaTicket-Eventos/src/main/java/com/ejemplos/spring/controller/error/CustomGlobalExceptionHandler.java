package com.ejemplos.spring.controller.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.response.EventoResponse;

/**
 * La clase CustomGlobalExceptionHandler es un manejador de excepciones global
 * para personalizar las respuestas de error.
 */
@RestControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<CustomResponse<EventoResponse>> handleDataIntegrityViolationException(
			DataIntegrityViolationException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new CustomResponse<>(HttpStatus.CONFLICT.value(), "Datos del evento en conflicto", null));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomResponse<EventoResponse>> handleIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.badRequest()
				.body(new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<CustomResponse<EventoResponse>> handleHttpMessageNotReadable(
			HttpMessageNotReadableException e) {
		return ResponseEntity.badRequest().body(
				new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), "Solicitud sin cuerpo o cuerpo malformado", null));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomResponse<EventoResponse>> handleAllExceptions(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new CustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error en el evento", null));
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<CustomResponse<EventoResponse>> handleNoHandlerFoundException(NoHandlerFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CustomResponse<>(HttpStatus.NOT_FOUND.value(),
				"No se encontró el endpoint: " + e.getRequestURL(), null));
	}
}
