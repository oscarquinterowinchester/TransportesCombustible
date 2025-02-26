package com.appchoferes.nomina.models.lorasdb.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LlaveRequest {

    @JsonProperty("PatioID")
    private Integer PatioID;

    @JsonProperty("UsuarioID")
    private Integer UsuarioID;

    @JsonProperty("ChoferID")
    private Integer ChoferID;

    @JsonProperty("CamionID")
    private Integer CamionID;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("hora")
    private String hora;

    @JsonProperty("tipo")
    private Integer tipo;

    @JsonProperty("comentario")
    private String comentario;

    @JsonProperty("firma")
    private String firma;

}