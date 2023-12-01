package com.ejemplos.spring.model;

import java.util.Date;

public class Usuario {

	private String nombre;
	private String apellido;
	private String mail;
	private String contrasena;
	private Date fechaAlta;
	
	public Usuario(String nombre, String apellido, String mail, String contrasena, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasena = contrasena;
		this.fechaAlta = fechaAlta;
	}

	public Usuario() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", contrasena=" + contrasena
				+ ", fechaAlta=" + fechaAlta + "]";
	}
	
}
