package com.ejemplos.spring.service;

import com.ejemplos.spring.model.Entrada;

public interface ServicioValidacionPagoInterfaz {
	
	
	Entrada addEntrada(int usuarioId, int eventoId);

}
