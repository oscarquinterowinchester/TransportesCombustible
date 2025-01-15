package com.appchoferes.nomina.models.durandb.dtos;

import java.util.List;

public class Pedimentos {
    private List<PedimentoCartaPorteDTO> pedimentoCartaPorte;

    // Getters y Setters

    /**
     * @return List<PedimentoCartaPorteDTO> return the pedimentoCartaPorte
     */
    public List<PedimentoCartaPorteDTO> getPedimentoCartaPorte() {
        return pedimentoCartaPorte;
    }

    /**
     * @param pedimentoCartaPorte the pedimentoCartaPorte to set
     */
    public void setPedimentoCartaPorte(List<PedimentoCartaPorteDTO> pedimentoCartaPorte) {
        this.pedimentoCartaPorte = pedimentoCartaPorte;
    }

}
