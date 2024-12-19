package com.appchoferes.nomina.modules.itinerario.models;
import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DriverMoveEntity {

    @Id
    private Long id;

    private String fechaLlegada;

    private String fechaSalida;

    private String carga;

    private int Status;

    private int estado;

    private int visto;

    private int camionID;

    private String ruta;

    private String tipoc;

    private String chofer;

    private String camion;

    private int clienteid;

    private String mercancia;

    private String nota;

    private String el;

    @ElementCollection
    private List<ContenedorEntity> contenedores;

}
