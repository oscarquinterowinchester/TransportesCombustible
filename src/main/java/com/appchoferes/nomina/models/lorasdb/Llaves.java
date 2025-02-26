package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDateTime;

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
@Table(name = "llaves_tbl")
public class Llaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Integer PatioID;

    private Integer UsuarioID;

    @Column(name = "ChoferID")
    private Integer ChoferID;

    @Column(name = "CamionID")
    private Integer CamionID;

    private LocalDateTime fecha;

    @Column(name = "tipo")
    private Integer tipo;

    private String comentario;
    private String firma;

}
