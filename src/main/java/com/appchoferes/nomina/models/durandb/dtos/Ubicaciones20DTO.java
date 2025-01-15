package com.appchoferes.nomina.models.durandb.dtos;

import java.util.List;

public class Ubicaciones20DTO {
    private List<Ubicacion> ubicaciones;

    // Getter y setter

    /**
     * @return List<UbicacionDTO> return the ubicaciones
     */
    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

}
