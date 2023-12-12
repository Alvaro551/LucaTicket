package com.ejemplos.spring.model;

/**
 * Clase que representa una respuesta personalizada con información adicional.
 *
 * @param <T> Tipo de la información contenida en la respuesta.
 */
public class CustomResponse<T> {
	private int status;
	private String message;
	private T info;


    /**
     * Constructor predeterminado de CustomResponse.
     */
	public CustomResponse() {
		super();
	}

	  /**
     * Constructor de CustomResponse que toma el estado, un mensaje y la información.
     *
     * @param status  Estado de la respuesta.
     * @param message Mensaje asociado a la respuesta.
     * @param info    Información contenida en la respuesta.
     */
	public CustomResponse(int status, String message, T info) {
		super();
		this.status = status;
		this.message = message;
		this.info = info;
	}


    /**
     * Obtiene el estado de la respuesta.
     *
     * @return Estado de la respuesta.
     */
	public int getStatus() {
		return status;
	}

	 /**
     * Establece el estado de la respuesta.
     *
     * @param status Estado de la respuesta.
     */
	public void setStatus(int status) {
		this.status = status;
	}

	  /**
     * Obtiene el mensaje asociado a la respuesta.
     *
     * @return Mensaje de la respuesta.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje asociado a la respuesta.
     *
     * @param message Mensaje de la respuesta.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Obtiene la información contenida en la respuesta.
     *
     * @return Información contenida en la respuesta.
     */
    public T getInfo() {
        return info;
    }

    /**
     * Establece la información contenida en la respuesta.
     *
     * @param info Información contenida en la respuesta.
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Crea una respuesta de éxito con la información proporcionada.
     *
     * @param objeto Información para la respuesta de éxito.
     * @param <T>    Tipo de la información.
     * @return Objeto CustomResponse que representa una respuesta de éxito.
     */
    public static <T> CustomResponse<T> createSuccessResponse(T objeto) {
        return new CustomResponse<>(200, "Éxito", objeto);
    }

    /**
     * Crea una respuesta de conflicto con el mensaje y la información proporcionada.
     *
     * @param mensaje Mensaje de conflicto.
     * @param objeto  Información para la respuesta de conflicto.
     * @param <T>     Tipo de la información.
     * @return Objeto CustomResponse que representa una respuesta de conflicto.
     */
    public static <T> CustomResponse<T> createConflictResponse(String mensaje, T objeto) {
        return new CustomResponse<>(409, mensaje, objeto);
    }

    /**
     * Crea una respuesta de recurso no disponible con el mensaje y la información proporcionada.
     *
     * @param mensaje Mensaje de recurso no disponible.
     * @param objeto  Información para la respuesta de recurso no disponible.
     * @param <T>     Tipo de la información.
     * @return Objeto CustomResponse que representa una respuesta de recurso no disponible.
     */
    public static <T> CustomResponse<T> createGoneResponse(String mensaje, T objeto) {
        return new CustomResponse<>(410, mensaje, objeto);
    }

    /**
     * Crea una respuesta de recurso no encontrado con el mensaje proporcionado.
     *
     * @param message Mensaje de recurso no encontrado.
     * @param <T>     Tipo de la información (nulo en este caso).
     * @return Objeto CustomResponse que representa una respuesta de recurso no encontrado.
     */
    public static <T> CustomResponse<T> createNotFoundResponse(String message) {
        return new CustomResponse<>(404, message, null);
    }

    /**
     * Crea una respuesta de error interno del servidor con el mensaje proporcionado.
     *
     * @param message Mensaje de error interno del servidor.
     * @param <T>     Tipo de la información (nulo en este caso).
     * @return Objeto CustomResponse que representa una respuesta de error interno del servidor.
     */
    public static <T> CustomResponse<T> createInternalServerErrorResponse(String message) {
        return new CustomResponse<>(500, message, null);
    }
}

