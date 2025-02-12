package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenedorTipo1DTO {
    private Integer ItinerarioID;
    private String Contenedor;
    private Integer ClienteFK;
    private String Origen;
    private String Sello;
    private String EstadoMex;
    private Integer RutaID;
    private String Carrier;
    private String Tamano;
    private String Pais;
    private String Carga;
    private String EstadoUSA;
    private String Ruta;
    private String Camion;
    private String PlacasChasis;
    private String PlacasUnidad;
    private String NombreChofer;
    private Integer ChoferID;
    private Integer ClienteID;
    private String Cliente;
    private Integer InventarioID;
}
