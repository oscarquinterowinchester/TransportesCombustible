package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HistorialAnteriorDTO {
    private Long cargaId;
    private String fechayHora;
    private Double odometroCarga;
}

