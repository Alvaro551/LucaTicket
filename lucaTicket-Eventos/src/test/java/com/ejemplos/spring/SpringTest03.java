package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest03 {
	
	@Autowired
	EventoService eventoService;
	
	@Test
	void shouldBeEmpty() {
		List<Eventos> lista = eventoService.filtrarGenero("Comida"); // Si pongo un género que no existe en la base de
																		// datos, me debería devolver una lista vacía
		boolean vacio = false;
		
		if(lista.isEmpty()) {
			vacio = true;
		}
		
		assertThat(vacio).isTrue();
		
	}
	
}
