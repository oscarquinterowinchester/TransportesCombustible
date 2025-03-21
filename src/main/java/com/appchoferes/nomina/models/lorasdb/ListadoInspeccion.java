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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "listadoinspecciones_tbl")
public class ListadoInspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ListadoID")
    private Integer ListadoID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Entrada")
    private Integer Entrada;

    @Column(name = "ItinerarioID")
    private Integer ItinerarioID;

    @Column(name = "ComentarioEntrada")
    private String ComentarioEntrada;

    @Column(name = "FotoEntrada")
    private String FotoEntrada;

}
