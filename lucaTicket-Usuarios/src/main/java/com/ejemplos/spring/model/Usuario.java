package com.ejemplos.spring.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="usuarios")
public class Usuario {

	@Id
	@Column(name="usuarioID")
	private int usuarioID;
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasena;
	private LocalDate fechaalta;
	
	public Usuario(int usuarioID, String nombre, String apellido, String mail, String contrasena, LocalDate fechaalta) {
		super();
		this.usuarioID = usuarioID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasena = contrasena;
		this.fechaalta = fechaalta;
	}

	public Usuario() {
		super();
	}
	
	public int getUsuarioID(){
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

	public LocalDate getFechaAlta() {
		return fechaalta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaalta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioID=" + usuarioID + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", contrasena=" + contrasena + ", fechaAlta=" + fechaalta + "]";
	}

	
}
