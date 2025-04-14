package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InventarioExternoSalidaRequest {


    @JsonProperty("InventarioID")
    private Integer InventarioID;

    @JsonProperty("ItinerarioID")
    private Integer ItinerarioID;
    private Integer AnteriorID;
    private String Contenedor;

    @JsonProperty("PlacasChasis")
    private String PlacasChasis;
    
    @JsonProperty("Sello")
    private String Sello;
    private Integer ChoferID;
    private Integer ClienteID;
    private Integer RutaID;

    @JsonProperty("wContenedorId")
    private Integer wContenedorId;
    
    @JsonProperty("NombreChofer")
    private String NombreChofer;
    private LocalDateTime FechaEvento;
    
    @JsonProperty("Unidad")
    private String camion;

    @JsonProperty("Firmak9")
    private String Firmak9;
    
    private String origen;
    private String Carrier;
    private String Tamano;

    private Integer destino;

    @JsonProperty("camionID")
    private Integer camionId;

    @JsonProperty("patioId")
    private Integer patioId;

    @JsonProperty("selloDiesel")
    private Boolean selloDiesel;
    
    @JsonProperty("el")
    private String carga;

    private List<InventarioExternoInspeccion> puntos;

    public LocalDateTime getFechaEvento() {
        return (FechaEvento != null) ? FechaEvento : LocalDateTime.now();
    }
}
