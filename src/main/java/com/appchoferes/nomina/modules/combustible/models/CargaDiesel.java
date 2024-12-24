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

    @Column(name = "Litros")
    private double litros;

    @Column(name = "Tipo")
    private Integer tipo;

    @Column(name = "RendimientoCarga")
    private double rendimientoCarga;

    @Column(name = "RendimientoECM")
    private double rendimientoECM;

    @Column(name = "RendimientoRutas")
    private double rendimientoRuta;

    @Column(name = "Sellos")
    private String sellos;

    @Column(name = "FotoSello")
    private String fotoSello;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "FechayHora")
    private String fechayHora;
    
    @Column(name = "Folio")
    private String folio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProveedorID", referencedColumnName = "ProveedorID")
    private Proveedor proveedor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CamionID")
    private Camion camion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CajaID", insertable = false, updatable = false)
    private Caja caja;
}
