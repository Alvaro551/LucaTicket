package com.ejemplos.spring.controller.error;

public class UsuarioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException() {
		super("Epic Fail: No existe el usuario");
	}

	public UsuarioNotFoundException(int id) {
		super("Epic Fail: No existe el usuario " + id);
	}

}


