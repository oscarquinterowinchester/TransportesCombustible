package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registros_puntos_inspeccion_tbl")
public class RegistroPuntoInspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "punto")
    private Integer punto;

    @Column(name = "id_inspeccion")
    private Integer idInspeccion;

    @Column(name = "tipo_inspeccion")
    private Integer tipoInspeccion;
}
