package com.ejemplos.spring.errores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
//import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.PagoYEntradaResponse;

import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CustomGlobalExceptionHandler  {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new CustomResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomResponse<String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                             .body(new CustomResponse<>(HttpStatus.CONFLICT.value(), "Conflicto de datos: " + ex.getMessage(), null));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                             .body(new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomResponse<String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest()
                             .body(new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), "Solicitud malformada: " + ex.getMessage(), null));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomResponse<String>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest()
                             .body(new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CustomResponse<String>> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(new CustomResponse<>(HttpStatus.NOT_FOUND.value(), "No se encontró el endpoint: " + ex.getRequestURL(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomResponse<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        String errorMessage = fieldErrors.stream()
                                         .map(FieldError::getDefaultMessage)
                                         .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest()
                             .body(new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), errorMessage, null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse<String>> handleAllExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new CustomResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error interno del servidor: " + ex.getMessage(), null));
    }

	
}
