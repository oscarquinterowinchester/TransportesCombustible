package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "puestos_tbl")
public class PuestosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PuestoID")
    private Integer PuestoID;

    @Column(name = "Nombre")
    private String Nombre;

    // Getters and Setter

    /**
     * @return Integer return the PuestoID
     */
    public Integer getPuestoID() {
        return PuestoID;
    }

    /**
     * @param PuestoID the PuestoID to set
     */
    public void setPuestoID(Integer PuestoID) {
        this.PuestoID = PuestoID;
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
