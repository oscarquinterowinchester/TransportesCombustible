package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuntoDTO {
    private Integer id;
    private Integer InventarioSalidaID;
    private Integer listadoId;
    private String FechaSalida;
    private String FotoSalida;
    private String ComentarioSalida;
}
