package com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo;

import lombok.Data;

@Data
public class InspeccionEntradaDto {
   private Integer id;
   private Integer listadoId;
   private Integer itinerarioId;
   private String concepto;
   private Integer bien2;

}
