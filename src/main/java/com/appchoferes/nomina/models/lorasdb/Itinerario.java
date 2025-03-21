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
@Table(name = "itinerarios_tbl")
public class Itinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItinerarioID")
    private int itinerarioID;

    /*@Column(name = "CamionID")
    private int camionID;

    @Column(name = "RutaID")
    private int rutaID;

    @Column(name = "ChoferID")
    private int choferID;

    @Column(name = "Status")
    private int status;*/
}