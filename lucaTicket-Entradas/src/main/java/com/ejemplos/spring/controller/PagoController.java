package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.DatosTarjeta;
import com.ejemplos.spring.model.RespuestaPago;
import com.ejemplos.spring.service.ServicioValidacionPago;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

	private final ServicioValidacionPago servicioValidacionPago;

	@Autowired
	public PagoController(ServicioValidacionPago servicioValidacionPago) {
		this.servicioValidacionPago = servicioValidacionPago;
	}

	@PostMapping("/validar-guardar")
	public ResponseEntity<CustomResponse<RespuestaPago>> validarPago(@RequestBody DatosTarjeta datosTarjeta,
			@RequestHeader("Authorization") String token) {
		try {
			RespuestaPago respuesta = servicioValidacionPago.realizarValidacionPago(datosTarjeta);
			servicioValidacionPago.guardarDatosTarjeta(datosTarjeta);
			return ResponseEntity.ok(CustomResponse.createSuccessResponse(respuesta));

		} catch (RuntimeException ex) {

			return ResponseEntity.badRequest().body(CustomResponse.createCustomResponse(400, ex.getMessage(), null));
		} catch (Exception ex) {

			return ResponseEntity.status(500)
					.body(CustomResponse.createInternalServerErrorResponse("Error interno del servidor."));
		}
	}

	@GetMapping("/tarjetas-almacenadas")
	public ResponseEntity<CustomResponse<List<DatosTarjeta>>> obtenerTarjetasAlmacenadas() {
		List<DatosTarjeta> tarjetas = servicioValidacionPago.obtenerTarjetasAlmacenadas();
		if (tarjetas.isEmpty()) {

		}
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(tarjetas));
	}

}