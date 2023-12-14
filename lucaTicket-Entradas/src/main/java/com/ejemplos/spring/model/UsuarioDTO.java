package com.ejemplos.spring.model;

public class UsuarioDTO {

	private int usuarioID;
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasena;
	private String fechaalta;

	public UsuarioDTO(int usuarioID, String nombre, String apellido, String mail, String contrasena, String fechaalta) {
		super();
		this.usuarioID = usuarioID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasena = contrasena;
		this.fechaalta = fechaalta;
	}

	public UsuarioDTO() {
		super();
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
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

	public String getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}

}
