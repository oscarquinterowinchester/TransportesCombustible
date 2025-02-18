package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InventarioExternoRequest {

    @JsonProperty("Botando")
    private Boolean Botando;

    @JsonProperty("Carrier")
    private String Carrier;

    @JsonProperty("Contenedor")
    private String Contenedor;

    @JsonProperty("EquipmentProvider")
    private Integer EquipmentProvider;

    @JsonProperty("FechaEvento")
    private LocalDateTime FechaEvento;

    @JsonProperty("ItinerarioID")
    private Integer ItinerarioID;

    @JsonProperty("PatioID")
    private Integer PatioID;

    @JsonProperty("Sello")
    private String Sello;

    @JsonProperty("UsuarioEventoID")
    private Integer UsuarioEventoID;

    @JsonProperty("UsuarioID")
    private Integer UsuarioID;

    @JsonProperty("WContenedorID")
    private Integer WContenedorID;

    @JsonProperty("Nota")
    private String Nota; 

    @JsonProperty("Firmak9")
    private String Firmak9;

    @JsonProperty("FotoSello")
    private String FotoSello;

    @JsonProperty("FirmaChofer")
    private String FirmaChofer;

    @JsonProperty("FirmaGuardia")
    private String FirmaGuardia;

    @JsonProperty("puntos")
    private List<InventarioExternoInspeccion> puntos;

}
