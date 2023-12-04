package com.ejemplos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplos.spring.controller.EventoController;
import com.ejemplos.spring.service.EventoService;
import com.ejemplos.spring.service.EventoServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@WebMvcTest(EventoController.class)
public class EventoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private EventoServiceImpl eventoService = new EventoServiceImpl(); // Instancia concreta

	@Test
	public void cuandoPidoEventos_entoncesEstadoEsOk() throws Exception {
		mockMvc.perform(get("/eventos/")).andExpect(status().isOk());
	}

	/*
	  @Test public void cuandoAñadoEvento_entoncesSeDebeGuardarEvento() { Evento
	  evento = new Evento(); // crea un evento
	  when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
	 
	 Evento guardado = eventoService.addEvento(evento);
	 
	  assertNotNull(guardado, "El evento guardado no debe ser nulo");
	  verify(eventoRepository).save(any(Evento.class)); }
	  
	  @Test public void cuandoBuscoPorId_entoncesRetornoEvento() { Evento evento =
	  new Evento(); // crea un evento
	  when(eventoRepository.findById(anyLong())).thenReturn(Optional.of(evento));
	  
	  Evento encontrado = eventoService.findById(1L);
	  
	  assertNotNull(encontrado, "El evento encontrado no debe ser nulo");
	 verify(eventoRepository).findById(anyLong()); }
	  
	  @Test public void cuandoPidoTodosLosEventos_entoncesRetornoLista() throws
	  Exception {
	  when(eventoService.findAll()).thenReturn(Collections.emptyList());
	  
	  mockMvc.perform(get("/eventos/")) .andExpect(status().isOk())
	  .andExpect(jsonPath("$", hasSize(0))); }
	  
	  
	  @Test
public void cuandoPidoEventoPorId_entoncesRetornoEvento() throws Exception {
    EventoResponse eventoResponse = new EventoResponse(); // suponiendo que tienes un DTO
    when(eventoService.findById(anyLong())).thenReturn(eventoResponse);

    mockMvc.perform(get("/eventos/{id}", 1))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.nombre", is(eventoResponse.getNombre())));
}

@Test
public void cuandoEventoNoExiste_entoncesRetornoNotFound() throws Exception {
    when(eventoService.findById(anyLong())).thenThrow(new EntityNotFoundException("Evento no encontrado"));

    mockMvc.perform(get("/eventos/{id}", 1))
           .andExpect(status().isNotFound());
}

	  */
	 
}
