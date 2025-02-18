package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;

@Data
public class ContenedorTipo2DTO {
    // Campos de itinerarios_tbl
    private Integer camionID;
    private Integer rutaID;
    private Integer choferID;
    private Integer status;

    // Campos de icont_tbl
    private String nContenedor;
    private String caja;

    // Campos de inventarioexterno_tbl
    private Integer inventarioID;
    private String contenedor;
    private Integer anteriorID;

    // Campos calculados en la consulta SQL
    private String sello;
    private String estadomex;
    private String estadousa;
    private String ruta;
    private String camion;
    private String placasChasis;
    private String placasUnidad;
    private String nombreChofer;
    private Integer clienteID;
    private String cliente;
}