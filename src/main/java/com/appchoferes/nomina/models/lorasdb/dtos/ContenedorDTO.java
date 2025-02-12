package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenedorDTO {
    private Integer InventarioID;
    private Integer ItinerarioID;
    private String WContenedorID;
    private String Contenedor;
    private String PlacasChasis;
    private String Sello;
    private Integer PaisID;
    private Integer ClienteID;
    private Integer EstadoCarga;
    private Integer TipoEvento;
    private String FechaEvento;
    private String Camion;
    private String Origen;
    private String Destino;
    private String Carrier;
}
