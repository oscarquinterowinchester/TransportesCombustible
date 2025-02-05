package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.Data;

@Data
public class ContenedorTipo2DTO {
    // Campos de itinerarios_tbl
    private int itinerarioID;
    private int camionID;
    private int rutaID;
    private int choferID;
    private int status;

    // Campos de icont_tbl
    private String nContenedor;
    private String caja;

    // Campos de inventarioexterno_tbl
    private int inventarioID;
    private String contenedor;
    private int anteriorID;

    // Campos calculados en la consulta SQL
    private String sello;
    private String estadomex;
    private String estadousa;
    private String ruta;
    private String camion;
    private String placasChasis;
    private String placasUnidad;
    private String nombreChofer;
    private int clienteID;
    private String cliente;
}
