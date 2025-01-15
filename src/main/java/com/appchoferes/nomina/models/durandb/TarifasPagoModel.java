package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "tarifaspago_tbl")
public class TarifasPagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TarifaID")
    private Integer TarifaID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Byte Status;

    // Getters and Setters

    /**
     * @return Integer return the TarifaID
     */
    public Integer getTarifaID() {
        return TarifaID;
    }

    /**
     * @param TarifaID the TarifaID to set
     */
    public void setTarifaID(Integer TarifaID) {
        this.TarifaID = TarifaID;
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
