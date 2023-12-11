package com.ejemplos.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
