package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
import com.ejemplos.spring.service.EventoService;
import com.ejemplos.spring.service.EventoServiceImpl;

@SpringBootTest
class LucaTicketEventosApplicationTests {

	@Mock
	private EventoRepository eventoRepository;

	@InjectMocks
	private EventoServiceImpl eventoService = new EventoServiceImpl(); // Instancia concreta

	@Test
    public void cuandoPidoEventos_entoncesObtengoEventos() {
        // Configurar el mock
        when(eventoRepository.findAll()).thenReturn(Collections.emptyList());

        // Ejecutar el servicio
        List<Eventos> eventos = eventoService.findAll();

        // Afirmar los resultados
        assertTrue(eventos.isEmpty(), "La lista de eventos debe estar vacía");

        // Verificar comportamientos
        verify(eventoRepository).findAll();
    }

}
