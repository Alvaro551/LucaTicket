package com.ejemplos.spring.response;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.ejemplos.spring.model.Eventos;

/**
 * Clase DTO (Data Transfer Object) para representar la respuesta de un evento.
 */
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private int eventoID;
	private String nombre;
	private String descripcioncorta;
	private String descripcionextendida;
	private String foto;
	private String fechaevento;
	private String horaevento;
	private String preciomin;
	private String preciomax;
	private String normas;
	private String genero;
	private RecintoResponse recinto; 


	/**
	 * Método estático para convertir un objeto Eventos a un objeto EventoResponse.
	 *
	 * @param evento El objeto Eventos a convertir.
	 * @return Un objeto EventoResponse que representa la respuesta del evento.
	 */
	public static EventoResponse of(Eventos evento) {
		EventoResponse response = new EventoResponse();

		response.setEventoID(evento.getId());
        response.setNombre(evento.getNombre());
        response.setDescripcioncorta(evento.getDescripcioncorta());
        response.setDescripcionextendida(evento.getDescripcionextendida());
        response.setFoto(evento.getFoto());
        response.setFechaevento(evento.getFormattedFechaEvento()); // Cambio aquí
        response.setHoraevento(evento.getFormattedHoraEvento()); // Cambio aquí
        response.setPreciomin(String.format("%.2f €", evento.getPreciomin()));
        response.setPreciomax(String.format("%.2f €", evento.getPreciomax()));
        response.setNormas(evento.getNormas());
        response.setGenero(evento.getGenero());

		if (evento.getRecinto() != null) {
			response.setRecinto(RecintoResponse.of(evento.getRecinto()));
		}

		

		return response;
	}

	/**
	 * Método estático para convertir una lista de objetos Eventos a una lista de
	 * objetos EventoResponse.
	 *
	 * @param eventos La lista de objetos Eventos a convertir.
	 * @return Una lista de objetos EventoResponse que representan las respuestas de los eventos.
	 */
	public static List<EventoResponse> of(List<Eventos> eventos) {
		return eventos.stream().map(c -> of(c)).collect(Collectors.toList());
	}

	public int getEventoID() {
		return eventoID;
	}

	public void setEventoID(int eventoID) {
		this.eventoID = eventoID;
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

	public String getPreciomin() {
		return preciomin;
	}

	public void setPreciomin(String preciomin) {
		this.preciomin = preciomin;
	}

	public String getPreciomax() {
		return preciomax;
	}

	public void setPreciomax(String preciomax) {
		this.preciomax = preciomax;
	}

	public String getNormas() {
		return normas;
	}

	public void setNormas(String normas) {
		this.normas = normas;
	}

	public RecintoResponse getRecinto() {
		return recinto;
	}

	public void setRecinto(RecintoResponse recinto) {
		this.recinto = recinto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
