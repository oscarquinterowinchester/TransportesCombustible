package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Data;

@Data
public class CajasConCargaDTO {
    private Long id;
    private String noEconomico;
    private double tanqueCapacidad;
    private double tanqueActual;
}

