package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "navieras_tbl")
public class NavierasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NavieraID")
    private Integer NavieraID;

    @Column(name = "Nombre")
    private String Nombre;

    // Getters and Setter

    /**
     * @return Integer return the NavieraID
     */
    public Integer getNavieraID() {
        return NavieraID;
    }

    /**
     * @param NavieraID the NavieraID to set
     */
    public void setNavieraID(Integer NavieraID) {
        this.NavieraID = NavieraID;
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

}
