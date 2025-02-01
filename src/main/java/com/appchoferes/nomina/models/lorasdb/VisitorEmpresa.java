package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visitor_empresas")
public class VisitorEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
}