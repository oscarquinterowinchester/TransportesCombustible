package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tipocambio_tbl")
public class TipoCambioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CambioID")
    private Integer CambioID;

    //@JsonProperty("TipoCambio")
    @Column(name = "TipoCambio")
    private Float TipoCambio;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "Fecha")
    private Date Fecha;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "FechaRegistro")
    private Date FechaRegistro;

    //@JsonProperty("UsuarioID")
    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    //@JsonProperty("Status")
    @Column(name = "Status")
    private Boolean Status;

    // Getters and Setters

    /**
     * @return Integer return the CambioID
     */
    public Integer getCambioID() {
        return CambioID;
    }

    /**
     * @param CambioID the CambioID to set
     */
    public void setCambioID(Integer CambioID) {
        this.CambioID = CambioID;
    }

    /**
     * @return String return the TipoCambio
     */
    public Float getTipoCambio() {
        return TipoCambio;
    }

    /**
     * @param TipoCambio the TipoCambio to set
     */
    public void setTipoCambio(Float TipoCambio) {
        this.TipoCambio = TipoCambio;
    }

    /**
     * @return Date return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return Date return the FechaRegistro
     */
    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    /**
     * @param FechaRegistro the FechaRegistro to set
     */
    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    /**
     * @return Integer return the UsuarioID
     */
    public Integer getUsuarioID() {
        return UsuarioID;
    }

    /**
     * @param UsuarioID the UsuarioID to set
     */
    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
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
