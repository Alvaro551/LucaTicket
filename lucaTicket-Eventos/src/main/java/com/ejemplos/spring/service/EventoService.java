package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Eventos;

public interface EventoService {
  
	List<Eventos> findAll();
  
	Eventos addEvento(Eventos evento);

	Optional<Eventos> buscarEventoPorId(Integer id);

}
