package com.appchoferes.nomina.models.durandb.dtos;

public class CartaPorte20 {
    private String transpinternac;
    private String entradasalidamerc;
    private String paisorigendestino;
    private String viaentradasalida;
    private String totaldistrec;
    private Ubicaciones20DTO ubicaciones20;
    private MercanciasCartaPorte20DTO mercanciasCartaPorte20;

    // Getters y Setters

    /**
     * @return String return the transpinternac
     */
    public String getTranspinternac() {
        return transpinternac;
    }

    /**
     * @param transpinternac the transpinternac to set
     */
    public void setTranspinternac(String transpinternac) {
        this.transpinternac = transpinternac;
    }

    /**
     * @return String return the entradasalidamerc
     */
    public String getEntradasalidamerc() {
        return entradasalidamerc;
    }

    /**
     * @param entradasalidamerc the entradasalidamerc to set
     */
    public void setEntradasalidamerc(String entradasalidamerc) {
        this.entradasalidamerc = entradasalidamerc;
    }

    /**
     * @return String return the paisorigendestino
     */
    public String getPaisorigendestino() {
        return paisorigendestino;
    }

    /**
     * @param paisorigendestino the paisorigendestino to set
     */
    public void setPaisorigendestino(String paisorigendestino) {
        this.paisorigendestino = paisorigendestino;
    }

    /**
     * @return String return the viaentradasalida
     */
    public String getViaentradasalida() {
        return viaentradasalida;
    }

    /**
     * @param viaentradasalida the viaentradasalida to set
     */
    public void setViaentradasalida(String viaentradasalida) {
        this.viaentradasalida = viaentradasalida;
    }

    /**
     * @return String return the totaldistrec
     */
    public String getTotaldistrec() {
        return totaldistrec;
    }

    /**
     * @param totaldistrec the totaldistrec to set
     */
    public void setTotaldistrec(String totaldistrec) {
        this.totaldistrec = totaldistrec;
    }

    /**
     * @return Ubicaciones20DTO return the ubicaciones20
     */
    public Ubicaciones20DTO getUbicaciones20() {
        return ubicaciones20;
    }

    /**
     * @param ubicaciones20 the ubicaciones20 to set
     */
    public void setUbicaciones20(Ubicaciones20DTO ubicaciones20) {
        this.ubicaciones20 = ubicaciones20;
    }

    /**
     * @return MercanciasCartaPorte20DTO return the mercanciasCartaPorte20
     */
    public MercanciasCartaPorte20DTO getMercanciasCartaPorte20() {
        return mercanciasCartaPorte20;
    }

    /**
     * @param mercanciasCartaPorte20 the mercanciasCartaPorte20 to set
     */
    public void setMercanciasCartaPorte20(MercanciasCartaPorte20DTO mercanciasCartaPorte20) {
        this.mercanciasCartaPorte20 = mercanciasCartaPorte20;
    }

}
