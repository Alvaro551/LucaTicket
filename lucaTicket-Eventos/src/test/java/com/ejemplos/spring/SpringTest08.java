package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest08 {

	@Autowired
	EventoService eventoService;
	
	boolean vacio;
	
	@Test
	void shouldBeEmpty() {
		
		String nombre = "Grupo04";
		
		List<Eventos> contar = eventoService.buscarEventosPorNombre(nombre);
		
		int longitud = contar.toArray().length;
		
		if(longitud != 0) {
			vacio = false;
		}else {
			vacio = true;
		}
		
		assertThat(vacio).isTrue();
	}
	
}
