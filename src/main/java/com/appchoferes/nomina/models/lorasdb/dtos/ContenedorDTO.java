package com.appchoferes.nomina.models.lorasdb.dtos;

public class ContenedorDTO {

    private String wContenedorID;
    private Integer itinerarioID;
    private Integer clienteID;
    private Integer tipoEvento;
    private String fechaEvento;

    // Getters y Setters
    public String getWContenedorID() {
        return wContenedorID;
    }

    public void setWContenedorID(String wContenedorID) {
        this.wContenedorID = wContenedorID;
    }

    public Integer getItinerarioID() {
        return itinerarioID;
    }

    public void setItinerarioID(Integer itinerarioID) {
        this.itinerarioID = itinerarioID;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Integer getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Integer tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
}