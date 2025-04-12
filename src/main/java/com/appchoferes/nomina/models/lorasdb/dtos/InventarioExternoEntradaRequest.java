package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InventarioExternoEntradaRequest {

    @JsonProperty("IitinerarioID")
    private Integer IitinerarioID;

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

    @JsonProperty("Firmak9")
    private String Firmak9;

    @JsonProperty("FotoSello")
    private String FotoSello;

    @JsonProperty("FirmaChofer")
    private String FirmaChofer;

    @JsonProperty("FirmaGuardia")
    private String FirmaGuardia;

    @JsonProperty("ItinerarioID")
    private Integer ItinerarioID;

    @JsonProperty("PatioID")
    private Integer PatioID;

    @JsonProperty("Sello")
    private String Sello;

    @JsonProperty("selloDiesel")
    private Boolean selloDiesel;

    @JsonProperty("UsuarioEventoID")
    private Integer UsuarioEventoID;

    @JsonProperty("UsuarioID")
    private Integer UsuarioID;

    @JsonProperty("wContenedorId")
    private Integer WContenedorID;

    @JsonProperty("Nota")
    private String Nota; 

    @JsonProperty("PlacasChasis")
    private String PlacasChasis; 

    @JsonProperty("estadomex")
    private String estadomex; 

    @JsonProperty("estadousa")
    private String estadousa; 

    @JsonProperty("NombreChofer")
    private String NombreChofer; 

    @JsonProperty("Unidad")
    private String camion; 

    @JsonProperty("origen")
    private String origen; 

    @JsonProperty("pais")
    private String pais; 

    @JsonProperty("PlacasUnidad")
    private String PlacasUnidad; 

    @JsonProperty("ChoferID")
    private Integer ChoferID; 

    @JsonProperty("ClienteID")
    private Integer ClienteID; 

    @JsonProperty("puntos")
    private List<InventarioExternoInspeccion> puntos;

}
