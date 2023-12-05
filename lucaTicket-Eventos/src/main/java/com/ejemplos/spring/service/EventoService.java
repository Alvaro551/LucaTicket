package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Eventos;

/**
 * Interfaz que define los métodos para el servicio relacionado con eventos.
 */
public interface EventoService {
	/**
	 * Recupera todos los eventos.
	 *
	 * @return Lista de todos los eventos.
	 */
	List<Eventos> findAll();

	/**
	 * Agrega un nuevo evento.
	 *
	 * @param evento El evento a agregar.
	 * @return El evento agregado.
	 */
	Eventos addEvento(Eventos evento);


	/**
	 * Busca un evento por su identificador.
	 *
	 * @param id El identificador del evento a buscar.
	 * @return Un Optional que contiene el evento si se encuentra.
	 */
	Optional<Eventos> buscarEventoPorId(Integer id);

	boolean borrarEventoPorId(Integer id);
  
    
    List<Eventos> buscarEventosPorNombre(String nombre);
    List<Eventos> filtrarGenero(String genero);
}
