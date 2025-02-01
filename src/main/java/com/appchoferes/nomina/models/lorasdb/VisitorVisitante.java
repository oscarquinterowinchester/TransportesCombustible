package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visitor_visitantes")
public class VisitorVisitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foto")
    private String foto;

    @Column(name = "firma")
    private byte[] firma;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "identificacion2")
    private String identificacion2;

    @Column(name = "empresa")
    private Long empresaId; 
}