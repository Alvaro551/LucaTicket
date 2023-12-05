package com.ejemplos.spring.controller.error;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;


/**
 * Clase que maneja excepciones globales personalizadas en la aplicación.
 */
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	  /**
     * Maneja la excepción cuando no se encuentra un usuario.
     *
     * @param response La respuesta HTTP.
     * @throws IOException Excepción de entrada/salida.
     */
	@ExceptionHandler(UsuarioNotFoundException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException {
		logger.info("------ UsuarioNotFoundException() ");
		// Saltará a la clase CustomErrorAttibuttes para crear un error personalizado
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	  /**
     * Maneja la excepción de violación de restricción.
     *
     * @param response La respuesta HTTP.
     * @throws IOException Excepción de entrada/salida.
     */	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		logger.info("------ ConstraintViolationException() ");
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

     /**
      * Maneja la excepción cuando los argumentos del método no son válidos.
      *
      * @param ex      La excepción de argumento de método no válido.
      * @param headers Las cabeceras HTTP.
      * @param status  El estado HTTP.
      * @param request La solicitud web.
      * @return La respuesta de entidad con detalles del error.
      */
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.info("------ handleMethodArgumentNotValid()");

		CustomErrorJson customError = new CustomErrorJson();

		customError.setTimestamp(new Date());
		customError.setStatus(status.value());
		customError.setError(status.name());

		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);

		// Para recoger el path y simular de forma completa los datos originales
		// request.getDescription(false) ---> uri=/students
		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=") + 1);
		customError.setPath(uri);

		return new ResponseEntity<>(customError, headers, status);

	}

	 /**
     * Maneja la excepción cuando se intenta realizar un método HTTP no admitido.
     *
     * @param ex      La excepción de método HTTP no admitido.
     * @param headers Las cabeceras HTTP.
     * @param status  El estado HTTP.
     * @param request La solicitud web.
     * @return La respuesta de entidad con detalles del error.
     */
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.info("------ handleHttpRequestMethodNotSupported()");
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		Map<String, Object> body = new LinkedHashMap<>();
		// Paso fecha formateada a String
		body.put("timestamp", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		body.put("status", status.value());
		body.put("error", ex.getLocalizedMessage());
		body.put("message", builder.toString());
		body.put("autor", "Alvaro");

		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

	}


}
