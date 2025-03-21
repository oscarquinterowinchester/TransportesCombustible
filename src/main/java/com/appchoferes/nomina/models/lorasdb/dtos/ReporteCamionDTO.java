package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ReporteCamionDTO {
    private String fechaAnterior;
    private Long odometro;
    private List<ItinerarioDTO> itinerarios;
    private List<KmCamionDTO> km;

}
