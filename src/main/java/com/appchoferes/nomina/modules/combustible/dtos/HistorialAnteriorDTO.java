package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HistorialAnteriorDTO {
    private Long cargaId;
    private String fechayHora;
    private Double odometroCarga;
}

