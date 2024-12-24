package com.appchoferes.nomina.modules.itinerario.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
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
public class Itinerario {

    @Id
    private Long itinerarioId;

    @ElementCollection
    private List<DriverMoveEntity> data;

    private int _estatus;

    private String _message;

    private int count;

}
