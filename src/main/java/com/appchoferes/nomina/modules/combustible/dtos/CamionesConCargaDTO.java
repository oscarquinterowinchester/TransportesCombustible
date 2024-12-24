package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Data;

@Data
public class CamionesConCargaDTO {
    private Long id;
    private String noEconomico;
    private double rendimientoCamion;
    private double tanquePorcentajeLleno;
    private double tanqueCapacidad;
    private double tanqueActual;

}
