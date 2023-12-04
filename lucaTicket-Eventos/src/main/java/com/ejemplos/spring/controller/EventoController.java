package com.ejemplos.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<EventoResponse> addEvento(@RequestBody Eventos nuevoEvento) {
        Eventos eventoGuardado = eventoService.addEvento(nuevoEvento);
        return ResponseEntity.status(HttpStatus.CREATED).body(EventoResponse.of(eventoGuardado));
    }
}
