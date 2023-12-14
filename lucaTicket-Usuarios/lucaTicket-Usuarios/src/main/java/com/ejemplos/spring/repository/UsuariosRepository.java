package com.ejemplos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Usuario;

/**
 * Interfaz de repositorio para la entidad Usuario.
 * Extiende JpaRepository proporcionado por Spring Data JPA.
 *
 * <p>Esta interfaz proporciona métodos CRUD estándar (Create, Read, Update, Delete) para la entidad Usuario.
 * Además, hereda métodos adicionales de la interfaz JpaRepository para realizar operaciones de base de datos de manera eficiente.</p>
 *
 * @see JpaRepository
 * @see Usuario
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
