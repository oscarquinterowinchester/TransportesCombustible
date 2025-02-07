package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroHistorialDTO {
    private Long id;
    private LocalDateTime fecha;
    private String foto;
    private String firma;
    private String identificacion;
    private String identificacion2;
    private String compania;
    private Integer completado;
}