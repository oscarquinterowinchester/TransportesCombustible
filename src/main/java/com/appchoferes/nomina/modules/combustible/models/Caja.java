package com.appchoferes.nomina.modules.combustible.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cajas_tbl")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "CajaID")
    private Long id;

    @Column(name = "NoEconomico")
    private String noEconomico;
    
    @Column(name = "TanqueActual")
    private double tanqueActual;

    @Column(name = "Tanques")
    private double tanqueCapacidad;

    @OneToMany(mappedBy = "caja", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CargaDiesel> cargas;
}
