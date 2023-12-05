package com.ejemplos.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Eventos;
import com.ejemplos.spring.repository.EventoRepository;

/**
 * Implementación de la interfaz EventoService que proporciona servicios relacionados con eventos.
 */
@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	 /**
     * Recupera todos los eventos.
     *
     * @return Lista de todos los eventos.
     */
	@Override
	public List<Eventos> findAll() {
		return eventoRepository.findAll();
	}

	 /**
     * Agrega un nuevo evento después de validar sus datos.
     *
     * @param evento El evento a agregar.
     * @return El evento agregado.
     * @throws IllegalArgumentException Si faltan datos obligatorios o son inválidos en el evento.
     */
	@Override
	public Eventos addEvento(Eventos evento) {
		if (esNombreValido(evento.getNombre()) && esDescripcionCortaValida(evento.getDescripcioncorta())
				&& esDescripcionExtendidaValida(evento.getDescripcionextendida()) && esFotoValida(evento.getFoto())
				&& esFechaEventoValida(evento.getFechaevento()) && esHoraEventoValida(evento.getHoraevento())
				&& esPrecioMinValido(evento.getPreciomin()) && esPrecioMaxValido(evento.getPreciomax())
				&& esNormasValida(evento.getNormas()) && esGeneroValido(evento.getGenero())) {
			return eventoRepository.save(evento);
		} else {
			throw new IllegalArgumentException("Faltan datos obligatorios o son inválidos en el evento");
		}
	}

	private boolean esNombreValido(String nombre) {
		return nombre != null && !nombre.trim().isEmpty();
	}

	private boolean esDescripcionCortaValida(String descripcion) {
		return descripcion != null && !descripcion.trim().isEmpty();
	}

	private boolean esDescripcionExtendidaValida(String descripcion) {
		return descripcion != null && !descripcion.trim().isEmpty();
	}

	private boolean esPrecioMinValido(double precio) {
		return precio >= 0;
	}

	private boolean esPrecioMaxValido(double precio) {
		return precio >= 0;
	}

	private boolean esFechaEventoValida(LocalDate fecha) {
		return fecha != null;
	}

	private boolean esHoraEventoValida(LocalDateTime hora) {
		return hora != null;
	}

	private boolean esNormasValida(String normas) {
		return normas != null && !normas.trim().isEmpty();
	}

	private boolean esFotoValida(String foto) {
		return foto.toLowerCase().endsWith(".jpg") && foto != null;
	}
	
	private boolean esGeneroValido(String genero) {
		return genero != null && !genero.trim().isEmpty();
	}

	/**
     * Busca un evento por su identificador.
     *
     * @param id El identificador del evento a buscar.
     * @return Un Optional que contiene el evento si se encuentra.
     */
	@Override
	public Optional<Eventos> buscarEventoPorId(Integer id) {

		return eventoRepository.findById(id);
	}

	@Override
	public List<Eventos> filtrarGenero(String genero) {

		return eventoRepository.findByGenero(genero);
		
	}
}
