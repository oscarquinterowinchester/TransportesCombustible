package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ListaInspeccionRequest {
    private List<PuntoInspeccionDTO> listaPuntos;
    private Integer guardia;
    private String nota;
}
