package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
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
    private LocalDateTime entrada;
    private String asunto;
    private String nombre;
    private Integer visitanteID;
    private String gafete;
    private String vehiculo;
    private LocalDateTime salida;
    private String empleado;
    private String duracion;
    private Boolean archivoGenerado;
}