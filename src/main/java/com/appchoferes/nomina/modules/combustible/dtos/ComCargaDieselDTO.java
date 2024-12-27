package com.appchoferes.nomina.modules.combustible.dtos;

import lombok.Data;

@Data
public class ComCargaDieselDTO {

    private Long cargaId;
    private Integer tipo;
    private Long unidadId;
    private Long choferId;
    private Double litrosECM;
    private Double litros;
    private String fecha;
    private String Hora;
    private String fechayHora;
    private String folio;
    private String nota;
    private String fechaRegistro;
    private Integer status;
    private Integer ajusteOdometro;
    private Long proveedorId;
    private Long facturaId;
    private Double cantidadActual;
    private Integer metodoPagoId;
    private String serieBomba;
    private Double rendimientoCarga;
    private Double rendimientoECM;
    private Double rendimientoRuta;
    private Double odometroCarga;
    private Double odometroECM;
    private Double recorridoCarga;
    private Double recorridoECM;
    private String sellos;
    private Double precioTotal;
    private Integer monedaCarga;
    private String fotoSello;
    private String fotoOdometro;
    private String firma;
    private String fotoTanque1;
    private String fotoTanque2;
    private Long usuarioId;
    private Integer fromWS;
    private Double recorridoRutas;
    private Double odometroAjustado;
    private Integer usuarioAjuste;
    private String fechaAjuste;
    private String motivoAjuste;
    private Long estadoId;
    private Integer esChofer;
}
