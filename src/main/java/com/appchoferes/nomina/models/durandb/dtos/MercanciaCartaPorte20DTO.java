package com.appchoferes.nomina.models.durandb.dtos;

public class MercanciaCartaPorte20DTO {
    private String bienestransp;
    // private String clavestcc;
    private String descripcion_mercancia;
    private String cantidad_mercancia;
    private String claveunidad_mercancia;
    private String pesoenkg;
    private Pedimentos Pedimentos;
    // Getters y Setters

    /**
     * @return String return the bienestransp
     */
    public String getBienestransp() {
        return bienestransp;
    }

    /**
     * @param bienestransp the bienestransp to set
     */
    public void setBienestransp(String bienestransp) {
        this.bienestransp = bienestransp;
    }

    /**
     * @return String return the descripcion_mercancia
     */
    public String getDescripcion_mercancia() {
        return descripcion_mercancia;
    }

    /**
     * @param descripcion_mercancia the descripcion_mercancia to set
     */
    public void setDescripcion_mercancia(String descripcion_mercancia) {
        this.descripcion_mercancia = descripcion_mercancia;
    }

    /**
     * @return String return the cantidad_mercancia
     */
    public String getCantidad_mercancia() {
        return cantidad_mercancia;
    }

    /**
     * @param cantidad_mercancia the cantidad_mercancia to set
     */
    public void setCantidad_mercancia(String cantidad_mercancia) {
        this.cantidad_mercancia = cantidad_mercancia;
    }

    /**
     * @return String return the claveunidad_mercancia
     */
    public String getClaveunidad_mercancia() {
        return claveunidad_mercancia;
    }

    /**
     * @param claveunidad_mercancia the claveunidad_mercancia to set
     */
    public void setClaveunidad_mercancia(String claveunidad_mercancia) {
        this.claveunidad_mercancia = claveunidad_mercancia;
    }

    /**
     * @return String return the pesoenkg
     */
    public String getPesoenkg() {
        return pesoenkg;
    }

    /**
     * @param pesoenkg the pesoenkg to set
     */
    public void setPesoenkg(String pesoenkg) {
        this.pesoenkg = pesoenkg;
    }

    /**
     * @return Pedimentos return the Pedimentos
     */
    public Pedimentos getPedimentos() {
        return Pedimentos;
    }

    /**
     * @param Pedimentos the Pedimentos to set
     */
    public void setPedimentos(Pedimentos Pedimentos) {
        this.Pedimentos = Pedimentos;
    }

}
