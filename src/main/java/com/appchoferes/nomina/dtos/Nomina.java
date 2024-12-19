package com.appchoferes.nomina.dtos;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Nomina {
    @Id
    @Column(name = "id")
    Long itinerarioId;

    @Column(name = "route")
    String ruta;

    @Column(name = "date")
    String fechaCarga;

    @Column(name = "payment")
    Integer pago;

    @Column(name = "container")
    String contenedor;

    @Column(name = "truck")
    Integer noEcoCamion;

    @Column(name = "amount")
    Integer totalPago;

    @Column(name = "status")
    String estadoViaje;

    @Column(name = "estatusViaje")
    int status;

    @Column(name = "estadoCarga")
    String estadoCarga;
    

    @Transient
    ArrayList<Extras> extras;

}
