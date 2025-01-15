package com.appchoferes.nomina.repositories.durandb;


import java.util.Date;

public class TipoCambioDTORepository {
    private Integer cambioID;
    private Float tipoCambio;
    private Date fecha;
    private String fechaRegistro;
    private Integer usuarioID;
    private Boolean status;
    private String nombreUsuario;
    private Long validoEliminar;

    // Getters y setters
    public Integer getCambioID() {
        return cambioID;
    }

    public void setCambioID(Integer cambioID) {
        this.cambioID = cambioID;
    }

    public Float getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Float tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getvalidoEliminar() {
        return validoEliminar;
    }

    public void setvalidoEliminar(Long validoEliminar) {
        this.validoEliminar = validoEliminar;
    }
}
