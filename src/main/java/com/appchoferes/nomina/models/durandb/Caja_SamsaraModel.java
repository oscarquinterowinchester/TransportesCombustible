package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "camioncaja_samsara_tbl")
public class Caja_SamsaraModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CamionCajaSamID")
    private Integer CamionCajaSamID;

    @Column(name = "NoEconomico")
    private String NoEconomico;

    @Column(name = "Status")
    private Integer Status;
 
    //Getters and Setter

    /**
     * @return Integer return the CamionCajaSamID
     */
    public Integer getCamionCajaSamID() {
        return CamionCajaSamID;
    }

    /**
     * @param CamionCajaSamID the CamionCajaSamID to set
     */
    public void setCamionCajaSamID(Integer CamionCajaSamID) {
        this.CamionCajaSamID = CamionCajaSamID;
    }

    /**
     * @return String return the NoEconomico
     */
    public String getNoEconomico() {
        return NoEconomico;
    }

    /**
     * @param NoEconomico the NoEconomico to set
     */
    public void setNoEconomico(String NoEconomico) {
        this.NoEconomico = NoEconomico;
    }

    /**
     * @return Integer return the Status
     */
    public Integer getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Integer Status) {
        this.Status = Status;
    }

}
