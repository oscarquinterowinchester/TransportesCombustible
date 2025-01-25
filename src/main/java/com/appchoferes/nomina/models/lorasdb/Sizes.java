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
@Table(name = "tamanoremo_tbl")
public class Sizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TamanoID")
    private Integer id;

    @Column(name = "Tamano")
    private String nombre;

}
