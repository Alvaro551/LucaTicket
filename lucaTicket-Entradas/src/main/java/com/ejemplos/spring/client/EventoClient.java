package com.ejemplos.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplos.spring.model.EventoDTO;

@FeignClient(name = "evento-service", url = "http://localhost:3333")
public interface EventoClient {

    @GetMapping("/eventos/{id}")
    EventoDTO obtenerEventoPorId(@PathVariable("id") int id);
}
