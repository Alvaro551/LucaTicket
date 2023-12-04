package com.ejemplos.spring.controller.error;

public class EventoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EventoNotFoundException() {
		super("Epic Fail: No existe el evento");
	}

	public EventoNotFoundException(int id) {
		super("Epic Fail: No existe el evento " + id);
	}

}
