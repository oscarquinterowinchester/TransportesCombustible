package com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EquipoInfoDto {

    @JsonProperty("ItinerarioID")
    private Integer ItinerarioID;

    @JsonProperty("wContenedorId")
    private Integer wContenedorId;

    @JsonProperty("camionId")
    private Integer camionId;

    @JsonProperty("patioId")
    private Integer patioId;

    @JsonProperty("ChoferID")
    private Integer ChoferID;

    @JsonProperty("Botando")
    private Boolean Botando;

    @JsonProperty("ClienteID")
    private Integer ClienteID;

    @JsonProperty("carga")
    private String carga;

    @JsonProperty("Unidad")
    private String Unidad;

    @JsonProperty("PlacasChasis")
    private String PlacasChasis;

    @JsonProperty("Contenedor")
    private String Contenedor;

    @JsonProperty("NombreChofer")
    private String NombreChofer;

    @JsonProperty("origen")
    private String origen;

    @JsonProperty("selloDiesel")
    private Boolean selloDiesel;

    @JsonProperty("Sello")
    private String Sello;

    @JsonProperty("firmaChofer")
    private String firmaChofer;

    @JsonProperty("firmaGuardia")
    private String firmaGuardia;

    @JsonProperty("estado")
    private Integer estado;

    @JsonProperty("el")
    private String el;

    @JsonProperty("destino")
    private Integer destino;

    @JsonProperty("anterior")
    private Integer anterior;

    @JsonProperty("InventarioID")
    private Integer InventarioID;

    @JsonProperty("camion")
    private String camion;
}

