package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.service.EventoService;

@SpringBootTest
public class SpringTest07 {
	
	@Autowired
	EventoService eventoService;
	
	@Autowired
	EventoRepository eventoRepository;
	
	boolean actualiza;
	
	void shouldUpdateRight() {
		
		int id = 5;
		
		Eventos evento1 = new Eventos();
		
		eventoService.editarEvento(id, evento1);
		
		Optional<Eventos> evento = eventoRepository.findById(id);
		
		if(eventoRepository.save(evento.get()) != null) {
			eventoRepository.save(evento.get());
			actualiza = true;
		}else {
			actualiza = false;
		}
		
		assertThat(actualiza).isTrue();
	}
	
}
