package com.ejemplos.spring.controller.error;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
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
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ejemplos.spring.model.CustomResponse;

import jakarta.servlet.http.HttpServletResponse;

/**
 * La clase CustomGlobalExceptionHandler es un manejador de excepciones global para personalizar las respuestas de error.
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EventoNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        logger.info("------ JuegoNotFoundException() ");
        // Saltará a la clase CustomErrorAttributes para crear un error personalizado
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        logger.info("------ ConstraintViolationException() ");
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
    
	// Manejo de errores para tipo de fecha y hora incorrectas
	@SuppressWarnings("unchecked")
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<CustomResponse> handleDateTimeParseException(DateTimeParseException ex) {
		CustomResponse response = new CustomResponse(500,
				"Error: La fecha tiene un formato incorrecto. Debe ser dd-MM-yyyy", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

    // Manejo de errores para @Valid
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

    // Manejo de errores para HttpRequestMethodNotSupported
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
