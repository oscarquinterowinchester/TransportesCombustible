package com.appchoferes.nomina.models.durandb.dtos;

public class DomicilioUbicacionDTO {
    private String estado;
    private String pais;
    private String codigopostal;

    // Getters y Setters

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return String return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return String return the codigopostal
     */
    public String getCodigopostal() {
        return codigopostal;
    }

    /**
     * @param codigopostal the codigopostal to set
     */
    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

}
