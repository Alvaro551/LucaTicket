package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;


@SpringBootTest
class SpringTest01 {

	@Autowired
	EventoRepository eventoRepository;
	
	boolean noVacio;
	
  	@Test
  	void shouldBeEmpty() {
  		List<Eventos> filas = eventoRepository.findAll();

  		int longitud = filas.size();
  		
  		if(longitud != 0) {
  			noVacio = true;
  		}else {
  			noVacio = false;
  		}
  		
  		assertThat(noVacio).isTrue();
  		
  	}
}
