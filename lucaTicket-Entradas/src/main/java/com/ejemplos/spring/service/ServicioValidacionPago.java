package com.ejemplos.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.client.EventoClient;
import com.ejemplos.spring.client.UsuarioClient;
import com.ejemplos.spring.model.DatosTarjeta;
import com.ejemplos.spring.model.Entrada;
import com.ejemplos.spring.model.EventoDTO;
import com.ejemplos.spring.model.RespuestaPago;
import com.ejemplos.spring.model.UsuarioDTO;
import com.ejemplos.spring.repository.EntradaRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServicioValidacionPago implements ServicioValidacionPagoInterfaz {

	private final RestTemplate restTemplate;

	private final List<DatosTarjeta> tarjetasAlmacenadas = new ArrayList<>();

	private final EntradaRepository entradaRepository;

	private final UsuarioClient usuarioClient;

	private final EventoClient eventoClient;

	@Autowired
	public ServicioValidacionPago(EntradaRepository entradaRepository, UsuarioClient usuarioClient,
			EventoClient eventoClient, RestTemplate restTemplate) {
		this.entradaRepository = entradaRepository;
		this.usuarioClient = usuarioClient;
		this.eventoClient = eventoClient;
		this.restTemplate = restTemplate;
	}

	@Override
	public Entrada addEntrada(int usuarioId, int eventoId) {
		// Verifica si el usuario existe
		if (usuarioClient.obtenerUsuarioPorId(usuarioId) == null) {
			throw new RuntimeException("Usuario no encontrado");
		}

		// Verifica si el evento existe
		if (eventoClient.obtenerEventoPorId(eventoId) == null) {
			throw new RuntimeException("Evento no encontrado");
		}

		// Si ambos existen, crea la entrada
		Entrada nuevaEntrada = new Entrada();
		nuevaEntrada.setIdUsuario(usuarioId);
		nuevaEntrada.setIdEvento(eventoId);

		return entradaRepository.save(nuevaEntrada);
	}

	/**
	 * Realiza la validación de un pago utilizando una pasarela externa.
	 *
	 * @param datosTarjeta Datos de la tarjeta de crédito para la validación.
	 * @return Respuesta de la validación del pago.
	 * @throws RuntimeException Si hay un error al realizar la validación del pago.
	 */
	public RespuestaPago realizarValidacionPago(DatosTarjeta datosTarjeta) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJiYzJhYzBiMTA2ZmY0NGUyOTk0ZjQxMDRkYjc2ZjQxYiIsInN1YiI6IkdydXBvMDQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzAyMzczMTA2LCJleHAiOjE3MDIzNzM3MDZ9.74LvUQoIxJy_IVSInrlgcqqQ8NaHgFzfhkpGckW2j16RlMN23LkVDcU0gkJYistYRM4HXZBj0WBAbgNVF9lthA");

		HttpEntity<DatosTarjeta> request = new HttpEntity<>(datosTarjeta, headers);

		String url = "http://banco-env.eba-3zvamy8n.eu-west-3.elasticbeanstalk.com/pasarela/validacion/";
		try {
			ResponseEntity<RespuestaPago> response = restTemplate.postForEntity(url, request, RespuestaPago.class);

			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				return response.getBody();
			} else {
				throw new RuntimeException("Error al realizar la validación del pago");
			}
		} catch (HttpClientErrorException ex) {
			manejarErrorHttpClient(ex);
			String mensajeErrorProcesado = procesarMensajeDeError(ex.getResponseBodyAsString());
			throw new RuntimeException("Error al realizar la validación del pago: " + mensajeErrorProcesado);
		} catch (HttpServerErrorException ex) {
			// Aquí puedes manejar errores específicos del servidor
			String mensajeErrorServidor = procesarMensajeDeError(ex.getResponseBodyAsString());
			throw new RuntimeException(
					"Error del servidor al realizar la validación del pago: " + mensajeErrorServidor);
		} catch (Exception ex) {
			// Manejo de otros tipos de excepciones no relacionadas con HTTP
			throw new RuntimeException("Error inesperado al realizar la validación del pago: " + ex.getMessage());
		}

	}

	private void manejarErrorHttpClient(HttpClientErrorException ex) {
		if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {

			String errorBody = ex.getResponseBodyAsString();

		}

	}

	private String procesarMensajeDeError(String jsonError) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(jsonError);
			String mensajeError = rootNode.path("error").asText();
			JsonNode mensajes = rootNode.path("message");

			StringBuilder mensajeFinal = new StringBuilder(mensajeError);
			if (mensajes.isArray()) {
				for (JsonNode msg : mensajes) {
					mensajeFinal.append(" . ").append(msg.asText());
				}
			}
			return mensajeFinal.toString();
		} catch (Exception e) {
			// En caso de que no se pueda parsear el JSON, devolver el mensaje original
			return jsonError;
		}
	}

	/**
	 * Guarda los datos de una tarjeta de crédito en la lista de tarjetas
	 * almacenadas.
	 *
	 * @param datosTarjeta Datos de la tarjeta de crédito a almacenar.
	 */
	public void guardarDatosTarjeta(DatosTarjeta datosTarjeta) {
		// Aquí simplemente añadimos los datos de la tarjeta a la lista
		tarjetasAlmacenadas.add(datosTarjeta);
	}

	/**
	 * Obtiene la lista de tarjetas de crédito almacenadas.
	 *
	 * @return Lista de tarjetas de crédito almacenadas.
	 */
	public List<DatosTarjeta> obtenerTarjetasAlmacenadas() {
		return tarjetasAlmacenadas;
	}

}
