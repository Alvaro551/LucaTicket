package com.ejemplos.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if (esNombreValido(usuario.getNombre()) && esApellidoValido(usuario.getApellido())
				&& esEmailValido(usuario.getMail()) && esContrasenaValida(usuario.getContrasena())
				&& esFechaAltaValida(usuario.getFechaAlta())) {

			Usuario usuarioGuardado = usuarioRepository.save(usuario);

			return usuarioGuardado;
		} else {
			throw new IllegalArgumentException("Faltan datos obligatorios o son inválidos en el usuario");
		}
	}

	private boolean esNombreValido(String nombre) {
		return nombre != null && !nombre.trim().isEmpty();
	}

	private boolean esApellidoValido(String apellido) {
		return apellido != null && !apellido.trim().isEmpty();
	}

	private boolean esEmailValido(String email) {
		return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
	}

	private boolean esContrasenaValida(String contrasena) {
		return contrasena != null && !contrasena.trim().isEmpty();
	}

	private boolean esFechaAltaValida(LocalDate fecha) {
		return fecha != null;
	}
}
