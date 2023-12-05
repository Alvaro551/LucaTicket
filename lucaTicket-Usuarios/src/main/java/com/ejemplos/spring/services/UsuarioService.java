package com.ejemplos.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Usuario;

/**
 * Interfaz que define los servicios relacionados con la entidad Usuario.
 *
 * <p>Proporciona métodos para realizar operaciones relacionadas con la gestión de usuarios,
 * como recuperar todos los usuarios, encontrar un usuario por su identificador y agregar un nuevo usuario.</p>
 *
 * @see Usuario
 */
@Service
public interface UsuarioService {
	
	/**
	 * Recupera todos los usuarios disponibles.
	 *
	 * @return Una lista de usuarios.
	 */
	List<Usuario> findAll();
	
	/**
	 * Busca un usuario por su identificador.
	 *
	 * @param id El identificador del usuario a buscar.
	 * @return El usuario encontrado o null si no existe.
	 */
	Usuario findById(Integer id);
	
	/**
	 * Agrega un nuevo usuario.
	 *
	 * @param usuario El usuario a agregar.
	 * @return El usuario recién agregado.
	 */
	Usuario addUsuario(Usuario usuario);
}
