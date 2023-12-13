package com.ejemplos.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;

/**
 * Implementación de la interfaz {@link UsuarioService}. Proporciona servicios
 * relacionados con la gestión de usuarios.
 *
 * @see UsuarioService
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuariosRepository usuarioRepository;

	/**
	 * Recupera todos los usuarios disponibles.
	 *
	 * @return Una lista de usuarios.
	 */
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	/**
	 * Busca un usuario por su identificador.
	 *
	 * @param id El identificador del usuario a buscar.
	 * @return El usuario encontrado o null si no existe.
	 */
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	/**
	 * Agrega un nuevo usuario.
	 *
	 * @param usuario El usuario a agregar.
	 * @return El usuario recién agregado.
	 * @throws IllegalArgumentException Si faltan datos obligatorios o son inválidos
	 *                                  en el usuario.
	 */


	public Usuario addUsuario(Usuario usuario) {
		List<String> errores = new ArrayList<>();

		String errorNombre = validarNombre(usuario.getNombre());
		if (errorNombre != null) {
			errores.add(errorNombre);
		}

		String errorApellido = validarApellido(usuario.getApellido());
		if (errorApellido != null) {
			errores.add(errorApellido);
		}

		String errorEmail = validarEmail(usuario.getMail());
		if (errorEmail != null) {
			errores.add(errorEmail);
		}

		String errorContrasena = validarContrasena(usuario.getContrasena());
		if (errorContrasena != null) {
			errores.add(errorContrasena);
		}

		String errorFecha = validarFechaAlta(usuario.getFechaAlta());
		if (errorFecha != null) {
			errores.add(errorFecha);
		}

		if (!errores.isEmpty()) {
			throw new IllegalArgumentException(String.join(", ", errores));
		}

		return usuarioRepository.save(usuario);
	}


	private String validarNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
			return "El nombre del usuario es inválido o nulo";
		}
		return null;
	}

	private String validarApellido(String apellido) {
	    if (apellido == null || apellido.trim().isEmpty()) {
	        return "El apellido del usuario es inválido o nulo";
	    }
	    return null;
	}

	private String validarEmail(String email) {
	    if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")) {
	        return "El email del usuario es inválido o nulo";
	    }
	    return null;
	}

	private String validarContrasena(String contrasena) {
	    if (contrasena == null || contrasena.trim().isEmpty()) {
	        return "La contraseña del usuario es inválida o nula";
	    }
	    return null;
	}

	private String validarFechaAlta(LocalDate fecha) {
	    if (fecha == null || fecha.isBefore(LocalDate.now())) {
	        return "La fecha de alta del usuario es inválida o nula";
	    }
	    return null;
	}

	@Override
	public boolean borrarUsuarioPorId(Integer id) {
		if (!usuarioRepository.existsById(id)) {
			return false;
		}
		usuarioRepository.deleteById(id);
		return true;
	}

	@Override
	public Usuario editarUsuario(Integer idUsuario, Usuario usuarioNuevo) {
		// Buscar el usuario existente por ID
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);

		if (usuarioOptional.isPresent()) {
			// Obtener el usuario existente
			Usuario usuarioExistente = usuarioOptional.get();

			// Actualizar los valores del usuario existente con los proporcionados en
			// usuarioNuevo
			usuarioExistente.setNombre(usuarioNuevo.getNombre());
			usuarioExistente.setApellido(usuarioNuevo.getApellido());
			usuarioExistente.setMail(usuarioNuevo.getMail());
			usuarioExistente.setContrasena(usuarioNuevo.getContrasena());
			usuarioExistente.setFechaAlta(usuarioNuevo.getFechaAlta());

			// Guardar el usuario actualizado en la base de datos
			return usuarioRepository.save(usuarioExistente);
		} else {
			// El usuario no existe
			System.out.println("Ese usuario no existe");
			return null;
		}
	}
}
