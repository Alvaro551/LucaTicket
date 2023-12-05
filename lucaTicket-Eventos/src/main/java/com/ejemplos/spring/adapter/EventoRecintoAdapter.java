package com.ejemplos.spring.adapter;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.model.Recinto;
import com.ejemplos.spring.response.EventoResponse;
import com.ejemplos.spring.response.RecintoResponse;

/**
 * La clase EventoRecintoAdapter proporciona métodos para adaptar objetos Eventos y Recinto
 * a sus respectivas representaciones en formato de respuesta.
 */
public class EventoRecintoAdapter {

    /**
     * Adapta un objeto Eventos a su representación en formato de respuesta EventoResponse.
     *
     * @param evento El objeto Eventos que se va a adaptar.
     * @return Una instancia de EventoResponse que representa el objeto Eventos adaptado.
     */
    public static EventoResponse adaptarEvento(Eventos evento) {
        return EventoResponse.of(evento);
    }

    /**
     * Adapta un objeto Recinto a su representación en formato de respuesta RecintoResponse.
     *
     * @param recinto El objeto Recinto que se va a adaptar.
     * @return Una instancia de RecintoResponse que representa el objeto Recinto adaptado.
     */
    public static RecintoResponse adaptarRecinto(Recinto recinto) {
        return RecintoResponse.of(recinto);
    }

}
