package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "paises_tbl")
public class PaisesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaisID")
    private Integer PaisID;

    @Column(name = "Nombre")
    private String Nombre;

    // Getters and Setters

    /**
     * @return Integer return the PaisID
     */
    public Integer getPaisID() {
        return PaisID;
    }

    /**
     * @param PaisID the PaisID to set
     */
    public void setPaisID(Integer PaisID) {
        this.PaisID = PaisID;
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
