package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;

@Data
public class PuntosInspeccionEntradaDTO {
    private Integer listadoID;
    private String nombre;
    private Integer itinerarioID;
    private String fotoEntrada;
    private String comentarioEntrada;
}
