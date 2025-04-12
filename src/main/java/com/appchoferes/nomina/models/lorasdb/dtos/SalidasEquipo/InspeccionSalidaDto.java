package com.appchoferes.nomina.models.lorasdb.dtos.SalidasEquipo;

import lombok.Data;

@Data
public class InspeccionSalidaDto {
   private Integer id;
   private Integer listadoId;
   private Integer itinerarioId;
   private String concepto;
   private Integer bien2;
}
