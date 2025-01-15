package com.appchoferes.nomina.models.durandb.dtos;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Ubicacion {
    private String tipoubicacion;
    private String idubicacion;
    private String rfcremitentedestinatario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahorasalidallegada;
    private DomicilioUbicacionDTO domicilioUbicacion;

    // Getters y Setters

    /**
     * @return String return the tipoubicacion
     */
    public String getTipoubicacion() {
        return tipoubicacion;
    }

    /**
     * @param tipoubicacion the tipoubicacion to set
     */
    public void setTipoubicacion(String tipoubicacion) {
        this.tipoubicacion = tipoubicacion;
    }

    /**
     * @return String return the idubicacion
     */
    public String getIdubicacion() {
        return idubicacion;
    }

    /**
     * @param idubicacion the idubicacion to set
     */
    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    /**
     * @return String return the rfcremitentedestinatario
     */
    public String getRfcremitentedestinatario() {
        return rfcremitentedestinatario;
    }

    /**
     * @param rfcremitentedestinatario the rfcremitentedestinatario to set
     */
    public void setRfcremitentedestinatario(String rfcremitentedestinatario) {
        this.rfcremitentedestinatario = rfcremitentedestinatario;
    }

    /**
     * @return Date return the fechahorasalidallegada
     */
    public Date getFechahorasalidallegada() {
        return fechahorasalidallegada;
    }

    /**
     * @param fechahorasalidallegada the fechahorasalidallegada to set
     */
    public void setFechahorasalidallegada(Date fechahorasalidallegada) {
        this.fechahorasalidallegada = fechahorasalidallegada;
    }

    /**
     * @return DomicilioUbicacionDTO return the domicilioUbicacion
     */
    public DomicilioUbicacionDTO getDomicilioUbicacion() {
        return domicilioUbicacion;
    }

    /**
     * @param domicilioUbicacion the domicilioUbicacion to set
     */
    public void setDomicilioUbicacion(DomicilioUbicacionDTO domicilioUbicacion) {
        this.domicilioUbicacion = domicilioUbicacion;
    }

}
