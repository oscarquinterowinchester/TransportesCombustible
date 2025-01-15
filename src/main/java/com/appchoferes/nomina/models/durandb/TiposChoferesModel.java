package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "tiposchoferes_tbl")
public class TiposChoferesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoID")
    private Integer TipoID;

    @Column(name = "TipoC")
    private Integer TipoC;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Boolean Status;

    // Getters and Setter

    /**
     * @return Integer return the TipoID
     */
    public Integer getTipoID() {
        return TipoID;
    }

    /**
     * @param TipoID the TipoID to set
     */
    public void setTipoID(Integer TipoID) {
        this.TipoID = TipoID;
    }

    /**
     * @return Integer return the TipoC
     */
    public Integer getTipoC() {
        return TipoC;
    }

    /**
     * @param TipoC the TipoC to set
     */
    public void setTipoC(Integer TipoC) {
        this.TipoC = TipoC;
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
     * @return Boolean return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

}
