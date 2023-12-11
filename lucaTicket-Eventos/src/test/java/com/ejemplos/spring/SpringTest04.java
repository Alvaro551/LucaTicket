package com.ejemplos.spring;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest04 {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	EventoRepository eventoRepository;
	
	boolean cierto;
	
	@Test
	void shoudBeThereId() {
		int id = 2;
		//Primero intento borrar un Evento
		eventoService.borrarEventoPorId(id);
		// Si este método es true, entonces no lo está borrando y por tanto está
		// recibiendo un id diferente
		if(eventoRepository.existsById(id)) {
			cierto = false;
		}else {
			cierto = true;
		}
		
		assertThat(cierto).isTrue();
		
	}
	
}
