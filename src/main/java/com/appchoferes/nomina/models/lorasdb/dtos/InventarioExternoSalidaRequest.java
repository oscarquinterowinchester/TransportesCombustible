package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InventarioExternoSalidaRequest {


    private Integer InventarioID;

    @JsonProperty("itinerarioID")
    private Integer ItinerarioID;
    private Integer AnteriorID;
    private String Contenedor;
    private String PlacasChasis;
    private String Sello;
    private Integer ChoferID;
    private Integer ClienteID;
    private Integer RutaID;
    private String NombreChofer;
    private LocalDateTime FechaEvento;
    private String camion;

    @JsonProperty("Firmak9")
    private String Firmak9;
    private String origen;
    private String Carrier;
    private String Tamano;
    private String carga;


    private List<InventarioExternoInspeccion> puntos;

    public LocalDateTime getFechaEvento() {
        return (FechaEvento != null) ? FechaEvento : LocalDateTime.now();
    }
}
