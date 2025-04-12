package com.appchoferes.nomina.models.lorasdb.dtos.SalidasEquipo;

import java.util.List;

import lombok.Data;

@Data
public class EquipoSalidaResponse {
   private String mensaje;
   private Integer estatus;
   private EquipoSalidaInfoDto info;
   private List<InspeccionSalidaDto> inspeccion;

}
