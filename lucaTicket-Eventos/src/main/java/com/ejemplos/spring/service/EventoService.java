package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Eventos;

public interface EventoService {
	List<Eventos> findAll();

	Optional<Eventos> buscarEventoPorId(Integer id);
}
