package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CamionesConCargaDTO {
    private Long id;
    private String noEconomico;
    private double rendimientoCamion;
    private double tanquePorcentajeLleno;
    private double tanqueCapacidad;
    private double tanqueActual;

}
