package com.appchoferes.nomina.models.lorasdb.dtos;

public interface PuntosSemanalProjection {
    Integer getDiaSemana();
    Integer getHora();
    String getIds();
    String getPuntos();
    String getEstados();
}