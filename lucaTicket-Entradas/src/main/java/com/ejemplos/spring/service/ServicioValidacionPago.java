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
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.DatosTarjeta;
import com.ejemplos.spring.model.RespuestaPago;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServicioValidacionPago {

	private final RestTemplate restTemplate;

	private final List<DatosTarjeta> tarjetasAlmacenadas = new ArrayList<>();

	@Autowired
	public ServicioValidacionPago(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
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
		headers.setBearerAuth("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIzZTY0Zjk0ZmM0OW"
				+ "E0ZDRhOThlODNjYTg4N2I5YjRkNiIsInN1YiI6IkdydXBvMDQiLCJhdX"
				+ "Rob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzAyMjk5NjAyLCJleHAi"
				+ "OjE3MDIzMDAyMDJ9.dLWEpN984aZHg3W-4C4pf-QvnCnZ1tg6jU9v9jb"
				+ "FIsBuhHrhS6swRdNseCVGwzhIgUvL08zyJqL8LKYO0eoe2Q");

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
			// Manejar el HttpClientErrorException
			manejarErrorHttpClient(ex);
			String mensajeErrorProcesado = procesarMensajeDeError(ex.getResponseBodyAsString());
			throw new RuntimeException("Error al realizar la validación del pago: " + mensajeErrorProcesado);

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
					mensajeFinal.append("\n").append(msg.asText());
				}
			}
			return mensajeFinal.toString();
		} catch (Exception e) {
			// En caso de que no se pueda parsear el JSON, devolver el mensaje original
			return jsonError;
		}
	}
/**
     * Guarda los datos de una tarjeta de crédito en la lista de tarjetas almacenadas.
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

