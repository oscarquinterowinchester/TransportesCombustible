package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroVisitaDTO {
    private Long id;
    private String salida;
    private String duracion;
    private Long visitor;
    private Long gafete;
}
