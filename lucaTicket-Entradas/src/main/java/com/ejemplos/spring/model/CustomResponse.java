package com.ejemplos.spring.model;

import java.util.Optional;

/**
 * La clase CustomResponse representa una respuesta personalizada que puede
 * contener información adicional.
 *
 * @param <T> El tipo de información contenida en la respuesta.
 */
public class CustomResponse<T> {
	private int status;
	private String message;
	private T info;

	/**
	 * Constructor por defecto de CustomResponse.
	 */
	public CustomResponse() {
		super();
	}

	/**
	 * Constructor de CustomResponse con parámetros.
	 *
	 * @param status  El código de estado de la respuesta.
	 * @param message El mensaje asociado con la respuesta.
	 * @param info    La información contenida en la respuesta.
	 */
	public CustomResponse(int status, String message, T info) {
		super();
		this.status = status;
		this.message = message;
		this.info = info;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public static <T> CustomResponse<T> createSuccessResponse(T objeto) {
		return new CustomResponse<>(200, "Éxito", objeto);
	}

	public static <T> CustomResponse<T> createInternalServerErrorResponse(String message) {
		return new CustomResponse<>(500, message, null);
	}

	public static <T> CustomResponse<T> createCustomResponse(int statusCode, String customMessage, T info) {
		String message = getMessageForStatusCode(statusCode, customMessage);
		return new CustomResponse<>(statusCode, message, info);
	}

	private static String getMessageForStatusCode(int statusCode, String customMessage) {
		if (customMessage != null && !customMessage.isEmpty()) {
			return customMessage;
		}

		switch (statusCode) {
		case 200:
			return "Transacción correcta.";
		case 400:
			return determineBadRequestMessage();
		case 404:
			return "Recurso no encontrado.";
		case 409:
			return "Conflicto detectado.";
		case 410:
			return "Recurso eliminado.";
		case 500:
			return "Error interno del servidor.";
		default:
			return "Error no identificado.";
		}
	}

	private static String determineBadRequestMessage() {
		// Aquí puedes determinar un mensaje más específico basado en el código de error
		// detallado, si está disponible
		// Por ejemplo, si tienes un subcódigo o si puedes obtener más detalles del
		// error, puedes implementar la lógica aquí.
		return "Solicitud incorrecta.";
	}
}
