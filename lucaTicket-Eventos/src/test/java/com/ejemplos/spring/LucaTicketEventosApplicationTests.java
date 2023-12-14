package com.ejemplos.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;
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

	@Test
	public void cuandoAñadoEvento_entoncesSeDebeGuardarEvento() {
		Eventos evento = new Eventos(); // crea un evento
		when(eventoRepository.save(any(Eventos.class))).thenReturn(evento);

		Eventos guardado = eventoService.addEvento(evento);

		assertNotNull(guardado, "El evento guardado no debe ser nulo");
		verify(eventoRepository).save(any(Eventos.class));
	}

	@Test
	public void cuandoBuscarEventoPorId_entoncesRetornaEvento() {
		Eventos eventoMock = new Eventos(); // Crea una instancia mock de Evento
		eventoMock.setId(1);
		when(eventoRepository.findById(1)).thenReturn(Optional.of(eventoMock));

		Optional<Eventos> encontrado = eventoService.buscarEventoPorId(1);

		assertTrue(encontrado.isPresent(), "El evento debe ser encontrado");
		assertEquals(1, encontrado.get().getId(), "El ID del evento debe coincidir");
	}
	
	@Test
    void testAñadirEventoConCamposNoNulos() {
        Eventos evento = new Eventos();
        evento.setNombre("Nombre del Evento");
        // Establece otros campos obligatorios aquí

        when(eventoRepository.save(any(Eventos.class))).thenAnswer(i -> i.getArguments()[0]);

        Eventos guardado = eventoService.addEvento(evento);

        assertNotNull(guardado.getNombre(), "El nombre del evento no debe ser nulo");
        // Agrega aserciones para otros campos obligatorios aquí

        // Verifica que se haya llamado al método save del repositorio
        verify(eventoRepository).save(any(Eventos.class));
    }
/*
    @Test
    void testActualizarEventoConCamposNoNulos() {
        Eventos eventoExistente = new Eventos();
        eventoExistente.setId(1);
        eventoExistente.setNombre("Nombre del Evento");
        // Establece otros campos obligatorios aquí

        when(eventoRepository.findById(1)).thenReturn(Optional.of(eventoExistente));
        when(eventoRepository.save(any(Eventos.class))).thenAnswer(i -> i.getArguments()[0]);

        Eventos eventoActualizado = new Eventos();
        eventoActualizado.setId(1);
        eventoActualizado.setNombre("Nombre Actualizado");
        // Establece los campos actualizados aquí

        Eventos resultado = eventoService.actualizarEvento(eventoActualizado);

        assertNotNull(resultado.getNombre(), "El nombre actualizado del evento no debe ser nulo");
        // Verifica que los campos actualizados no sean nulos aquí

        // Verifica que se haya llamado al método save del repositorio
        verify(eventoRepository).save(any(Eventos.class));
    }
    */
	
	
	
	 

}
