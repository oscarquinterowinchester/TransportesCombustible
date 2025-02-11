package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuntosCTPADSalidaDTO {
    private Integer inventarioId;
    private Integer listadoId;
    private Integer salida;
    private String nombre;
}
