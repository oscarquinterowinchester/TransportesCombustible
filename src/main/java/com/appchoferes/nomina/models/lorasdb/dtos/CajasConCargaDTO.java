package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;

@Data
public class CajasConCargaDTO {
    private Long id;
    private String noEconomico;
    private double tanqueCapacidad;
    private double tanqueActual;
}

