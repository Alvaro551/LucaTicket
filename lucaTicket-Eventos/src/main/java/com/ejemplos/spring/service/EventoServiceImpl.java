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
 * Implementación de la interfaz EventoService que proporciona servicios
 * relacionados con eventos.
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
	 * @throws IllegalArgumentException Si faltan datos obligatorios o son inválidos
	 *                                  en el evento.
	 */
	@Override
	public Eventos addEvento(Eventos evento) {
		validarEvento(evento);
		return eventoRepository.save(evento);

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

	public boolean borrarEventoPorId(Integer id) {
		if (!eventoRepository.existsById(id)) {
			return false;
		}
		eventoRepository.deleteById(id);
		return true;
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
		if (!esGeneroValido(evento.getGenero())) {
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

	private boolean esGeneroValido(String genero) {
		return genero != null && !genero.trim().isEmpty();
	}

	@Override
	public List<Eventos> buscarEventosPorNombre(String nombre) {
		return eventoRepository.findByNombre(nombre);
	}

	@Override
	public List<Eventos> filtrarGenero(String genero) {

		return eventoRepository.findByGenero(genero);

	}

	@Override
	public Eventos editarEvento(Integer idEvento, Eventos eventoNuevo) {
		Optional<Eventos> evento = eventoRepository.findById(idEvento);
		if(evento.isPresent()) {
			//Cambiando valores según los que le mandamos
			Eventos eventoActualizado = evento.get();
			eventoActualizado.setNombre(eventoNuevo.getNombre());
			eventoActualizado.setDescripcioncorta(eventoNuevo.getDescripcioncorta());
			eventoActualizado.setDescripcionextendida(eventoNuevo.getDescripcionextendida());
			eventoActualizado.setGenero(eventoNuevo.getGenero());
			eventoActualizado.setFoto(eventoNuevo.getFoto());
			eventoActualizado.setFechaevento(eventoNuevo.getFechaevento());
			eventoActualizado.setHoraevento(eventoNuevo.getHoraevento());
			eventoActualizado.setPreciomin(eventoNuevo.getPreciomin());
			eventoActualizado.setPreciomax(eventoNuevo.getPreciomax());
			eventoActualizado.setNormas(eventoNuevo.getNormas());
			
			//Hacemos el update
			return eventoRepository.save(eventoActualizado);
		}else {
			System.out.println("Ese evento no existe");
			return null;
		}
	}
}
