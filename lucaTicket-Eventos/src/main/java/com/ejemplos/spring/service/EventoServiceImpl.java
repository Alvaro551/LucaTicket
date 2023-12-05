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
		validarEvento(evento);	
		return eventoRepository.save(evento);

	}

	private void validarEvento(Eventos evento) {
		if (!esNombreValido(evento.getNombre())) {
			throw new IllegalArgumentException("El nombre del evento es inválido o nulo");
		}
		if (!esDescripcionCortaValida(evento.getDescripcioncorta())) {
			throw new IllegalArgumentException("La descripción corta del evento es inválida o nula");
		}
		if (!esDescripcionExtendidaValida(evento.getDescripcionextendida())) {
			throw new IllegalArgumentException("La descripción extendida del evento es inválida o nula");
		}

		if (!esFotoValida(evento.getFoto())) {
			throw new IllegalArgumentException("La foto del evento es inválida o nula");
		}
		if (!esFechaEventoValida(evento.getFechaevento())) {
			throw new IllegalArgumentException("La fecha del evento es inválida o nula");
		}
		if (!esHoraEventoValida(evento.getHoraevento())) {
			throw new IllegalArgumentException("La hora del evento es inválida o nula");
		}
		if (!esPrecioMinValido(evento.getPreciomin())) {
			throw new IllegalArgumentException("El precio mínimo del evento es inválido");
		}
		if (!esPrecioMaxValido(evento.getPreciomax())) {
			throw new IllegalArgumentException("El precio máximo del evento es inválido");
		}
		if (!esNormasValida(evento.getNormas())) {
			throw new IllegalArgumentException("Las normas del evento son inválidas o nulas");
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
		return precio >= 1;
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
}
