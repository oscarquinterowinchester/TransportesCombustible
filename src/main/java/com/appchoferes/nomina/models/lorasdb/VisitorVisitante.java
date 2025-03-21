package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visitor_visitantes")
public class VisitorVisitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "empresa")
    private Integer empresa;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "foto")
    private String foto;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "firma")
    private String firma;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "identificacion2")
    private String identificacion2;

    @Column(name = "Exportado")
    private Boolean exportado;
}
