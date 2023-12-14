package com.ejemplos.spring.model;

/**
 * Clase que representa la respuesta de validación de tarjeta.
 */
public class RespuestaValidacion {

    private DatosTarjeta info;

    /**
     * Obtiene la información de la tarjeta en la respuesta de validación.
     *
     * @return Información de la tarjeta.
     */
    public DatosTarjeta getInfo() {
        return info;
    }

    /**
     * Establece la información de la tarjeta en la respuesta de validación.
     *
     * @param info Información de la tarjeta.
     */
    public void setInfo(DatosTarjeta info) {
        this.info = info;
    }
}
