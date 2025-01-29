package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "inventarioexternoinspecciones_tbl")
public class Punto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "InventarioSalidaID")
    private Integer inventarioSalidaID;

    @Column(name = "FotoSalida")
    private String fotoSalida;

    @Column(name = "ComentarioSalida")
    private String comentarioSalida;

    @Column(name = "FechaSalida")
    private Date fechaSalida;

    // Getters y Setters
}