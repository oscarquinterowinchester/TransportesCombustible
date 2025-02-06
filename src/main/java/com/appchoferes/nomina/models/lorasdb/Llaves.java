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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "llaves_tbl")
public class Llaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;  

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "ChoferID")
    private Integer choferID;

    @Column(name = "CamionID")
    private Integer camionID;

    @Column(name = "fecha")
    private String fecha;
    
}
