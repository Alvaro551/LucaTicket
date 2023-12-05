package com.ejemplos.spring.controller.error;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Clase que representa una estructura personalizada para los errores en formato JSON.
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
     * Constructor por defecto.
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
     * Constructor con parámetros.
     *
     * @param timestamp   La marca de tiempo del error.
     * @param status      El código de estado del error.
     * @param error       La descripción del error.
     * @param trace       La traza del error.
     * @param message     La lista de mensajes de error.
     * @param path        La ruta del error.
     * @param jdk         Información adicional sobre la versión de JDK.
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

    /**
     * Obtiene la marca de tiempo del error.
     *
     * @return La marca de tiempo del error.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la marca de tiempo del error.
     *
     * @param timestamp La marca de tiempo del error.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Establece la marca de tiempo del error a partir de un objeto Date.
     *
     * @param timestamp La marca de tiempo del error como objeto Date.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = this.changeTimeStamp(timestamp);
    }

    /**
     * Obtiene el código de estado del error.
     *
     * @return El código de estado del error.
     */
    public int getStatus() {
        return status;
    }

    /**
     * Establece el código de estado del error.
     *
     * @param status El código de estado del error.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Obtiene la descripción del error.
     *
     * @return La descripción del error.
     */
    public String getError() {
        return error;
    }

    /**
     * Establece la descripción del error.
     *
     * @param error La descripción del error.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Obtiene la traza del error.
     *
     * @return La traza del error.
     */
    public String getTrace() {
        return trace;
    }

    /**
     * Establece la traza del error.
     *
     * @param trace La traza del error.
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * Obtiene la lista de mensajes de error.
     *
     * @return La lista de mensajes de error.
     */
    public List<String> getMessage() {
        return message;
    }

    /**
     * Establece la lista de mensajes de error.
     *
     * @param message La lista de mensajes de error.
     */
    public void setMessage(List<String> message) {
        this.message = message;
    }

    /**
     * Obtiene la ruta del error.
     *
     * @return La ruta del error.
     */
    public String getPath() {
        return path;
    }

    /**
     * Establece la ruta del error.
     *
     * @param path La ruta del error.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Obtiene la información adicional sobre la versión de JDK.
     *
     * @return La información adicional sobre la versión de JDK.
     */
    public String getJdk() {
        return jdk;
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
