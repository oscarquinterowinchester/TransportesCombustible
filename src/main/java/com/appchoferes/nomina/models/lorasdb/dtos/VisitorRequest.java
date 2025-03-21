package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

import lombok.Data;

@Data
public class VisitorRequest {

    private EmpleadoVisitaDTO empleado;
    private List<VisitanteDTO> visitantes;
    private VehiculoDTO vehiculo;
}
