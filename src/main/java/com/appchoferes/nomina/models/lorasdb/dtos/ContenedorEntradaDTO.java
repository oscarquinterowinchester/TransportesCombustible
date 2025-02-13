package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ContenedorEntradaDTO {
    private String Contenedor;
    private Integer ItinerarioID;
    private String PlacasUnidad;
    private String Sello;
    private Integer PaisID;
    private Integer EstadoID;
    private Integer ChoferID;
    private Integer RutaID;
    private Integer UsuarioID;
    private Integer ClienteID;
    private Integer TipoEvento;
    private String FechaEvento;
    private Integer WConetenedorID;
    private Integer PatioID;
    private Integer Tamano;
    private String Firmak9;
    private String camion;
    private String Carrier;
    private String FotoSello;
    private String FirmaGuardia;
    private String FirmaChofer;
    private Integer UsuarioEventoID;
    private String EstadoCarga;
    private Boolean Botando;
    private List<PuntosInspeccionEntradaDTO> puntos;
}