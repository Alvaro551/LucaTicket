package com.ejemplos.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.DatosTarjeta;
import com.ejemplos.spring.model.RespuestaPago;

/**
 * Servicio que realiza la validación de pagos y gestiona datos de tarjetas.
 */
@Service
public class ServicioValidacionPago {

    private final RestTemplate restTemplate;
    
    private final List<DatosTarjeta> tarjetasAlmacenadas = new ArrayList<>();

    /**
     * Constructor que recibe una instancia de RestTemplate.
     *
     * @param restTemplate Instancia de RestTemplate para realizar solicitudes HTTP.
     */
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
        headers.setBearerAuth("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJmOWU3OTQ5OWQ2OGQ0YzZiYWM1ZjM3N2ZiNjgxMDA0OCIsInN1YiI6IkdydXBvMDQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzAyMjUwMTYxLCJleHAiOjE3MDIyNTA3NjF9.DRyfIFbcTGDlz_FS76Uo8tHotKvfMkX2fuBbAVsxvOUAE4vXvJeWgYriqKPRZ_CpCGx4BgyXBl8S02cWrOxYXQ"); // Reemplaza con el token adecuado

        HttpEntity<DatosTarjeta> request = new HttpEntity<>(datosTarjeta, headers);

        String url = "http://banco-env.eba-3zvamy8n.eu-west-3.elasticbeanstalk.com/pasarela/validacion/";
        
        ResponseEntity<RespuestaPago> response = restTemplate.postForEntity(url, request, RespuestaPago.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error al realizar la validación del pago");
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
