package com.appchoferes.nomina.models.durandb.dtos;

import java.util.List;

public class MercanciasCartaPorte20DTO {
    private String pesobrutototal;
    private String unidadpeso;
    private String pesonetototal;
    private String numtotalmercancias;
    private String cargoportasacion;
    private List<MercanciaCartaPorte20DTO> mercanciaCartaPorte20;
    private AutotransporteDTO Autotransporte;

    // Setters y Getters

    /**
     * @return String return the pesobrutototal
     */
    public String getPesobrutototal() {
        return pesobrutototal;
    }

    /**
     * @param pesobrutototal the pesobrutototal to set
     */
    public void setPesobrutototal(String pesobrutototal) {
        this.pesobrutototal = pesobrutototal;
    }

    /**
     * @return String return the unidadpeso
     */
    public String getUnidadpeso() {
        return unidadpeso;
    }

    /**
     * @param unidadpeso the unidadpeso to set
     */
    public void setUnidadpeso(String unidadpeso) {
        this.unidadpeso = unidadpeso;
    }

    /**
     * @return String return the pesonetototal
     */
    public String getPesonetototal() {
        return pesonetototal;
    }

    /**
     * @param pesonetototal the pesonetototal to set
     */
    public void setPesonetototal(String pesonetototal) {
        this.pesonetototal = pesonetototal;
    }

    /**
     * @return String return the numtotalmercancias
     */
    public String getNumtotalmercancias() {
        return numtotalmercancias;
    }

    /**
     * @param numtotalmercancias the numtotalmercancias to set
     */
    public void setNumtotalmercancias(String numtotalmercancias) {
        this.numtotalmercancias = numtotalmercancias;
    }

    /**
     * @return String return the cargoportasacion
     */
    public String getCargoportasacion() {
        return cargoportasacion;
    }

    /**
     * @param cargoportasacion the cargoportasacion to set
     */
    public void setCargoportasacion(String cargoportasacion) {
        this.cargoportasacion = cargoportasacion;
    }

    /**
     * @return List<MercanciaCartaPorte20DTO> return the mercanciaCartaPorte20
     */
    public List<MercanciaCartaPorte20DTO> getMercanciaCartaPorte20() {
        return mercanciaCartaPorte20;
    }

    /**
     * @param mercanciaCartaPorte20 the mercanciaCartaPorte20 to set
     */
    public void setMercanciaCartaPorte20(List<MercanciaCartaPorte20DTO> mercanciaCartaPorte20) {
        this.mercanciaCartaPorte20 = mercanciaCartaPorte20;
    }

    /**
     * @return AutotransporteDTO return the Autotransporte
     */
    public AutotransporteDTO getAutotransporte() {
        return Autotransporte;
    }

    /**
     * @param Autotransporte the Autotransporte to set
     */
    public void setAutotransporte(AutotransporteDTO Autotransporte) {
        this.Autotransporte = Autotransporte;
    }

}
