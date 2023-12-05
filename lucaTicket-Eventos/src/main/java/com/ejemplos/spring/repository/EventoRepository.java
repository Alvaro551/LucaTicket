package com.ejemplos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Eventos;

/**
 * La interfaz EventoRepository extiende JpaRepository para proporcionar operaciones de acceso a datos
 * específicas para la entidad Eventos.
 */
@Repository
public interface EventoRepository extends JpaRepository<Eventos, Integer> {

	List<Eventos> findByGenero(String genero);
	
	List<Eventos> findByNombre(String nombre);
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
