package com.ejemplos.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
	
	public Eventos addEvento(Eventos evento) {
	    List<String> errores = new ArrayList<>();

	    String errorNombre = validarNombre(evento.getNombre());
	    if (errorNombre != null) {
	        errores.add(errorNombre);
	    }

	    String errorDescripcionCorta = validarDescripcionCorta(evento.getDescripcioncorta());
	    if (errorDescripcionCorta != null) {
	        errores.add(errorDescripcionCorta);
	    }

	    String errorDescripcionExtendida = validarDescripcionExtendida(evento.getDescripcionextendida());
	    if (errorDescripcionExtendida != null) {
	        errores.add(errorDescripcionExtendida);
	    }

	    String errorFoto = validarFoto(evento.getFoto());
	    if (errorFoto != null) {
	        errores.add(errorFoto);
	    }

	    String errorFechaEvento = validarFechaEvento(evento.getFechaevento());
	    if (errorFechaEvento != null) {
	        errores.add(errorFechaEvento);
	    }

	    String errorHoraEvento = validarHoraEvento(evento.getHoraevento());
	    if (errorHoraEvento != null) {
	        errores.add(errorHoraEvento);
	    }

	    String errorPrecioMin = validarPrecioMin(evento.getPreciomin());
	    if (errorPrecioMin != null) {
	        errores.add(errorPrecioMin);
	    }

	    String errorPrecioMax = validarPrecioMax(evento.getPreciomax());
	    if (errorPrecioMax != null) {
	        errores.add(errorPrecioMax);
	    }

	    String errorNormas = validarNormas(evento.getNormas());
	    if (errorNormas != null) {
	        errores.add(errorNormas);
	    }

	    String errorGenero = validarGenero(evento.getGenero());
	    if (errorGenero != null) {
	        errores.add(errorGenero);
	    }

	    if (!errores.isEmpty()) {
	        throw new IllegalArgumentException(String.join(", ", errores));
	    }

	    return eventoRepository.save(evento);
	}

	private String validarNombre(String nombre) {
	    if (nombre == null || nombre.trim().isEmpty()) {
	        return "El nombre del evento es inválido o nulo";
	    }
	    return null;
	}

	private String validarDescripcionCorta(String descripcion) {
	    if (descripcion == null || descripcion.trim().isEmpty()) {
	        return "La descripción corta del evento es inválida o nula";
	    }
	    return null;
	}

	private String validarDescripcionExtendida(String descripcion) {
	    if (descripcion == null || descripcion.trim().isEmpty()) {
	        return "La descripción extendida del evento es inválida o nula";
	    }
	    return null;
	}

	private String validarFoto(String foto) {
	    if (foto == null || !foto.toLowerCase().endsWith(".jpg")) {
	        return "La foto del evento es inválida o nula";
	    }
	    return null;
	}

	private String validarFechaEvento(LocalDate fecha) {
	    if (fecha == null) {
	        return "La fecha del evento es inválida o nula";
	    }
	    return null;
	}

	private String validarHoraEvento(LocalDateTime hora) {
	    if (hora == null) {
	        return "La hora del evento es inválida o nula";
	    }
	    return null;
	}

	private String validarPrecioMin(double precio) {
	    if (precio < 0) {
	        return "El precio mínimo del evento es inválido";
	    }
	    return null;
	}

	private String validarPrecioMax(double precio) {
	    if (precio < 1) {
	        return "El precio máximo del evento es inválido";
	    }
	    return null;
	}

	private String validarNormas(String normas) {
	    if (normas == null || normas.trim().isEmpty()) {
	        return "Las normas del evento son inválidas o nulas";
	    }
	    return null;
	}

	private String validarGenero(String genero) {
	    if (genero == null || genero.trim().isEmpty()) {
	        return "El género del evento es inválido o nulo";
	    }
	    return null;
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

	@Override
	public List<Eventos> filtrarCiudad(String ciudad) {
		return eventoRepository.findByRecintoCiudad(ciudad);
	}
}
