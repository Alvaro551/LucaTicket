package com.ejemplos.spring.model;

import java.util.Date;

public class Eventos {

	private String nombre;
	private String descripcionCorta;
	private String descripcionExtendida;
	private String foto;
	private Date fechaEvento;
	private Date horaEvento;
	private double precioMinimo;
	private double precioMaximo;
	private String normas;
	private Recinto recinto;
	
	public Eventos(String nombre, String descripcionCorta, String descripcionExtendida, String foto, Date fechaEvento,
			Date horaEvento, double precioMinimo, double precioMaximo, String normas, Recinto recinto) {
		super();
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.descripcionExtendida = descripcionExtendida;
		this.foto = foto;
		this.fechaEvento = fechaEvento;
		this.horaEvento = horaEvento;
		this.precioMinimo = precioMinimo;
		this.precioMaximo = precioMaximo;
		this.normas = normas;
		this.recinto = recinto;
	}

	public Eventos() {
		super();
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionExtendida() {
		return descripcionExtendida;
	}

	public void setDescripcionExtendida(String descripcionExtendida) {
		this.descripcionExtendida = descripcionExtendida;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Date getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}

	public double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public double getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public String getNormas() {
		return normas;
	}

	public void setNormas(String normas) {
		this.normas = normas;
	}

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	@Override
	public String toString() {
		return "Eventos [nombre=" + nombre + ", descripcionCorta=" + descripcionCorta + ", descripcionExtendida="
				+ descripcionExtendida + ", foto=" + foto + ", fechaEvento=" + fechaEvento + ", horaEvento="
				+ horaEvento + ", precioMinimo=" + precioMinimo + ", precioMaximo=" + precioMaximo + ", normas="
				+ normas + ", recinto=" + recinto + "]";
	}
	
	
	
}
