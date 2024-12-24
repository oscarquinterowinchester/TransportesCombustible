package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Data;

@Data
public class CargasDieselDTO {
    private Long cargaId;
    private Long unidadId;
    private double litros;
    private Integer tipo;
    private double rendimientoCarga;
    private String sellos;
    private String fotoSello;
    private String nota;
    private String fechayHora;
    private String folio;
    private String nombreProveedor;
    private double rendimientoECM;
    private double rendimientoRutas;

}
