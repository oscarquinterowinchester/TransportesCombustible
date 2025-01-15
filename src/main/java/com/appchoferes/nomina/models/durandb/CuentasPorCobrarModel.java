package com.appchoferes.nomina.models.durandb;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentasxcobrar")
public class CuentasPorCobrarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idcliente")
    private Integer idCliente;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "numdoc")
    private String numDoc;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "totalfactura")
    private Double totalFactura;

    @Column(name = "saldoFactura")
    private Double saldoFactura;

    @Column(name = "tipocambio")
    private Double tipoCambio;

    @Column(name = "monedafactura")
    private String monedaFactura;

    @Column(name = "fechafactura")
    private Date fechaFactura;

    @Column(name = "fechavencimiento")
    private Date fechaVencimiento;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "tipofactura")
    private Integer tipoFactura;

    @Column(name = "pathpdf")
    private String pathPDF;

    @Column(name = "pathxml")
    private String pathXML;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Double getSaldoFactura() {
        return saldoFactura;
    }

    public void setSaldoFactura(Double saldoFactura) {
        this.saldoFactura = saldoFactura;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getMonedaFactura() {
        return monedaFactura;
    }

    public void setMonedaFactura(String monedaFactura) {
        this.monedaFactura = monedaFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(Integer tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getPathPDF() {
        return pathPDF;
    }

    public void setPathPDF(String pathPDF) {
        this.pathPDF = pathPDF;
    }

    public String getPathXML() {
        return pathXML;
    }

    public void setPathXML(String pathXML) {
        this.pathXML = pathXML;
    }
    
    
}
