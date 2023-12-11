package com.ejemplos.spring.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaPago {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date timestamp;
	private String status;
	private String error;
	private List<String> message;
	private InformacionPago info;
	private String infoadicional;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public InformacionPago getInfo() {
		return info;
	}

	public void setInfo(InformacionPago info) {
		this.info = info;
	}

	public String getInfoadicional() {
		return infoadicional;
	}

	public void setInfoadicional(String infoadicional) {
		this.infoadicional = infoadicional;
	}

}
