package com.ejemplos.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

/**
 * La clase Recinto representa un lugar donde se pueden llevar a cabo eventos.
 * Incluye información como el nombre, la ciudad, la dirección, el tipo de recinto y el aforo máximo.
 */
@Entity
public class Recinto {
	@Id
	private long recintoID;
	private String nombre;
	private String ciudad;
	private String direccion;

	 /**
     * Enumeración que representa los diferentes tipos de recintos posibles.
     */
	public enum tipoRecinto {
		ESTADIO, SALA_CONCIERTO, AIRE_LIBRE, TEATRO, ARENA_DEPORTIVA, CLUB_NOCTURNO;
	};

	@Enumerated(EnumType.STRING) // Guarda el enum como String en la base de datos
	private tipoRecinto tiporecinto;
	private int aforo;

	   /**
     * Constructor de Recinto con parámetros.
     *
     * @param recintoID   El identificador único del recinto.
     * @param nombre      El nombre del recinto.
     * @param ciudad      La ciudad donde se encuentra el recinto.
     * @param direccion   La dirección del recinto.
     * @param tipoRecinto El tipo de recinto.
     * @param aforo       El aforo del recinto.
     */
	public Recinto(long recintoID, String nombre, String ciudad, String direccion, tipoRecinto tiporecinto, int aforo) {
		super();
		this.recintoID = recintoID;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.tiporecinto = tiporecinto;
		this.aforo = aforo;
	}

	/**
     * Constructor por defecto de Recinto.
     */
	public Recinto() {
		super();
	}

	public long getId() {
		return recintoID;
	}

	public void setId(long recintoID) {
		this.recintoID = recintoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public tipoRecinto getTipoRecinto() {
		return tiporecinto;
	}

	public void setTipoRecinto(tipoRecinto tiporecinto) {
		this.tiporecinto = tiporecinto;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	@Override
	public String toString() {
		return "Recinto [id=" + recintoID + ", nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion
				+ ", tipoRecinto=" + tiporecinto + ", aforo=" + aforo + "]";
	}

}
