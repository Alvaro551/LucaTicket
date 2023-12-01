package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.spring.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

	
}
