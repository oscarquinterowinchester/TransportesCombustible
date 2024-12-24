package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Data;

@Data
public class CajaConCargaDTO {
    private Long cajaId;
    private String noEconomico;
    private double tanqueCapacidad;
    private double tanqueActual;
}

