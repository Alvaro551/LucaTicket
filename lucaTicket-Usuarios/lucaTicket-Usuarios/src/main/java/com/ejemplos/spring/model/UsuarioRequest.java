package com.ejemplos.spring.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class UsuarioRequest {

	private int usuarioID;
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasena;
	private String fechaalta;
	
	 /**
     * Constructor de Usuario que toma todos los atributos como parámetros.
     *
     * @param usuarioID Identificador único del usuario.
     * @param nombre    Nombre del usuario.
     * @param apellido  Apellido del usuario.
     * @param mail      Dirección de correo electrónico del usuario.
     * @param contrasena Contraseña del usuario.
     * @param fechaalta Fecha en que el usuario fue dado de alta en el sistema.
     */
	public UsuarioRequest(int usuarioID, String nombre, String apellido, String mail, String contrasena, String fechaalta) {
		super();
		this.usuarioID = usuarioID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasena = contrasena;
		this.fechaalta = fechaalta;
	}


    /**
     * Constructor predeterminado de Usuario.
     */
	public UsuarioRequest() {
		super();
	}
	
	/**
     * Obtiene el identificador único del usuario.
     *
     * @return Identificador único del usuario.
     */
	public int getUsuarioID(){
		return usuarioID;
	}
	

    /**
     * Establece el identificador único del usuario.
     *
     * @param usuarioID Identificador único del usuario.
     */
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	  /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return Apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido Apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la dirección de correo electrónico del usuario.
     *
     * @return Dirección de correo electrónico del usuario.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Establece la dirección de correo electrónico del usuario.
     *
     * @param mail Dirección de correo electrónico del usuario.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena Contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la fecha en que el usuario fue dado de alta en el sistema.
     *
     * @return Fecha de alta del usuario.
     */
    public String getFechaAlta() {
        return fechaalta;
    }

    /**
     * Establece la fecha en que el usuario fue dado de alta en el sistema.
     *
     * @param fechaAlta Fecha de alta del usuario.
     */
    public void setFechaAlta(String fechaAlta) {
        this.fechaalta = fechaAlta;
    }

    /**
     * Representación en cadena del objeto Usuario.
     *
     * @return Cadena que representa el objeto Usuario.
     */
    @Override
    public String toString() {
        return "Usuario [usuarioID=" + usuarioID + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
                + ", contrasena=" + contrasena + ", fechaAlta=" + fechaalta + "]";
    }
    public Usuario transformToUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuarioID(usuarioID);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setContrasena(contrasena);

        // Formatear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        usuario.setFechaAlta(LocalDate.parse(fechaalta, formatter));

        return usuario;
    }
}