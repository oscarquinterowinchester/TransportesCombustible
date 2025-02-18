package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventarioexternoinspecciones_tbl")
public class InventarioExternoInspeccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ItinerarioID;
    private Integer InventarioID;
    private Integer InventarioSalidaID;
    private Integer ListadoID;
    private Boolean Entrada;
    private Boolean Salida;
    //private LocalDateTime FechaEntrada;
    
    private LocalDateTime FechaSalida;
    private String comentarioentrada;
    private String comentariosalida;

    @JsonProperty("FotoEntrada")
    private String fotoentrada;
    private String fotosalida;
}