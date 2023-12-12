package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Entrada;
@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{

}
