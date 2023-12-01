package com.ejemplos.spring.adapter;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.model.Recinto;
import com.ejemplos.spring.response.EventoResponse;
import com.ejemplos.spring.response.RecintoResponse;

public class EventoRecintoAdapter {

	public static EventoResponse adaptarEvento(Eventos evento) {
		return EventoResponse.of(evento);
	}

	public static RecintoResponse adaptarRecinto(Recinto recinto) {
		return RecintoResponse.of(recinto);
	}

}
