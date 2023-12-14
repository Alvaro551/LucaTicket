package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;




@SpringBootTest
class SpringTest02 {

	@Autowired
	EventoRepository eventoRepository;
	
  	@Test
  	void shouldNameNotNull() {
  		
  		Optional<Eventos> evento1 = eventoRepository.findById(1);
  		
  		if(evento1.get().getNombre() != null) {
  			assertThat(true).isTrue();
  		}else {
  			assertThat(false).isTrue();
  		}
  		
  	}
}
