package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LlaveDTO {
    private String tipo;
    private String chofer;
    private String camion;
}