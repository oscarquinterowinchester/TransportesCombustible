package com.appchoferes.nomina.models.lorasdb.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HistorialCargasDTO {
    private Long cargaId;
    private String proveedor;
    private Double litros;
    private String historialNota;
    private String sellos;
    private String fotoSello;
    private LocalDateTime fecha;
    private BigDecimal rendimientoCarga;
    private BigDecimal rendimientoECM;
    private BigDecimal rendimientoRutas;
}
