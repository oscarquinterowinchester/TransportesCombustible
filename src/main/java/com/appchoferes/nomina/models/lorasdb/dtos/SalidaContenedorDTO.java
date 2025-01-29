package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

public class SalidaContenedorDTO {

    private ContenedorDTO contenedor;
    private List<PuntoDTO> puntos;

    // Getters y Setters
    public ContenedorDTO getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorDTO contenedor) {
        this.contenedor = contenedor;
    }

    public List<PuntoDTO> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<PuntoDTO> puntos) {
        this.puntos = puntos;
    }
}