package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ejemplos.spring.model.CustomResponse;
import com.ejemplos.spring.model.DatosTarjeta;
import com.ejemplos.spring.model.Entrada;
import com.ejemplos.spring.model.PagoYEntradaResponse;
import com.ejemplos.spring.model.RespuestaPago;
import com.ejemplos.spring.service.ServicioValidacionPago;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Controlador que gestiona las operaciones relacionadas con los pagos.
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {

	@Autowired
	private ServicioValidacionPago servicioValidacionPago;

	/**
	 * Endpoint para validar y almacenar los datos de una tarjeta de crédito.
	 *
	 * @param datosTarjeta Datos de la tarjeta de crédito.
	 * @param token        Token de autorización.
	 * @return Respuesta de la validación del pago.
	 */
	@PostMapping("/validar-guardar/{usuarioId}/{eventoId}")
	@Operation(summary = "Validar y guardar pago para un evento", 
	           description = "Valida los datos de pago y guarda una nueva entrada para un usuario y evento específicos.")
	@ApiResponses(value = { 
	    @ApiResponse(responseCode = "200", description = "Pago validado y entrada guardada con éxito",
	                 content = @Content(schema = @Schema(implementation = PagoYEntradaResponse.class))),
	    @ApiResponse(responseCode = "400", description = "Datos de pago inválidos"),
	    @ApiResponse(responseCode = "404", description = "Usuario o evento no encontrado"),
	    @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	})
	public ResponseEntity<CustomResponse<PagoYEntradaResponse>> validarPago(
	    @Parameter(description = "ID del usuario") @PathVariable int usuarioId,
	    @Parameter(description = "ID del evento") @PathVariable int eventoId, 
	    @RequestBody DatosTarjeta datosTarjeta,
	    @Parameter(description = "Token de autorización") @RequestHeader("Authorization") String token) {

	    RespuestaPago respuesta = servicioValidacionPago.realizarValidacionPago(datosTarjeta);
	    Entrada nuevaEntrada = servicioValidacionPago.addEntrada(usuarioId, eventoId);
	    servicioValidacionPago.guardarDatosTarjeta(datosTarjeta);

	    PagoYEntradaResponse pagoYEntradaResponse = new PagoYEntradaResponse();
	    pagoYEntradaResponse.setRespuestaPago(respuesta);
	    pagoYEntradaResponse.setEntrada(nuevaEntrada);

	    return ResponseEntity.ok(CustomResponse.createSuccessResponse(pagoYEntradaResponse));
	}

	
	/**
	 * Endpoint para obtener la lista de tarjetas de crédito almacenadas.
	 *
	 * @return Lista de tarjetas de crédito almacenadas.
	 */
	/*
	@GetMapping("/tarjetas-almacenadas")
	public ResponseEntity<CustomResponse<List<DatosTarjeta>>> obtenerTarjetasAlmacenadas() {
		List<DatosTarjeta> tarjetas = servicioValidacionPago.obtenerTarjetasAlmacenadas();
		if (tarjetas.isEmpty()) {

		}
		return ResponseEntity.ok(CustomResponse.createSuccessResponse(tarjetas));
	}
	*/

	@GetMapping("/crear/{usuarioId}/{eventoId}")
	public ResponseEntity<CustomResponse<Entrada>> crearEntrada(@PathVariable int usuarioId,

			@PathVariable int eventoId) {
		try {
			Entrada nuevaEntrada = servicioValidacionPago.addEntrada(usuarioId, eventoId);
			return ResponseEntity.ok(CustomResponse.createSuccessResponse(nuevaEntrada));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(CustomResponse.createInternalServerErrorResponse("Error al crear la entrada"));
		}
	}

}
