package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_tbl")
public class UsuarioModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "IDUsuarioIntegranet")
    private Integer IDUsuarioIntegranet;

    @Column(name = "PatioID")
    private Integer PatioID;

    // getters and setters
    /**
     * @return Integer return the PatioID
     */
    public Integer getPatioID() {
        return PatioID;
    }

    /**
     * @param PatioID the PatioID to set
     */
    public void setPatioID(Integer PatioID) {
        this.PatioID = PatioID;
    }

    /**
     * @return Integer return the UsuarioID
     */
    public Integer getUsuarioID() {
        return UsuarioID;
    }

    /**
     * @param UsuarioID the UsuarioID to set
     */
    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    /**
     * @return String return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return Integer return the IDUsuarioIntegranet
     */
    public Integer getIDUsuarioIntegranet() {
        return IDUsuarioIntegranet;
    }

    /**
     * @param IDUsuarioIntegranet the IDUsuarioIntegranet to set
     */
    public void setIDUsuarioIntegranet(Integer IDUsuarioIntegranet) {
        this.IDUsuarioIntegranet = IDUsuarioIntegranet;
    }
}
