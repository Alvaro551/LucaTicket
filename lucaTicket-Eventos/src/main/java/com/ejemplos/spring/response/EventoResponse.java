package com.ejemplos.spring.response;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.model.Recinto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// DTO para la respuesta de Evento
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private int eventoID;
	private String nombre;
	private String descripcioncorta;
	private String descripcionextendida;
	private String foto;
	private LocalDate fechaevento;
	private LocalDateTime horaevento;
	private String preciomin;
	private String preciomax;
	private String normas;
	private RecintoResponse recinto; 

	public static EventoResponse of(Eventos evento) {
		EventoResponse response = new EventoResponse();

		response.setEventoID(evento.getId());
		response.setNombre(evento.getNombre());
		response.setDescripcioncorta(evento.getDescripcioncorta());
		response.setDescripcionextendida(evento.getDescripcionextendida());
		response.setFoto(evento.getFoto());
		response.setFechaevento(evento.getFechaevento());
		response.setHoraevento(evento.getHoraevento());
		response.setPreciomin(String.format("%.2f €", evento.getPreciomin()));
		response.setPreciomax(String.format("%.2f €", evento.getPreciomax()));
		response.setNormas(evento.getNormas());

		if (evento.getRecinto() != null) {
			response.setRecinto(RecintoResponse.of(evento.getRecinto()));

		}

		

		return response;
	}

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

}
