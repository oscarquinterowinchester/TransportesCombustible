package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoVisitante2DTO {
    
    private Integer id;
    private String nombre;
    private Integer disponibles;
    private Integer ocupados;
}
