package com.ejemplos.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un evento en el sistema. Incluye detalles como el
 * nombre, descripción, fecha, hora y lugar del evento.
 */
@Entity
@Table(name = "Eventos")
public class Eventos {
	/**
	 * Identificador único del evento.
	 */
	@Id
	@Column(name = "eventoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Nombre del evento.
	 */
	private String nombre;

	/**
	 * Descripción corta del evento.
	 */
	private String descripcioncorta;

	/**
	 * Descripción extendida del evento.
	 */
	private String descripcionextendida;

	/**
	 * Ruta de la foto asociada al evento.
	 */
	private String foto;

	/**
	 * Fecha del evento.
	 */
	private LocalDate fechaevento;

	/**
	 * Hora del evento.
	 */
	private LocalDateTime horaevento;

	/**
	 * Precio mínimo para el evento.
	 */
	private double preciomin;

	/**
	 * Precio máximo para el evento.
	 */
	private double preciomax;

	/**
	 * Normas asociadas al evento.
	 */
	private String normas;

	/**
	 * Género del evento.
	 */
	private String genero;

	/**
	 * Recinto donde se realiza el evento.
	 */
	@ManyToOne
	@JoinColumn(name = "recintoID")
	private Recinto recinto;

	/**
	 * Constructor que permite crear un evento con todos los atributos.
	 *
	 * @param id                   Identificador único del evento.
	 * @param nombre               Nombre del evento.
	 * @param descripcioncorta     Descripción corta del evento.
	 * @param descripcionextendida Descripción extendida del evento.
	 * @param foto                 Ruta de la foto asociada al evento.
	 * @param fechaevento          Fecha del evento.
	 * @param horaevento           Hora del evento.
	 * @param preciomin            Precio mínimo para el evento.
	 * @param preciomax            Precio máximo para el evento.
	 * @param normas               Normas asociadas al evento.
	 * @param genero               Género del evento.
	 * @param recinto              Recinto donde se realiza el evento.
	 */
	public Eventos(int id, String nombre, String descripcioncorta, String descripcionextendida, String foto,
			LocalDate fechaevento, LocalDateTime horaevento, double preciomin, double preciomax, String normas,
			String genero, Recinto recinto) {
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

	/**
	 * Constructor por defecto.
	 */
	public Eventos() {
	}

	/**
	 * Obtiene el identificador único del evento.
	 *
	 * @return Identificador único del evento.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador único del evento.
	 *
	 * @param id Identificador único del evento.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del evento.
	 *
	 * @return Nombre del evento.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del evento.
	 *
	 * @param nombre Nombre del evento.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la descripción corta del evento.
	 *
	 * @return Descripción corta del evento.
	 */
	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	/**
	 * Establece la descripción corta del evento.
	 *
	 * @param descripcioncorta Descripción corta del evento.
	 */
	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}

	/**
	 * Obtiene la descripción extendida del evento.
	 *
	 * @return Descripción extendida del evento.
	 */
	public String getDescripcionextendida() {
		return descripcionextendida;
	}

	/**
	 * Establece la descripción extendida del evento.
	 *
	 * @param descripcionextendida Descripción extendida del evento.
	 */
	public void setDescripcionextendida(String descripcionextendida) {
		this.descripcionextendida = descripcionextendida;
	}

	/**
	 * Obtiene la ruta de la foto asociada al evento.
	 *
	 * @return Ruta de la foto.
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * Establece la ruta de la foto asociada al evento.
	 *
	 * @param foto Ruta de la foto.
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Obtiene la fecha del evento.
	 *
	 * @return Fecha del evento.
	 */
	public LocalDate getFechaevento() {
		return fechaevento;
	}

	/**
	 * Establece la fecha del evento.
	 *
	 * @param fechaevento Fecha del evento.
	 */
	public void setFechaevento(LocalDate fechaevento) {
		this.fechaevento = fechaevento;
	}

	/**
	 * Obtiene la hora del evento.
	 *
	 * @return Hora del evento.
	 */
	public LocalDateTime getHoraevento() {
		return horaevento;
	}

	/**
	 * Establece la hora del evento.
	 *
	 * @param horaevento Hora del evento.
	 */
	public void setHoraevento(LocalDateTime horaevento) {
		this.horaevento = horaevento;
	}

	/**
	 * Obtiene el precio mínimo para el evento.
	 *
	 * @return Precio mínimo para el evento.
	 */
	public double getPreciomin() {
		return preciomin;
	}

	/**
	 * Establece el precio mínimo para el evento.
	 *
	 * @param preciomin Precio mínimo para el evento.
	 */
	public void setPreciomin(double preciomin) {
		this.preciomin = preciomin;
	}

	/**
	 * Obtiene el precio máximo para el evento.
	 *
	 * @return Precio máximo para el evento.
	 */
	public double getPreciomax() {
		return preciomax;
	}

	/**
	 * Establece el precio máximo para el evento.
	 *
	 * @param preciomax Precio máximo para el evento.
	 */
	public void setPreciomax(double preciomax) {
		this.preciomax = preciomax;
	}

	/**
	 * Obtiene las normas asociadas al evento.
	 *
	 * @return Normas asociadas al evento.
	 */
	public String getNormas() {
		return normas;
	}

	/**
	 * Establece las normas asociadas al evento.
	 *
	 * @param normas Normas asociadas al evento.
	 */
	public void setNormas(String normas) {
		this.normas = normas;
	}

	/**
	 * Obtiene el género del evento.
	 *
	 * @return Género del evento.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género del evento.
	 *
	 * @param genero Género del evento.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el recinto donde se realiza el evento.
	 *
	 * @return Recinto donde se realiza el evento.
	 */
	public Recinto getRecinto() {
		return recinto;
	}

	/**
	 * Establece el recinto donde se realiza el evento.
	 *
	 * @param recinto Recinto donde se realiza el evento.
	 */
	public void setRecinto(Recinto recinto) {
		this.recinto = recinto;
	}

	/**
	 * Obtiene la fecha del evento formateada como "dd/MM/yyyy".
	 *
	 * @return Fecha formateada.
	 */
	public String getFormattedFechaEvento() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return fechaevento.format(formatter);
	}

	/**
	 * Obtiene la hora del evento formateada como "HH:mm".
	 *
	 * @return Hora formateada.
	 */
	public String getFormattedHoraEvento() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return horaevento.format(formatter);
	}
}
