package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuntosSemanaResponse {
    private int dia_semana;
    private int hora;
    private String ids;
    private String puntos;
    private String estados;

}
