package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inspecciones_fisicas_tbl")
public class InspeccionFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "guardia")
    private Integer guardia;

    @Column(name = "nota")
    private String nota;

    @Column(name = "fecha")
    private Date fecha;
}