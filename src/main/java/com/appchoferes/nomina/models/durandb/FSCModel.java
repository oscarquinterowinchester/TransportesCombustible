package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "definicionfsc_tbl")
public class FSCModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DefinicionID")
    private Integer DefinicionID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Byte Status;

    // Getters and Setters
    /**
     * @return Integer return the DefinicionID
     */
    public Integer getDefinicionID() {
        return DefinicionID;
    }

    /**
     * @param DefinicionID the DefinicionID to set
     */
    public void setDefinicionID(Integer DefinicionID) {
        this.DefinicionID = DefinicionID;
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
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.Status = Status;
    }

}
