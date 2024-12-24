package com.appchoferes.nomina.modules.combustible.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "cargasdiesel_tbl")
public class CargaDiesel{

    @Id
    @Column(name = "CargaID")
    private long cargaId;

    @Column(name = "UnidadID")
    private long unidadId;

    @Column(name = "RendimientoCarga")
    private double rendimientoCarga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CamionID")
    private Camion camion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CajaID", insertable = false, updatable = false)
    private Caja caja;
}
