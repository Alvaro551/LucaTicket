package com.ejemplos.spring.model;

public class CustomResponse<T> {
	private int status;
	private String message;
	private T info;

	public CustomResponse() {
		super();
	}

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

	public static <T> CustomResponse<T> createConflictResponse(String mensaje, T objeto) {
		return new CustomResponse<>(409, mensaje, objeto);
	}

	public static <T> CustomResponse<T> createGoneResponse(String mensaje, T objeto) {
		return new CustomResponse<>(410, mensaje, objeto);
	}

	public static <T> CustomResponse<T> createNotFoundResponse(String message) {
		return new CustomResponse<>(404, message, null);
	}

	public static <T> CustomResponse<T> createInternalServerErrorResponse(String message) {
		return new CustomResponse<>(500, message, null);
	}
}
