package com.appchoferes.nomina.auth.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios_tbl")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "IDUsuarioIntegranet")
    private Integer IDUsuarioIntegranet;
}
