package com.ejemplos.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Entradas")
public class Entrada {
	
	@Id
    @Column(name = "entradaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrada;
	private int idUsuario;
	private int idEvento;
	
	
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
	
	public Entrada(int idEntrada, int idUsuario, int idEvento) {
		super();
		this.idEntrada = idEntrada;
		this.idUsuario = idUsuario;
		this.idEvento = idEvento;
	}
}
