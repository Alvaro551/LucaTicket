package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest06 {

	@Autowired
	EventoService eventoService;
	
	@Autowired
	EventoRepository eventoRepository;
	
	boolean iguales;
	
	void shouldBeEquals() {
		
		int id = 4;
		
		Eventos evento1 = new Eventos();
		eventoService.editarEvento(id, evento1);
		
		Optional<Eventos> evento = eventoRepository.findById(id);
		
		if(evento.get().getId() == id) {
			iguales = true;
		}else {
			iguales = false;
		}
		
		assertThat(iguales).isTrue();
	}
	
}
