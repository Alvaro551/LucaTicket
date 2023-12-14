package com.ejemplos.spring.errores;

public class TarjetaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto que crea una instancia de EventoNotFoundException
     * con un mensaje predeterminado indicando que no existe el evento.
     */
    public TarjetaNotFoundException() {
        super("Epic Fail: No existe la targeta");
    }

    /**
     * Constructor que crea una instancia de EventoNotFoundException con un mensaje
     * indicando que no existe el evento con el ID especificado.
     *
     * @param id El ID del evento que no se encontró.
     */
    public TarjetaNotFoundException(int id) {
        super("Epic Fail: No existe la targeta " + id);
    }

}
