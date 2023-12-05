package com.ejemplos.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * La clase Eventos representa un evento en el sistema.
 */
@Entity
//@Table(name = "Eventos")
public class Eventos {
	@Id
	@Column(name = "eventoID")
	private int id;
	private String nombre;
	private String descripcioncorta;
	private String descripcionextendida;
	private String foto;
	private LocalDate fechaevento;
	private LocalDateTime horaevento;
	private double preciomin;
	private double preciomax;
	private String normas;

	@ManyToOne
	@JoinColumn(name = "recintoID")
	private Recinto recinto;

	/**
     * Constructor de Eventos con parámetros.
     *
     * @param id                El identificador único del evento.
     * @param nombre            El nombre del evento.
     * @param descripcioncorta  La descripción corta del evento.
     * @param descripcionextendida La descripción extendida del evento.
     * @param foto              La URL de la foto asociada al evento.
     * @param fechaevento       La fecha del evento.
     * @param horaevento        La hora del evento.
     * @param preciomin         El precio mínimo del evento.
     * @param preciomax         El precio máximo del evento.
     * @param normas            Las normas asociadas al evento.
     * @param recinto           El recinto donde se llevará a cabo el evento.
     */
	public Eventos(int id, String nombre, String descripcioncorta, String descripcionextendida, String foto,
			LocalDate fechaevento, LocalDateTime horaevento, double preciomin, double preciomax, String normas,
			Recinto recinto) {
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
		this.recinto = recinto;
	}

	/**
     * Constructor por defecto de Eventos.
     */
	public Eventos() {
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

	public Recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	public LocalDate getFechaevento() {
		return fechaevento;
	}

	public void setFechaevento(LocalDate fechaevento) {
		this.fechaevento = fechaevento;
	}

	public LocalDateTime getHoraevento() {
		return horaevento;
	}

	public void setHoraevento(LocalDateTime horaevento) {
		this.horaevento = horaevento;
	}

}
