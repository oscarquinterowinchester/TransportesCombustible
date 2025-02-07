package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusquedaVisitanteDTO {
    private Long id;
    private String nombre;
    private Long empresaID;
    private Long tipoVisitante;
    private Integer visto;
    private String empresa;
    private String tipo;
    private LocalDateTime last;
    private Long exist;
    private String foto;
    private String identificacion;
}