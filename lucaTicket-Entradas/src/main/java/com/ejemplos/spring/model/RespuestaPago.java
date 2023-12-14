package com.ejemplos.spring.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase que representa la respuesta de un pago.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaPago {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private Date timestamp;
    private String status;
    private String error;
    private List<String> message;
    private InformacionPago info;
    private String infoadicional;

    /**
     * Obtiene la marca de tiempo de la respuesta.
     *
     * @return Marca de tiempo de la respuesta.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la marca de tiempo de la respuesta.
     *
     * @param timestamp Marca de tiempo de la respuesta.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtiene el estado de la respuesta.
     *
     * @return Estado de la respuesta.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado de la respuesta.
     *
     * @param status Estado de la respuesta.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtiene el mensaje de error de la respuesta.
     *
     * @return Mensaje de error de la respuesta.
     */
    public String getError() {
        return error;
    }

    /**
     * Establece el mensaje de error de la respuesta.
     *
     * @param error Mensaje de error de la respuesta.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Obtiene la lista de mensajes de la respuesta.
     *
     * @return Lista de mensajes de la respuesta.
     */
    public List<String> getMessage() {
        return message;
    }

    /**
     * Establece la lista de mensajes de la respuesta.
     *
     * @param message Lista de mensajes de la respuesta.
     */
    public void setMessage(List<String> message) {
        this.message = message;
    }

    /**
     * Obtiene la información de pago de la respuesta.
     *
     * @return Información de pago de la respuesta.
     */
    public InformacionPago getInfo() {
        return info;
    }

    /**
     * Establece la información de pago de la respuesta.
     *
     * @param info Información de pago de la respuesta.
     */
    public void setInfo(InformacionPago info) {
        this.info = info;
    }

    /**
     * Obtiene la información adicional de la respuesta.
     *
     * @return Información adicional de la respuesta.
     */
    public String getInfoadicional() {
        return infoadicional;
    }

    /**
     * Establece la información adicional de la respuesta.
     *
     * @param infoadicional Información adicional de la respuesta.
     */
    public void setInfoadicional(String infoadicional) {
        this.infoadicional = infoadicional;
    }
}
