package com.ejemplos.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


public class EventosRequest {
 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcioncorta;
    private String descripcionextendida;
    private String foto;
    private String fechaevento;
    private String horaevento;
    private double preciomin;
    private double preciomax;
    private String normas;
    private String genero;

  
    private Recinto recinto;

    public EventosRequest(int id, String nombre, String descripcioncorta, String descripcionextendida, String foto,
    		String fechaevento, String horaevento, double preciomin, double preciomax, String normas,
            String genero, Recinto recinto) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcioncorta = descripcioncorta;
        this.descripcionextendida = descripcionextendida;
        this.foto = foto;
        this.fechaevento = fechaevento;
        this.horaevento = horaevento;
        this.preciomin = preciomin;
        this.preciomax = preciomax;
        this.normas = normas;
        this.genero = genero;
        this.recinto = recinto;
    }

    public EventosRequest() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public String getDescripcionextendida() {
        return descripcionextendida;
    }

    public void setDescripcionextendida(String descripcionextendida) {
        this.descripcionextendida = descripcionextendida;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPreciomin() {
        return preciomin;
    }

    public void setPreciomin(double preciomin) {
        this.preciomin = preciomin;
    }

    public double getPreciomax() {
        return preciomax;
    }

    public void setPreciomax(double preciomax) {
        this.preciomax = preciomax;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public String getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
    }

    public String getHoraevento() {
        return horaevento;
    }

    public void setHoraevento(String horaevento) {
        this.horaevento = horaevento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Eventos transformToEventos() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate fechaEvento = LocalDate.parse(this.fechaevento, dateFormatter);
        LocalDateTime horaEvento = LocalDateTime.of(fechaEvento, LocalTime.parse(this.horaevento, timeFormatter));

        return new Eventos(id, nombre, descripcioncorta, descripcionextendida, foto, fechaEvento, horaEvento,
                preciomin, preciomax, normas, genero, recinto);
    }



}
