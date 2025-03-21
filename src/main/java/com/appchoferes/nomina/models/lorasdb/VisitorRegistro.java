package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "visitor_registros")
public class VisitorRegistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "entrada")
    private LocalDateTime entrada;

    @Column(name = "visitanteID")
    private Integer visitanteId; 

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "empleado")
    private String empleado;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "gafete")
    private String gafete;

    @Column(name = "vehiculo")
    private String vehiculo;

    @Column(name = "salida")
    private LocalDateTime salida;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "firma")
    private byte[] firma;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "empresaID")
    private Integer empresaId;

    @Column(name = "ArchivoGenerado")
    private Boolean archivoGenerado;

    @Column(name = "gafeteID")
    private Long gafeteId;

    @Column(name = "PatioID")
    private Integer patioId;
}