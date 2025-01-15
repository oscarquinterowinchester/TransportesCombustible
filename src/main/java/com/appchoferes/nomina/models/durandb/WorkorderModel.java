package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "workorder_tbl")
public class WorkorderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkID")
    private Integer WorkID;

    @Column(name = "ClienteID")
    private Integer clienteID;

    @Column(name = "Voyage")
    private String Voyage;

    @Column(name = "TipoCont")
    private Integer TipoCont;

    @Column(name = "Status")
    private Boolean Status;

    // Getters and setters

    /**
     * @return Integer return the WorkID
     */
    public Integer getWorkID() {
        return WorkID;
    }

    /**
     * @param WorkID the WorkID to set
     */
    public void setWorkID(Integer WorkID) {
        this.WorkID = WorkID;
    }

    /**
     * @return Integer return the ClienteID
     */
    public Integer getClienteID() {
        return clienteID;
    }

    /**
     * @param ClienteID the ClienteID to set
     */
    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * @return String return the Voyage
     */
    public String getVoyage() {
        return Voyage;
    }

    /**
     * @param Voyage the Voyage to set
     */
    public void setVoyage(String Voyage) {
        this.Voyage = Voyage;
    }

    /**
     * @return Integer return the TipoCont
     */
    public Integer getTipoCont() {
        return TipoCont;
    }

    /**
     * @param TipoCont the TipoCont to set
     */
    public void setTipoCont(Integer TipoCont) {
        this.TipoCont = TipoCont;
    }

    /**
     * @return Boolean return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the TipoCont to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

}
