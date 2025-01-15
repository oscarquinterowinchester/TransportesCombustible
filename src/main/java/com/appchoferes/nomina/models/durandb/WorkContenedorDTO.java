package com.appchoferes.nomina.models.durandb;

public class WorkContenedorDTO {
    public String descripcion = "";
    public String consat = "";
    public String unisat = "";
    public String objetoimcp = "";
    public Double iva = null;
    public Double ivaret = null;
    public Double importe = null;

    public Double getImporte() {
        return importe;
    }
    public void setImporte(Double importe) {
        this.importe = importe;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsat() {
        return consat;
    }
    public void setConsat(String consat) {
        this.consat = consat;
    }
    public String getUnisat() {
        return unisat;
    }
    public void setUnisat(String unisat) {
        this.unisat = unisat;
    }
    public String getObjimp() {
        return objetoimcp;
    }
    public void setObjimp(String objetoimcp) {
        this.objetoimcp = objetoimcp;
    }
    public Double getIva() {
        return iva;
    }
    public void setIva(Double iva) {
        this.iva = iva;
    }
    public Double getIvaret() {
        return ivaret;
    }
    public void setIvaret(Double ivaret) {
        this.ivaret = ivaret;
    }



}
