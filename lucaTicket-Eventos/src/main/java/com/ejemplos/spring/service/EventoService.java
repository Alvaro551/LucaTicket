package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Eventos;

public interface EventoService {
	List<Eventos> findAll();



	Eventos addEvento(Eventos evento);
}
