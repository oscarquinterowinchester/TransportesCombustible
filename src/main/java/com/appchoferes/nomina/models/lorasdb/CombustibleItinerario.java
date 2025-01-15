package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itinerarios_tbl")
public class CombustibleItinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItinerarioID")
    private Long itinerarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CamionID")
    private Camion camion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChoferID")
    private Chofer chofer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RutaID")
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CajaID")
    private Caja caja;

    @Column(name = "FechaLlegada")
    private String fechaLlegada;

    @Column(name = "OdometroS")
    private Double odometroS;

    @Column(name = "OdometroR")
    private Double odometroR;

    @Column(name = "Carga")
    private String fechaCarga;

    @Column(name = "Status")
    private Integer status;

}
