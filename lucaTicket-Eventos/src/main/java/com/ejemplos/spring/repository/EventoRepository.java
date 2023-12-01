package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Eventos;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, Integer> {

}
