package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroInicialDTO {
    private Integer usuario;
    private String fechaRecibido;
    private Integer tipoCorrespondencia;
    private Integer inspeccion;
    private Integer areaCorrespondencia;
}
