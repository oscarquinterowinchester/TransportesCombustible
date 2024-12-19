package com.appchoferes.nomina.dtos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CamionCarga {

    @Id
    Long camionId;

    String noEconomico;

    String tanqueActual;

    public Long getCamionId() {
        return camionId;
    }

    public void setCamionId(Long camionId) {
        this.camionId = camionId;
    }

    public String getNoEconomico() {
        return noEconomico;
    }

    public void setNoEconomico(String noEconomico) {
        this.noEconomico = noEconomico;
    }

    public String getTanqueActual() {
        return tanqueActual;
    }

    public void setTanqueActual(String tanqueActual) {
        this.tanqueActual = tanqueActual;
    }
    

}
