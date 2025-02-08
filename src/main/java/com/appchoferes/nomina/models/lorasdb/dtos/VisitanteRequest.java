package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitanteRequest {
    private VisitanteDTO visitante;
    private VehiculoDTO vehiculo;
}
