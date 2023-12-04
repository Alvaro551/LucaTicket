package com.ejemplos.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.response.EventoResponse;
import com.ejemplos.spring.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@Autowired
	private EventoRepository eventoRepository;

	@GetMapping
	public List<EventoResponse> obtenerEventos() {
	    List<Eventos> eventos = eventoRepository.findAll();
	    return eventos.stream()
	                  .map(EventoResponse::of)
	                  .collect(Collectors.toList());
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EventoResponse> obtenerEventoPorId(@PathVariable Integer id) {
	    Optional<Eventos> evento = eventoRepository.findById(id);

	    return evento.map(e -> ResponseEntity.ok(EventoResponse.of(e)))
	                 .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	
}
