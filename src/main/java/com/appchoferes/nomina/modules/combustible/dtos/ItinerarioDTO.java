package com.appchoferes.nomina.modules.combustible.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItinerarioDTO {
    private Long itinerarioId;
    private String estadoCarga;
    private Double km;
    private String ruta;
    private Double rendimientoCamion;
    private String chofer;
    private String camion;
    private String caja;
    private String fechaLlegada;
    private Double odometroR;
    private Double odometrosS;
    private Double recorrido;

}
