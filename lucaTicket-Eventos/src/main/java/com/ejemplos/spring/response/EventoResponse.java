package com.ejemplos.spring.response;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ejemplos.spring.model.Eventos;

// DTO para la respuesta de Evento
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionExtendida;
	private String foto;
	private Date fechaEvento;
	private Date horaEvento;
	private double precioMinimo;
	private double precioMaximo;
	private String normas;
	private RecintoResponse recinto; // Asumiendo que tienes una clase RecintoResponse

	public static EventoResponse of(Eventos evento) {
		EventoResponse response = new EventoResponse();
		response.setId(evento.getId());
		response.setNombre(evento.getNombre());
		response.setDescripcionCorta(evento.getDescripcionCorta());
		response.setDescripcionExtendida(evento.getDescripcionExtendida());
		response.setFoto(evento.getFoto());
		response.setFechaEvento((Date) evento.getFechaEvento());
		response.setHoraEvento((Date) evento.getHoraEvento());
		response.setPrecioMinimo(evento.getPrecioMinimo());
		response.setPrecioMaximo(evento.getPrecioMaximo());
		response.setNormas(evento.getNormas());
		response.setRecinto(RecintoResponse.of(evento.getRecinto()));

		return response;
	}

	public static List<EventoResponse> of(List<Eventos> eventos) {
		return eventos.stream().map(c -> of(c)).collect(Collectors.toList());
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

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionExtendida() {
		return descripcionExtendida;
	}

	public void setDescripcionExtendida(String descripcionExtendida) {
		this.descripcionExtendida = descripcionExtendida;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Date getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(Date horaEvento) {
		this.horaEvento = horaEvento;
	}

	public double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public double getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(double precioMaximo) {
		this.precioMaximo = precioMaximo;
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
