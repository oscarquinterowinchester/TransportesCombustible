package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;
import java.time.LocalDateTime;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Data
public class RegistroHistorialDTO {

    private Integer id;
    private LocalDateTime entrada;
    private Integer visitanteId;
    private String nombre;
    private String empresa;
    private String asunto;
    private String empleado;
    private String identificacion;
    private String gafete;
    private String vehiculo;
    private LocalDateTime salida;
    private String duracion;
    private byte[] firma;
    private LocalDateTime fecha;
    private Long empresaId;
    private Boolean archivoGenerado;
    private Long gafeteId;
    private Integer patioId;
    private String foto;
    private String firmaVisitante;
    private String identificacionVisitante;
    private String identificacion2Visitante;
    private String compania;
    private Boolean completado;
}