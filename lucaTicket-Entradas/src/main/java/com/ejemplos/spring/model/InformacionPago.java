package com.ejemplos.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase que representa la información de un pago.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformacionPago {
    private String nombreTitular;
    private String numeroTarjeta;
    private int mesCaducidad;
    private int yearCaducidad;
    private int cvv;
    private String emisor;
    private String concepto;
    private double cantidad;

    /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return Nombre del titular de la tarjeta.
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param nombreTitular Nombre del titular de la tarjeta.
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return Número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de la tarjeta.
     *
     * @param numeroTarjeta Número de la tarjeta.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene el mes de caducidad de la tarjeta.
     *
     * @return Mes de caducidad de la tarjeta.
     */
    public int getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * Establece el mes de caducidad de la tarjeta.
     *
     * @param mesCaducidad Mes de caducidad de la tarjeta.
     */
    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    /**
     * Obtiene el año de caducidad de la tarjeta.
     *
     * @return Año de caducidad de la tarjeta.
     */
    public int getYearCaducidad() {
        return yearCaducidad;
    }

    /**
     * Establece el año de caducidad de la tarjeta.
     *
     * @param yearCaducidad Año de caducidad de la tarjeta.
     */
    public void setYearCaducidad(int yearCaducidad) {
        this.yearCaducidad = yearCaducidad;
    }

    /**
     * Obtiene el código de seguridad de la tarjeta (CVV).
     *
     * @return Código de seguridad de la tarjeta.
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * Establece el código de seguridad de la tarjeta (CVV).
     *
     * @param cvv Código de seguridad de la tarjeta.
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Obtiene el emisor de la tarjeta.
     *
     * @return Emisor de la tarjeta.
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Establece el emisor de la tarjeta.
     *
     * @param emisor Emisor de la tarjeta.
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * Obtiene el concepto del pago.
     *
     * @return Concepto del pago.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Establece el concepto del pago.
     *
     * @param concepto Concepto del pago.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Obtiene la cantidad del pago.
     *
     * @return Cantidad del pago.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del pago.
     *
     * @param cantidad Cantidad del pago.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
