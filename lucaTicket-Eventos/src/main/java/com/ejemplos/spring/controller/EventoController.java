package com.ejemplos.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.response.EventoResponse;
import com.ejemplos.spring.service.EventoService;

/**
 * El controlador EventoController maneja las solicitudes relacionadas con los eventos.
 */
@RestController
@RequestMapping("/eventos")
public class EventoController {


	@Autowired
	private EventoService eventoService;

	@Autowired
	private EventoRepository eventoRepository;
  
 /**
     * Obtiene todos los eventos.
     *
     * @return ResponseEntity con CustomResponse que contiene una lista de EventoResponse.
     */
  
	@GetMapping
	public ResponseEntity<CustomResponse<List<EventoResponse>>> obtenerEventos() {
		List<Eventos> eventos = eventoRepository.findAll();
		List<EventoResponse> eventoResponses = eventos.stream().map(EventoResponse::of).collect(Collectors.toList());
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventoResponses));
	}
  
 /**
     * Agrega un nuevo evento.
     *
     * @param nuevoEvento El evento que se va a agregar.
     * @return ResponseEntity con CustomResponse que contiene el EventoResponse del evento creado.
     */
  
	@PostMapping
	public ResponseEntity<CustomResponse<EventoResponse>> addEvento(@RequestBody Eventos nuevoEvento) {
		try {
			Eventos eventoGuardado = eventoService.addEvento(nuevoEvento);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(CustomResponse.createSuccessResponse(EventoResponse.of(eventoGuardado)));
		} catch (IllegalArgumentException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(CustomResponse.createConflictResponse(e.getMessage(), null));
		} 
	}
  
 /**
     * Obtiene un evento por su ID.
     *
     * @param id El ID del evento que se va a buscar.
     * @return ResponseEntity con CustomResponse que contiene el EventoResponse del evento encontrado.
     */
  
	@GetMapping("/{id}")
	public ResponseEntity<CustomResponse<EventoResponse>> obtenerEventoPorId(@PathVariable Integer id) {
		return eventoRepository.findById(id)
				.map(e -> ResponseEntity.ok(CustomResponse.createSuccessResponse(EventoResponse.of(e))))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponse.createNotFoundResponse("Evento no encontrado")));
	}
	
	/**
	 * Obtiene eventos filtrados por nombre.
	 *
	 * @param nombre El nombre del evento por el que filtrar.
	 * @return ResponseEntity con CustomResponse que contiene una lista de EventoResponse.
	 */
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<CustomResponse<List<EventoResponse>>> buscarEventosPorNombre(@PathVariable String nombre) {
	    List<Eventos> eventosFiltrados = eventoService.buscarEventosPorNombre(nombre);
	    List<EventoResponse> eventoResponses = eventosFiltrados.stream().map(EventoResponse::of).collect(Collectors.toList());
	    return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventoResponses));
	}

}
