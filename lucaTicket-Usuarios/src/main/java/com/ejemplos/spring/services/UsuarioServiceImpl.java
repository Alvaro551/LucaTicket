package com.ejemplos.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.repository.UsuariosRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuariosRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario addUsuario(Usuario usuario) {
		if (esNombreValido(usuario.getNombre()) && esApellidoValido(usuario.getApellido())
				&& esEmailValido(usuario.getMail()) && esContrasenaValida(usuario.getContrasena())
				&& esFechaAltaValida(usuario.getFechaAlta())) {
			return usuarioRepository.save(usuario);
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
