package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registroscorrespondencias_tbl")
public class RegistroCorrespondencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "usuario")
    private Integer usuario;

    @Column(name = "fechaRecibido")
    private String fechaRecibido;

    @Column(name = "tipoCorrespondencia")
    private Integer tipoCorrespondencia;

    @Column(name = "inspeccion")
    private Integer inspeccion;

    @Column(name = "fechaEntrega")
    private String fechaEntrega;

    @Column(name = "firma")
    private String firma;

    @Column(name = "areaCorrespondencia")
    private Integer areaCorrespondencia;

}
