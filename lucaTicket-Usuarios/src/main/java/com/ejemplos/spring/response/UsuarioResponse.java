package com.ejemplos.spring.response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.ejemplos.spring.model.Usuario;

/**
 * Clase que representa la respuesta para la entidad Usuario.
 * Proporciona métodos estáticos para convertir instancias de Usuario a UsuarioResponse.
 *
 * <p>Esta clase facilita la conversión entre la entidad Usuario y la representación de respuesta UsuarioResponse.
 * Contiene un método de fábrica {@code of} para convertir un objeto Usuario a un objeto UsuarioResponse.</p>
 *
 * @see Usuario
 */
public class UsuarioResponse {

	private static final long serialVersionUID = 1L;
	private int usuarioID;
	private String nombre;
	private String apellidos;
	private String fechaAlta;
	
	/**
	 * Convierte un objeto Usuario a un objeto UsuarioResponse.
	 *
	 * @param usuario El objeto Usuario a convertir.
	 * @return Un objeto UsuarioResponse que representa la respuesta del usuario.
	 */
	public static UsuarioResponse of(Usuario usuario) {
	    UsuarioResponse response = new UsuarioResponse();

	    response.setUsuarioID(usuario.getUsuarioID());
	    response.setNombre(usuario.getNombre());
	    response.setApellidos(usuario.getApellido());

	    // Verificar si la fecha de alta es nula antes de intentar formatearla
	    if (usuario.getFechaAlta() != null) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        response.setFechaAlta(usuario.getFechaAlta().format(formatter));
	    } else {
	        response.setFechaAlta(null); // O puedes establecer un valor por defecto si lo prefieres
	    }

	    return response;
	}
	
	/**
	 * Convierte una lista de objetos Usuario a una lista de objetos UsuarioResponse.
	 *
	 * @param usuarios La lista de usuarios a convertir.
	 * @return Una lista de UsuarioResponse que representa la respuesta de los usuarios.
	 */
	public static List<UsuarioResponse> of(List<Usuario> usuarios){
		return usuarios.stream().map(c -> of(c)).collect(Collectors.toList());
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String string) {
		this.fechaAlta = string;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
