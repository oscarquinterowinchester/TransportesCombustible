package com.appchoferes.nomina.models.lorasdb.dtos;

public class PuntoDTO {

    private Integer id;
    private String fotoSalida;
    private String comentarioSalida;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFotoSalida() {
        return fotoSalida;
    }

    public void setFotoSalida(String fotoSalida) {
        this.fotoSalida = fotoSalida;
    }

    public String getComentarioSalida() {
        return comentarioSalida;
    }

    public void setComentarioSalida(String comentarioSalida) {
        this.comentarioSalida = comentarioSalida;
    }
}