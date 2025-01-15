package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "unidadnegocio_tbl")
public class UnidadNegocioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UnidadID")
    private Integer UnidadID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Byte status;

    // Getters and Setters

    /**
     * @return Integer return the UnidadID
     */
    public Integer getUnidadID() {
        return UnidadID;
    }

    /**
     * @param UnidadID the UnidadID to set
     */
    public void setUnidadID(Integer UnidadID) {
        this.UnidadID = UnidadID;
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
     * @return String return the Status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.status = Status;
    }

}
