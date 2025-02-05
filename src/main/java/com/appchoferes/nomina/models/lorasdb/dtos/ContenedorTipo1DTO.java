package com.appchoferes.nomina.models.lorasdb.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class ContenedorTipo1DTO {

    // datos de inventario externo
    private Integer InventarioID;
    private String contenedor;
    private Integer itinerarioId;
    private Date FechaEvento;

    // datos de itinerarios
    private int itinerarioID;

}
