package com.ejemplos.spring.model;


/**
 * La clase CustomResponse representa una respuesta personalizada que puede contener información adicional.
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

	 /**
     * Crea una respuesta de éxito con el código de estado 200 y un mensaje predeterminado de éxito.
     *
     * @param objeto La información a incluir en la respuesta.
     * @param <T>    El tipo de información.
     * @return Una instancia de CustomResponse con un código de estado 200, mensaje de éxito y la información proporcionada.
     */
	public static <T> CustomResponse<T> createSuccessResponse(T objeto) {
		return new CustomResponse<>(200, "Éxito", objeto);
	}

	  /**
     * Crea una respuesta de conflicto con el código de estado 409 y un mensaje de conflicto personalizado.
     *
     * @param mensaje El mensaje de conflicto.
     * @param objeto  La información a incluir en la respuesta.
     * @param <T>     El tipo de información.
     * @return Una instancia de CustomResponse con un código de estado 409, el mensaje de conflicto y la información proporcionada.
     */
	public static <T> CustomResponse<T> createConflictResponse(String mensaje, T objeto) {
		return new CustomResponse<>(409, mensaje, objeto);
	}

	  /**
     * Crea una respuesta de recurso eliminado con el código de estado 410 y un mensaje de recurso eliminado personalizado.
     *
     * @param mensaje El mensaje de recurso eliminado.
     * @param objeto  La información a incluir en la respuesta.
     * @param <T>     El tipo de información.
     * @return Una instancia de CustomResponse con un código de estado 410, el mensaje de recurso eliminado y la información proporcionada.
     */
	public static <T> CustomResponse<T> createGoneResponse(String mensaje, T objeto) {
		return new CustomResponse<>(410, mensaje, objeto);
	}

	  /**
     * Crea una respuesta de recurso no encontrado con el código de estado 404 y un mensaje de recurso no encontrado.
     *
     * @param message El mensaje de recurso no encontrado.
     * @param <T>     El tipo de información.
     * @return Una instancia de CustomResponse con un código de estado 404, el mensaje de recurso no encontrado y sin información.
     */
	public static <T> CustomResponse<T> createNotFoundResponse(String message) {
		return new CustomResponse<>(404, message, null);
	}

	  /**
     * Crea una respuesta de error interno del servidor con el código de estado 500 y un mensaje de error interno.
     *
     * @param message El mensaje de error interno del servidor.
     * @param <T>     El tipo de información.
     * @return Una instancia de CustomResponse con un código de estado 500, el mensaje de error interno y sin información.
     */
	public static <T> CustomResponse<T> createInternalServerErrorResponse(String message) {
		return new CustomResponse<>(500, message, null);
	}
}
