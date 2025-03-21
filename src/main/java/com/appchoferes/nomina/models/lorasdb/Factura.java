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
@Table(name = "facturas_tbl")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FacturaID")
    private Long facturaId;

    @Column(name = "Folio")
    private Long folio;

    @Column(name = "Monto")
    private Double monto;

    @Column(name = "TotalFactua")
    private Double totalFactura;

}
