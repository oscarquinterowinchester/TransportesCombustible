package com.appchoferes.nomina.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores_tbl")
public class ProveedoresCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedorId")
    Long proveedorId;

    @Column(name = "nComercial")
    String nComercial;

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getnComercial() {
        return nComercial;
    }

    public void setnComercial(String nComercial) {
        this.nComercial = nComercial;
    }

    
}
