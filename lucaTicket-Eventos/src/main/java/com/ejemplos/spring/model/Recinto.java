package com.ejemplos.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Recinto {
	@Id
	private long recintoID;
	private String nombre;
	private String ciudad;
	private String direccion;

	public enum tipoRecinto {
		ESTADIO, SALA_CONCIERTO, AIRE_LIBRE, TEATRO, ARENA_DEPORTIVA, CLUB_NOCTURNO;
	};

	@Enumerated(EnumType.STRING) // Guarda el enum como String en la base de datos
	private tipoRecinto tiporecinto;
	private int aforo;

	public Recinto(long recintoID, String nombre, String ciudad, String direccion, tipoRecinto tiporecinto, int aforo) {
		super();
		this.recintoID = recintoID;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.tiporecinto = tiporecinto;
		this.aforo = aforo;
	}

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
