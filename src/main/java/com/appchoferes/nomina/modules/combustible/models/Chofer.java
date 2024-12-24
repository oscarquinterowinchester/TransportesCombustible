package com.appchoferes.nomina.modules.combustible.models;

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
@Table(name = "choferes_tbl")
public class Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ChoferID")
    private long id;

    @Column(name = "Nombre")
    private String nombre;
}
