package com.ejemplos.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Usuario;

@Service
public interface UsuarioService {
	List<Usuario> findAll();
	
	Usuario findById(Integer id);
	Usuario addUsuario(Usuario usuario);
}
