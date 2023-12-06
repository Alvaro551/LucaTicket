package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest05 {
	
	@Autowired
	EventoService eventoService;
	
	void shoudDelete() {
		
		int id = 3;
		
		boolean borrado = eventoService.borrarEventoPorId(id);
		
		assertThat(borrado).isTrue();
	}
	
}
