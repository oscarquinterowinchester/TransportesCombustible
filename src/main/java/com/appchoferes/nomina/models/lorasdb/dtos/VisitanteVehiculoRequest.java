package com.appchoferes.nomina.models.lorasdb.dtos;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;

import lombok.Data;

@Data
public class VisitanteVehiculoRequest {
    private VisitorVisitante visitante;
    private Vehiculo vehiculo;
}
