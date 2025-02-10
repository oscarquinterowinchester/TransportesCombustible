package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class getVehiculoDTO {
    private Integer id;
    private Integer exist;
    private String modelo;
    private String placas;
    private String anio;
    private Integer visitante;
    private LocalDateTime last;
    private Integer seleccionado = 0;
}
