package com.appchoferes.nomina.models.lorasdb;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "registros_puntos_inspeccion_tbl")
public class RegistroPuntoInspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "punto", nullable = false)
    private int punto;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    @Column(name = "id_inspeccion", nullable = false)
    private int idInspeccion;

    @Column(name = "tipo_inspeccion", nullable = false)
    private int tipoInspeccion;
    
}

