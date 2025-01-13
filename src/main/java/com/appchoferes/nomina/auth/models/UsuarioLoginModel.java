package com.appchoferes.nomina.auth.models;

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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios_tbl")
public class UsuarioLoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "nombre_db")
    private String nombreDb;

    @Column(name = "usuario_db")
    private String usuarioDb;

    @Column(name = "password_db")
    private String passwordDb;

    @Column(name = "loginUsuario")
    private String loginUsuario;

    @Column(name = "passwordUsuario")
    private String passwordUsuario;

    @Column(name = "empresaID")
    private Integer empresaID;

}
