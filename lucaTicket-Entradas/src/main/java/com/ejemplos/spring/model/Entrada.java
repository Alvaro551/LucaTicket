package com.ejemplos.spring.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entradas")
@Embeddable
public class Entrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entradaID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntrada;

	@Column(name = "usuarioID")
	private int idUsuario;

	@Column(name = "eventoID")
	private int idEvento;

	public Entrada() {
		super();
	}

	public Entrada(int idEntrada, int idUsuario, int idEvento) {
		super();
		this.idEntrada = idEntrada;
		this.idUsuario = idUsuario;
		this.idEvento = idEvento;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEntrada, idEvento, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return idEntrada == other.idEntrada && idEvento == other.idEvento && idUsuario == other.idUsuario;
	}

}
