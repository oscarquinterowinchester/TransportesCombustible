package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPendientesDTO {
    private Long id; // int(11) en la base de datos, pero usamos Long para permitir null
    private LocalDateTime entrada; // datetime, puede ser null
    private Long visitanteID; // int(11), puede ser null
    private String nombre; // varchar(100), puede ser null
    private String empresa; // varchar(100), puede ser null
    private String asunto; // varchar(140), puede ser null
    private String empleado; // varchar(100), puede ser null
    private String identificacion; // varchar(300), puede ser null
    private String gafete; // varchar(100), puede ser null
    private String vehiculo; // varchar(100), puede ser null
    private LocalDateTime salida; // datetime, puede ser null
    private String duracion; // varchar(100), puede ser null
    private String firma; // blob, puede ser null
    private LocalDateTime fecha; // datetime, puede ser null
    private Long empresaID; // bigint(20), puede ser null
    private Boolean archivoGenerado; // tinyint(1), puede ser null
    private Long gafeteID; // bigint(20), puede ser null
    private Long patioID; // No está en la tabla, pero aparece en la consulta, puede ser null
    private String foto; // text, puede ser null
    private String firmaVisitante; // text, puede ser null
    private String identificacion2; // text, puede ser null
    private String compania; // varchar(100), puede ser null
    private Integer completado; // No está en la tabla, pero aparece en la consulta, puede ser null
}
