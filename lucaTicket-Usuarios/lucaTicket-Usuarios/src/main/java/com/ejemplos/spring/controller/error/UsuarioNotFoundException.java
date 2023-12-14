package com.ejemplos.spring.controller.error;

/**
 * Excepción personalizada para indicar que no se ha encontrado un usuario.
 */
public class UsuarioNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de la excepción con un mensaje predeterminado.
     */
    public UsuarioNotFoundException() {
        super("Epic Fail: No existe el usuario");
    }

    /**
     * Crea una nueva instancia de la excepción con un mensaje personalizado que incluye el ID del usuario.
     *
     * @param id El ID del usuario que no se pudo encontrar.
     */
    public UsuarioNotFoundException(int id) {
        super("Epic Fail: No existe el usuario " + id);
    }
}
