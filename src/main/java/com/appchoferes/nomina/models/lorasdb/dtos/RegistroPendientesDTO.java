package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;

@Data
public class RegistroPendientesDTO {
    
    private Long id;
    private String foto;
    private String firma;
    private String identificacion;
    private String identificacion2;
    private String compania;
    private Integer completado;
}
