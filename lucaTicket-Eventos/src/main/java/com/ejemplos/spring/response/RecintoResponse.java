package com.ejemplos.spring.response;

import java.io.Serializable;

import com.ejemplos.spring.model.Recinto;

/**
 * Clase DTO (Data Transfer Object) para representar la respuesta de un recinto.
 */
public class RecintoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String ciudad;
	private String direccion;
	private String tipoRecinto; // Cambiado de 'recinto' a 'tipoRecinto' para evitar confusión
	private String aforo;

	/**
	 * Método estático para convertir un objeto Recinto a un objeto RecintoResponse.
	 *
	 * @param recinto El objeto Recinto a convertir.
	 * @return Un objeto RecintoResponse que representa la respuesta del recinto.
	 */
	public static RecintoResponse of(Recinto recinto) {
		RecintoResponse response = new RecintoResponse();
		response.setId(recinto.getId());
		response.setNombre(recinto.getNombre());
		response.setCiudad(recinto.getCiudad());
		response.setDireccion(recinto.getDireccion());
		response.setTipoRecinto(recinto.getTipoRecinto().name());
		response.setAforo(recinto.getAforo() + " personas");

		return response;
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

	public String getTipoRecinto() {
		return tipoRecinto;
	}

	public void setTipoRecinto(String tipoRecinto) {
		this.tipoRecinto = tipoRecinto;
	}

	public String getAforo() {
		return aforo;
	}

	public void setAforo(String aforo) {
		this.aforo = aforo;
	}

}