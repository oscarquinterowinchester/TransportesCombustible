package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ColaboradorDTO {
    private Long id;
    private String nombre;
    private String noEmpleado;
    private LocalDateTime ahorita;
    private String telefono;
    private Long entrada;
    private String area;
    private String puesto;

}
