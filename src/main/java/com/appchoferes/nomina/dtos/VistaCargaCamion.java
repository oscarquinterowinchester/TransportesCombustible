package com.appchoferes.nomina.dtos;

import java.util.List;

import com.appchoferes.nomina.models.MetodosPago;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class VistaCargaCamion {

    Long camionId;
    String noEconomico;
    String tanqueActual;
    List<CargasDiesel> cargasDiesel;
    List<ProveedoresCombustible> proveedores;
    List<TipoCombustible> tipoCombustibles;
    List<MetodosPago> metodosPagos;
    
    public List<TipoCombustible> getTipoCombustibles() {
        return tipoCombustibles;
    }
    public void setTipoCombustibles(List<TipoCombustible> tipoCombustibles) {
        this.tipoCombustibles = tipoCombustibles;
    }
    public List<MetodosPago> getMetodosPagos() {
        return metodosPagos;
    }
    public void setMetodosPagos(List<MetodosPago> metodosPagos) {
        this.metodosPagos = metodosPagos;
    }
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
    public List<ProveedoresCombustible> getProveedores() {
        return proveedores;
    }
    public void setProveedores(List<ProveedoresCombustible> proveedores) {
        this.proveedores = proveedores;
    }
    public List<CargasDiesel> getCargasDiesel() {
        return cargasDiesel;
    }
    public void setCargasDiesel(List<CargasDiesel> cargasDiesel) {
        this.cargasDiesel = cargasDiesel;
    }

    

}
