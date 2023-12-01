package com.ejemplos.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Recinto {
	@Id
	private long id;
	private String nombre;
	private String ciudad;
	private String direccion;

	public enum TipoRecinto {
		ESTADIO, SALA_CONCIERTO, AIRE_LIBRE, TEATRO, ARENA_DEPORTIVA, CLUB_NOCTURNO;
	};

	@Enumerated(EnumType.STRING) // Guarda el enum como String en la base de datos
	private TipoRecinto tipoRecinto;
	private int aforo;

	public Recinto(long id, String nombre, String ciudad, String direccion, TipoRecinto tipoRecinto, int aforo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.tipoRecinto = tipoRecinto;
		this.aforo = aforo;
	}

	public Recinto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public TipoRecinto getTipoRecinto() {
		return tipoRecinto;
	}

	public void setTipoRecinto(TipoRecinto tipoRecinto) {
		this.tipoRecinto = tipoRecinto;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	@Override
	public String toString() {
		return "Recinto [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion
				+ ", tipoRecinto=" + tipoRecinto + ", aforo=" + aforo + "]";
	}

	

}
