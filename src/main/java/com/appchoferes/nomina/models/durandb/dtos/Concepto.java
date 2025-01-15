package com.appchoferes.nomina.models.durandb.dtos;

import java.util.List;

public class Concepto {
    private String ClaveProdServ;
    private String Cantidad;
    private String ClaveUnidad;
    private String Unidad;
    private String Descripcion;
    private String ValorUnitario;
    private String Importe;
    private String ObjetoImp;
    private List<Traslado> Traslados;
    private List<Retencion> Retenciones;
    // Getters y setters

    /**
     * @return String return the ClaveProdServ
     */
    public String getClaveProdServ() {
        return ClaveProdServ;
    }

    /**
     * @param ClaveProdServ the ClaveProdServ to set
     */
    public void setClaveProdServ(String ClaveProdServ) {
        this.ClaveProdServ = ClaveProdServ;
    }

    /**
     * @return String return the Cantidad
     */
    public String getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return String return the ClaveUnidad
     */
    public String getClaveUnidad() {
        return ClaveUnidad;
    }

    /**
     * @param ClaveUnidad the ClaveUnidad to set
     */
    public void setClaveUnidad(String ClaveUnidad) {
        this.ClaveUnidad = ClaveUnidad;
    }

    /**
     * @return String return the Unidad
     */
    public String getUnidad() {
        return Unidad;
    }

    /**
     * @param Unidad the Unidad to set
     */
    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    /**
     * @return String return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return String return the ValorUnitario
     */
    public String getValorUnitario() {
        return ValorUnitario;
    }

    /**
     * @param ValorUnitario the ValorUnitario to set
     */
    public void setValorUnitario(String ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    /**
     * @return String return the Importe
     */
    public String getImporte() {
        return Importe;
    }

    /**
     * @param Importe the Importe to set
     */
    public void setImporte(String Importe) {
        this.Importe = Importe;
    }

    /**
     * @return String return the ObjetoImp
     */
    public String getObjetoImp() {
        return ObjetoImp;
    }

    /**
     * @param ObjetoImp the ObjetoImp to set
     */
    public void setObjetoImp(String ObjetoImp) {
        this.ObjetoImp = ObjetoImp;
    }

    /**
     * @return List<Traslado> return the Traslados
     */
    public List<Traslado> getTraslados() {
        return Traslados;
    }

    /**
     * @param Traslados the Traslados to set
     */
    public void setTraslados(List<Traslado> Traslados) {
        this.Traslados = Traslados;
    }

    /**
     * @return List<Retencion> return the Retenciones
     */
    public List<Retencion> getRetenciones() {
        return Retenciones;
    }

    /**
     * @param Retenciones the Retenciones to set
     */
    public void setRetenciones(List<Retencion> Retenciones) {
        this.Retenciones = Retenciones;
    }

}
