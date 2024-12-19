package com.appchoferes.nomina.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposCombustible")
public class TipoCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoCombustibleId") //llave primaria aqui
    Long tipoCombustibleId;
    
    String nombreTipo;
    boolean status;
    boolean seguimientoRendimiento;
    
    public Long getTipoCombustibleId() {
        return tipoCombustibleId;
    }
    public void setTipoCombustibleId(Long tipoCombustibleId) {
        this.tipoCombustibleId = tipoCombustibleId;
    }
    public String getNombreTipo() {
        return nombreTipo;
    }
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean isSeguimientoRendimiento() {
        return seguimientoRendimiento;
    }
    public void setSeguimientoRendimiento(boolean seguimientoRendimiento) {
        this.seguimientoRendimiento = seguimientoRendimiento;
    }

    
}
