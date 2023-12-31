package com.ejemplos.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.model.EventosRequest;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.response.EventoResponse;
import com.ejemplos.spring.service.EventoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * El controlador EventoController maneja las solicitudes relacionadas con los
 * eventos.
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
	 * @return ResponseEntity con CustomResponse que contiene una lista de
	 *         EventoResponse.
	 */

	@GetMapping
	@Operation(summary = "Obtener todos los eventos", description = "Devuelve una lista de todos los eventos en la base de datos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Lista de eventos recuperada con éxito"),
			@ApiResponse(responseCode = "204", description = "No hay eventos en la base de datos") })
	public ResponseEntity<CustomResponse<List<EventoResponse>>> obtenerEventos() {
		List<Eventos> eventos = eventoRepository.findAll();
		List<EventoResponse> eventoResponses = eventos.stream().map(EventoResponse::of).collect(Collectors.toList());
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventoResponses));
	}

	/**
	 * Agrega un nuevo evento.
	 *
	 * @param nuevoEvento El evento que se va a agregar.
	 * @return ResponseEntity con CustomResponse que contiene el EventoResponse del
	 *         evento creado.
	 */

	@PostMapping
    @Operation(summary = "Crear un nuevo evento", description = "Añade un nuevo evento a la base de datos")
    @ApiResponse(responseCode = "201", description = "Evento creado con éxito")
    public ResponseEntity<CustomResponse<EventoResponse>> addEvento(@RequestBody EventosRequest nuevoEventoRequest) {
        Eventos nuevoEvento = nuevoEventoRequest.transformToEventos();
        Eventos eventoGuardado = eventoService.addEvento(nuevoEvento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomResponse.createSuccessResponse(EventoResponse.of(eventoGuardado)));
    }

	/**
	 * Obtiene un evento por su ID.
	 *
	 * @param id El ID del evento que se va a buscar.
	 * @return ResponseEntity con CustomResponse que contiene el EventoResponse del
	 *         evento encontrado.
	 */

	@GetMapping("/{id}")
	@Operation(summary = "Obtener un evento por ID", description = "Devuelve los detalles de un evento específico, buscado por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Evento encontrado y devuelto con éxito"),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado") })
	public ResponseEntity<CustomResponse<EventoResponse>> obtenerEventoPorId(@PathVariable Integer id) {
		return eventoRepository.findById(id)
				.map(e -> ResponseEntity.ok(CustomResponse.createSuccessResponse(EventoResponse.of(e))))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponse.createNotFoundResponse("Evento no encontrado")));
	}

	/**
	 * Borra un evento por su ID.
	 *
	 * @param id El identificador único del evento a borrar.
	 * @return ResponseEntity con el CustomResponse que contiene el evento antes de ser borrado y el código de estado correspondiente.
	 */
	@DeleteMapping("/{id}")
	@Operation(summary = "Borrar un evento por ID", description = "Elimina un evento de la base de datos basado en su ID")
	@ApiResponse(responseCode = "200", description = "Evento eliminado con éxito")
	public ResponseEntity<CustomResponse<EventoResponse>> borrarEventoPorId(@PathVariable Integer id) {
		try {
			Eventos eventoAntes = eventoService.buscarEventoPorId(id).orElse(null);
			boolean borradoExitoso = eventoService.borrarEventoPorId(id);
			if (borradoExitoso) {
				return ResponseEntity.status(HttpStatus.CREATED)
		                .body(CustomResponse.createSuccessResponse(EventoResponse.of(eventoAntes)));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(CustomResponse.createNotFoundResponse("Evento no encontrado"));
			}
		} catch (Exception e) {
			// Manejar otras excepciones inesperadas
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponse.createInternalServerErrorResponse("Error interno al borrar el evento"));
		}
	}

	/**
	 * Obtiene eventos filtrados por nombre.
	 *
	 * @param nombre El nombre del evento por el que filtrar.
	 * @return ResponseEntity con CustomResponse que contiene una lista de
	 *         EventoResponse.
	 */
	@GetMapping("/nombre/{nombre}")
	@Operation(summary = "Buscar eventos por nombre", description = "Busca y devuelve eventos que coincidan con el nombre proporcionado")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Eventos encontrados con éxito"),
			@ApiResponse(responseCode = "204", description = "No se encontraron eventos con ese nombre") })
	public ResponseEntity<CustomResponse<List<EventoResponse>>> buscarEventosPorNombre(@PathVariable String nombre) {
		List<Eventos> eventosFiltrados = eventoService.buscarEventosPorNombre(nombre);
		List<EventoResponse> eventoResponses = eventosFiltrados.stream().map(EventoResponse::of)
				.collect(Collectors.toList());
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventoResponses));
	}

	/**
	 * Filtra eventos por género.
	 *
	 * @param genero El género por el cual filtrar eventos.
	 * @return ResponseEntity con la lista de EventoResponse y el código de estado correspondiente.
	 */
	
	@GetMapping("/genero/{genero}")
	@Operation(summary = "Filtrar eventos por género", description = "Busca y devuelve eventos que coincidan con el género proporcionado")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Eventos encontrados con éxito"),
			@ApiResponse(responseCode = "204", description = "No se encontraron eventos para ese género") })
	public ResponseEntity<CustomResponse<List<EventoResponse>>> filtrarGenero(@PathVariable String genero) {
		List<Eventos> eventosGenero = eventoService.filtrarGenero(genero);
		List<EventoResponse> eventosGeneroResponse = eventosGenero.stream().map(EventoResponse::of)
				.collect(Collectors.toList());
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventosGeneroResponse));
	}

	/**
	 * Edita un evento existente.
	 *
	 * @param eventoRequest El objeto EventosRequest con los detalles actualizados del evento.
	 * @param id El identificador único del evento a editar.
	 * @return ResponseEntity con el EventoResponse del evento editado y el código de estado correspondiente.
	 */
	@PutMapping("/{id}")
	@Operation(summary = "Editar un evento por ID", description = "Actualiza un evento existente en la base de datos basado en su ID")
	@ApiResponses(value = { 
	    @ApiResponse(responseCode = "200", description = "Evento editado con éxito"),
	    @ApiResponse(responseCode = "404", description = "Evento no encontrado con el ID proporcionado")
	})
	public ResponseEntity<CustomResponse<EventoResponse>> editarEvento(@RequestBody EventosRequest eventoRequest,
	        @PathVariable Integer id) {
	    Eventos evento = eventoRequest.transformToEventos();
	    Eventos editado = eventoService.editarEvento(id, evento);
	    if (editado != null) {
	        return ResponseEntity.ok(CustomResponse.createSuccessResponse(EventoResponse.of(editado)));
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(CustomResponse.createNotFoundResponse("Evento no existente"));
	    }
	}
	
	 @GetMapping("/ciudad/{ciudad}")
	    @Operation(summary = "Filtrar eventos por ciudad", description = "Busca y devuelve eventos que coincidan con la ciudad proporcionada")
	    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Eventos encontrados con éxito"),
	            @ApiResponse(responseCode = "204", description = "No se encontraron eventos para esa ciudad") })
	    public ResponseEntity<CustomResponse<List<EventoResponse>>> filtrarCiudad(@PathVariable String ciudad) {
	        List<Eventos> eventosCiudad = eventoService.filtrarCiudad(ciudad);
	        List<EventoResponse> eventosCiudadResponse = eventosCiudad.stream().map(EventoResponse::of)
	                .collect(Collectors.toList());
	        return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventosCiudadResponse));
	    }
}
