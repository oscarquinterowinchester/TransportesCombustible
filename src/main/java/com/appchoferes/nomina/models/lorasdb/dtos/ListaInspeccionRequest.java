package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ListaInspeccionRequest {

    @JsonProperty("ListaPuntos")
    private Map<String, PuntoInspeccionDTO> listaPuntos;

    @JsonProperty("Guardia")
    private Integer guardia;

    @JsonProperty("Nota")
    private String nota;
}
