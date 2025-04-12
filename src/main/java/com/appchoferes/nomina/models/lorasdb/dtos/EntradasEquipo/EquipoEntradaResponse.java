package com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo;

import java.util.List;

import lombok.Data;

@Data
public class EquipoEntradaResponse {
   private String mensaje;
   private Integer estatus;
   private EquipoInfoDto info;
   private List<InspeccionEntradaDto> inspeccion;
}
