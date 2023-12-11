package com.ejemplos.spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Clase que representa un objeto de solicitud para la creación o actualización de eventos.
 */
public class EventosRequest {

    /**
     * Identificador único del evento (generado automáticamente en la base de datos).
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Descripción corta del evento.
     */
    private String descripcioncorta;

    /**
     * Descripción extendida del evento.
     */
    private String descripcionextendida;

    /**
     * Ruta de la foto asociada al evento.
     */
    private String foto;

    /**
     * Fecha del evento en formato de cadena ("dd-MM-yyyy").
     */
    private String fechaevento;

    /**
     * Hora del evento en formato de cadena ("HH:mm").
     */
    private String horaevento;

    /**
     * Precio mínimo para el evento.
     */
    private double preciomin;

    /**
     * Precio máximo para el evento.
     */
    private double preciomax;

    /**
     * Normas asociadas al evento.
     */
    private String normas;

    /**
     * Género del evento.
     */
    private String genero;

    /**
     * Recinto donde se realiza el evento.
     */
    private Recinto recinto;

    /**
     * Constructor que permite crear un objeto de solicitud para eventos con todos los atributos.
     *
     * @param id                 Identificador único del evento.
     * @param nombre             Nombre del evento.
     * @param descripcioncorta   Descripción corta del evento.
     * @param descripcionextendida Descripción extendida del evento.
     * @param foto               Ruta de la foto asociada al evento.
     * @param fechaevento        Fecha del evento en formato de cadena ("dd-MM-yyyy").
     * @param horaevento         Hora del evento en formato de cadena ("HH:mm").
     * @param preciomin          Precio mínimo para el evento.
     * @param preciomax          Precio máximo para el evento.
     * @param normas             Normas asociadas al evento.
     * @param genero             Género del evento.
     * @param recinto            Recinto donde se realiza el evento.
     */
    public EventosRequest(int id, String nombre, String descripcioncorta, String descripcionextendida, String foto,
            String fechaevento, String horaevento, double preciomin, double preciomax, String normas,
            String genero, Recinto recinto) {
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

    /**
     * Constructor por defecto.
     */
    public EventosRequest() {
    }

    /**
     * Obtiene el identificador único del evento.
     *
     * @return Identificador único del evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del evento.
     *
     * @param id Identificador único del evento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del evento.
     *
     * @return Nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     *
     * @param nombre Nombre del evento.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción corta del evento.
     *
     * @return Descripción corta del evento.
     */
    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    /**
     * Establece la descripción corta del evento.
     *
     * @param descripcioncorta Descripción corta del evento.
     */
    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    /**
     * Obtiene la descripción extendida del evento.
     *
     * @return Descripción extendida del evento.
     */
    public String getDescripcionextendida() {
        return descripcionextendida;
    }

    /**
     * Establece la descripción extendida del evento.
     *
     * @param descripcionextendida Descripción extendida del evento.
     */
    public void setDescripcionextendida(String descripcionextendida) {
        this.descripcionextendida = descripcionextendida;
    }

    /**
     * Obtiene la ruta de la foto asociada al evento.
     *
     * @return Ruta de la foto.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la ruta de la foto asociada al evento.
     *
     * @param foto Ruta de la foto.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Obtiene el precio mínimo para el evento.
     *
     * @return Precio mínimo para el evento.
     */
    public double getPreciomin() {
        return preciomin;
    }

    /**
     * Establece el precio mínimo para el evento.
     *
     * @param preciomin Precio mínimo para el evento.
     */
    public void setPreciomin(double preciomin) {
        this.preciomin = preciomin;
    }

    /**
     * Obtiene el precio máximo para el evento.
     *
     * @return Precio máximo para el evento.
     */
    public double getPreciomax() {
        return preciomax;
    }

    /**
     * Establece el precio máximo para el evento.
     *
     * @param preciomax Precio máximo para el evento.
     */
    public void setPreciomax(double preciomax) {
        this.preciomax = preciomax;
    }

    /**
     * Obtiene las normas asociadas al evento.
     *
     * @return Normas asociadas al evento.
     */
    public String getNormas() {
        return normas;
    }

    /**
     * Establece las normas asociadas al evento.
     *
     * @param normas Normas asociadas al evento.
     */
    public void setNormas(String normas) {
        this.normas = normas;
    }

    /**
     * Obtiene el recinto donde se realiza el evento.
     *
     * @return Recinto donde se realiza el evento.
     */
    public Recinto getRecinto() {
        return recinto;
    }

    /**
     * Establece el recinto donde se realiza el evento.
     *
     * @param recinto Recinto donde se realiza el evento.
     */
    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    /**
     * Obtiene la fecha del evento en formato de cadena ("dd-MM-yyyy").
     *
     * @return Fecha del evento en formato de cadena.
     */
    public String getFechaevento() {
        return fechaevento;
    }

    /**
     * Establece la fecha del evento en formato de cadena ("dd-MM-yyyy").
     *
     * @param fechaevento Fecha del evento en formato de cadena.
     */
    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
    }

    /**
     * Obtiene la hora del evento en formato de cadena ("HH:mm").
     *
     * @return Hora del evento en formato de cadena.
     */
    public String getHoraevento() {
        return horaevento;
    }

    /**
     * Establece la hora del evento en formato de cadena ("HH:mm").
     *
     * @param horaevento Hora del evento en formato de cadena.
     */
    public void setHoraevento(String horaevento) {
        this.horaevento = horaevento;
    }

    /**
     * Obtiene el género del evento.
     *
     * @return Género del evento.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del evento.
     *
     * @param genero Género del evento.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Transforma el objeto de solicitud de evento a un objeto de evento completo.
     *
     * @return Objeto de evento completo.
     */
    public Eventos transformToEventos() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate fechaEvento = LocalDate.parse(this.fechaevento, dateFormatter);
        LocalDateTime horaEvento = LocalDateTime.of(fechaEvento, LocalTime.parse(this.horaevento, timeFormatter));

        return new Eventos(id, nombre, descripcioncorta, descripcionextendida, foto, fechaEvento, horaEvento,
                preciomin, preciomax, normas, genero, recinto);
    }
}
