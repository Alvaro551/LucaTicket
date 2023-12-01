package com.ejemplos.spring.model;

public class Recinto {

	private String nombre;
	private String ciudad;
	private String direccion;
	private enum recinto{
		ESTADIO, SALA_CONCIERTO, AIRE_LIBRE, TEATRO, ARENA_DEPORTIVA, CLUB_NOCTURNO;
	};
	private recinto recinto;
	private int aforo;
	
	public Recinto(String nombre, String ciudad, String direccion, com.ejemplos.spring.model.Recinto.recinto recinto,
			int aforo) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.recinto = recinto;
		this.aforo = aforo;
	}

	public Recinto() {
		super();
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

	public recinto getRecinto() {
		return recinto;
	}

	public void setRecinto(recinto recinto) {
		this.recinto = recinto;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	@Override
	public String toString() {
		return "Recinto [nombre=" + nombre + ", ciudad=" + ciudad + ", direccion=" + direccion + ", recinto=" + recinto
				+ ", aforo=" + aforo + "]";
	}
	
}
