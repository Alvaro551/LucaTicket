package com.ejemplos.spring.controller.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase CustomErrorJson representa un objeto JSON personalizado para las respuestas de error.
 */
public class CustomErrorJson {

	// Modificado. Originalmente era una fecha
	private String timestamp;
	private int status;
	private String error;
	private String trace;
	private List<String> message;
	private String path;

	// Extras
	private String jdk;
	// private String infoadicional;

	  /**
     * Constructor por defecto de CustomErrorJson.
     * Inicializa los atributos con valores predeterminados.
     */
	public CustomErrorJson() {
		super();
		this.timestamp = "";
		this.status = 0;
		this.error = "";
		this.trace = "";
		this.message = new ArrayList<>();
		this.path = "";
		this.jdk = "ND";
	}

	/**
     * Constructor de CustomErrorJson con parámetros.
     *
     * @param timestamp La marca de tiempo del error.
     * @param status    El código de estado del error.
     * @param error     La descripción del error.
     * @param trace     La traza del error.
     * @param message   La lista de mensajes de error.
     * @param path      La ruta del recurso que generó el error.
     * @param jdk       La versión de JDK utilizada.
     */
	public CustomErrorJson(Date timestamp, int status, String error, String trace, List<String> message, String path,
			String jdk) {
		super();
		// Formato DD/MM/YY
		this.timestamp = this.changeTimeStamp(timestamp);
		this.status = status;
		this.error = error;
		this.trace = trace;
		this.message = message;
		this.path = path;
		this.jdk = jdk;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	// Variacion
	public void setTimestamp(Date timestamp) {
		this.timestamp = this.changeTimeStamp(timestamp);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getJdk() {
		return jdk;
	}

	public void setJdk(String jdk) {
		this.jdk = jdk;
	}

	@Override
	public String toString() {
		return "CustomErrorJson [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", trace="
				+ trace + ", message=" + message + ", path=" + path + ", jdk=" + jdk + "]";
	}

	private String changeTimeStamp(Date d) {
		// Formato España
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// format & update timestamp
		return dateFormat.format(d);
	}

}
