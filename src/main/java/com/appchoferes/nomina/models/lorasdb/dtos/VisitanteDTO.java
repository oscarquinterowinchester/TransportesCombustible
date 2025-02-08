package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitanteDTO {
    private Integer id;
    private String nombre;
    private String empresa;
    private Integer empresaID;
    private String tipo;
    private String gafete;
    private String gafeteNombre = "";
    private String placas;
    private String modelo;
    private Integer anio;
}
