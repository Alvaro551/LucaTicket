package com.ejemplos.spring.model;

public class EventoDTO {

	private int id;

	private String nombre;

	private String descripcioncorta;

	private String descripcionextendida;

	private String foto;

	private String fechaevento;

	private String horaevento;

	private double preciomin;

	private double preciomax;

	private String normas;

	private String genero;

	private String recinto;

	public EventoDTO(int id, String nombre, String descripcioncorta, String descripcionextendida, String foto,
			String fechaevento, String horaevento, double preciomin, double preciomax, String normas, String genero,
			String recinto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcioncorta = descripcioncorta;
		this.descripcionextendida = descripcionextendida;
		this.foto = foto;
		this.fechaevento = fechaevento;
		this.horaevento = horaevento;
		this.preciomin = preciomin;
		this.preciomax = preciomax;
		this.normas = normas;
		this.genero = genero;
		this.recinto = recinto;
	}

	public EventoDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}

	public String getDescripcionextendida() {
		return descripcionextendida;
	}

	public void setDescripcionextendida(String descripcionextendida) {
		this.descripcionextendida = descripcionextendida;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFechaevento() {
		return fechaevento;
	}

	public void setFechaevento(String fechaevento) {
		this.fechaevento = fechaevento;
	}

	public String getHoraevento() {
		return horaevento;
	}

	public void setHoraevento(String horaevento) {
		this.horaevento = horaevento;
	}

	public double getPreciomin() {
		return preciomin;
	}

	public void setPreciomin(double preciomin) {
		this.preciomin = preciomin;
	}

	public double getPreciomax() {
		return preciomax;
	}

	public void setPreciomax(double preciomax) {
		this.preciomax = preciomax;
	}

	public String getNormas() {
		return normas;
	}

	public void setNormas(String normas) {
		this.normas = normas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRecinto() {
		return recinto;
	}

	public void setRecinto(String recinto) {
		this.recinto = recinto;
	}

}
