package com.ejemplos.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.service.EventoService;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class SpringTest09 {

	 @Autowired
	    private EventoService eventoService;

	    @Autowired
	    private EventoRepository eventoRepository;

	    @Test
	    void filtrarCiudad_DeberiaDevolverEventosFiltradosPorCiudad() {
	        // Arrange
	        String ciudad = "Barcelona";
	        
	        // Act
	        List<Eventos> eventos = eventoService.filtrarCiudad(ciudad);
	        
	        // Assert
	        assertEquals(2, eventos.size()); // Ajusta este valor según la cantidad de eventos esperada en Barcelona
	    }
	
}
