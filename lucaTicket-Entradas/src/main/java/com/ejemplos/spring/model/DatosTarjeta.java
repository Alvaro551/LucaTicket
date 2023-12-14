package com.ejemplos.spring.model;

/**
 * Clase que representa los datos de una tarjeta de crédito.
 */
public class DatosTarjeta {
    private String nombreTitular;
    private String numeroTarjeta;
    private int mesCaducidad;
    private int yearCaducidad;
    private int cvv;
    private String emisor;
    private String concepto;
    private double cantidad;

    /**
     * Constructor que inicializa los datos de la tarjeta.
     *
     * @param nombreTitular Nombre del titular de la tarjeta.
     * @param numeroTarjeta Número de la tarjeta.
     * @param mesCaducidad Mes de caducidad de la tarjeta.
     * @param yearCaducidad Año de caducidad de la tarjeta.
     * @param cvv Código de seguridad de la tarjeta.
     * @param emisor Emisor de la tarjeta.
     * @param concepto Concepto de la transacción.
     * @param cantidad Cantidad de la transacción.
     */
    public DatosTarjeta(String nombreTitular, String numeroTarjeta, int mesCaducidad, int yearCaducidad, int cvv,
            String emisor, String concepto, double cantidad) {
        super();
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.mesCaducidad = mesCaducidad;
        this.yearCaducidad = yearCaducidad;
        this.cvv = cvv;
        this.emisor = emisor;
        this.concepto = concepto;
        this.cantidad = cantidad;
    }

    /**
     * Constructor vacío.
     */
    public DatosTarjeta() {
        super();
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMesCaducidad() {
        return mesCaducidad;
    }

    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public int getYearCaducidad() {
        return yearCaducidad;
    }

    public void setYearCaducidad(int yearCaducidad) {
        this.yearCaducidad = yearCaducidad;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
