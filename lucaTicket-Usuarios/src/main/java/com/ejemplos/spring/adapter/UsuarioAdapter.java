package com.ejemplos.spring.adapter;

import com.ejemplos.spring.model.Usuario;
import com.ejemplos.spring.response.UsuarioResponse;

public class UsuarioAdapter {

	public static UsuarioResponse adaptarUsuario(Usuario usuario) {
		return UsuarioResponse.of(usuario);
	}
	
}
