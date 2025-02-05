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
@Table(name = "icont_tbl")
public class ICont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IcontID")
    private int icontID;

    @Column(name = "ItinerarioID")
    private int itinerarioID;

    @Column(name = "ncontenedor")
    private String nContenedor;

    @Column(name = "Caja")
    private String caja;

    @Column(name = "Status")
    private int status;

    // Getters y Setters
}