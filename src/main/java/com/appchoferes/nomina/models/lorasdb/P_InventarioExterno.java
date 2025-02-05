package com.appchoferes.nomina.models.lorasdb;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "inventarioexterno_tbl")
public class P_InventarioExterno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventarioID")
    private Integer InventarioID;

    @Column(name = "Contenedor")
    private String contenedor;

    @Column(name = "ItinerarioID")
    private Integer itinerarioId;

    @Column(name = "FechaEvento")
    private Date FechaEvento;

    //@Column(name = "AnteriorID")
    //private int anteriorID;
}
