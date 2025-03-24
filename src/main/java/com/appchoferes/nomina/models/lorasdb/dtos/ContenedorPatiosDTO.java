package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContenedorPatiosDTO {
    private Integer inventarioID;
    private Integer itinerarioID;
    private Integer wContenedorID;
    private String contenedor;
    private String placasChasis;
    private String sello;
    private Integer paisID;
    private Integer clienteID;
    private Integer estadoCarga;
    private Integer tipoEvento;
    private LocalDateTime fechaEvento;
    private String camion;
    private String origen;
    private String destino;
    private String carrier;
}