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

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public ResponseEntity<CustomResponse<List<EventoResponse>>> obtenerEventos() {
        List<Eventos> eventos = eventoRepository.findAll();
        List<EventoResponse> eventoResponses = eventos.stream()
                                                      .map(EventoResponse::of)
                                                      .collect(Collectors.toList());
        return ResponseEntity.ok(CustomResponse.createSuccessResponse(eventoResponses));
    }

    @PostMapping
    public ResponseEntity<CustomResponse<EventoResponse>> addEvento(@RequestBody Eventos nuevoEvento) {
        try {
            Eventos eventoGuardado = eventoService.addEvento(nuevoEvento);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(CustomResponse.createSuccessResponse(EventoResponse.of(eventoGuardado)));
        } catch (Exception e) {
            // Aquí manejas cualquier excepción que pueda ocurrir durante la creación del evento
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(CustomResponse.createInternalServerErrorResponse("Error al crear el evento"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<EventoResponse>> obtenerEventoPorId(@PathVariable Integer id) {
        return eventoRepository.findById(id)
            .map(e -> ResponseEntity.ok(CustomResponse.createSuccessResponse(EventoResponse.of(e))))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                                           .body(CustomResponse.createNotFoundResponse("Evento no encontrado")));
    }
}
