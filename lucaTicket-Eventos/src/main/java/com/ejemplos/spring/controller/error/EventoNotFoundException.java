package com.ejemplos.spring.controller.error;

/**
 * La clase EventoNotFoundException es una excepción personalizada que se lanza cuando no se encuentra un evento.
 */
public class EventoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto que crea una instancia de EventoNotFoundException
     * con un mensaje predeterminado indicando que no existe el evento.
     */
    public EventoNotFoundException() {
        super("Epic Fail: No existe el evento");
    }

    /**
     * Constructor que crea una instancia de EventoNotFoundException con un mensaje
     * indicando que no existe el evento con el ID especificado.
     *
     * @param id El ID del evento que no se encontró.
     */
    public EventoNotFoundException(int id) {
        super("Epic Fail: No existe el evento " + id);
    }
}
