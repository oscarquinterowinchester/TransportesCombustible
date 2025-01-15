package com.appchoferes.nomina.models.durandb.dtos;

public class FacturaDTO {
    private String usuario;
    private String contrasena;
    private DatosCFDI40DTO datosCFDI40;
    private ReceptorCFDI40 receptorCFDI40;
    private ConceptosCFDI40 conceptosCFDI40;
    private CartaPorte20 cartaPorte20;
    private FiguraTransporte20 FiguraTransporte20;

    // Getters y Setters

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return DatosCFDI40DTO return the datosCFDI40
     */
    public DatosCFDI40DTO getDatosCFDI40() {
        return datosCFDI40;
    }

    /**
     * @param datosCFDI40 the datosCFDI40 to set
     */
    public void setDatosCFDI40(DatosCFDI40DTO datosCFDI40) {
        this.datosCFDI40 = datosCFDI40;
    }

    /**
     * @return ReceptorCFDI40 return the receptorCFDI40
     */
    public ReceptorCFDI40 getReceptorCFDI40() {
        return receptorCFDI40;
    }

    /**
     * @param receptorCFDI40 the receptorCFDI40 to set
     */
    public void setReceptorCFDI40(ReceptorCFDI40 receptorCFDI40) {
        this.receptorCFDI40 = receptorCFDI40;
    }

    /**
     * @return ConceptosCFDI40 return the conceptosCFDI40
     */
    public ConceptosCFDI40 getConceptosCFDI40() {
        return conceptosCFDI40;
    }

    /**
     * @param conceptosCFDI40 the conceptosCFDI40 to set
     */
    public void setConceptosCFDI40(ConceptosCFDI40 conceptosCFDI40) {
        this.conceptosCFDI40 = conceptosCFDI40;
    }

    /**
     * @return CartaPorte20 return the cartaPorte20
     */
    public CartaPorte20 getCartaPorte20() {
        return cartaPorte20;
    }

    /**
     * @param cartaPorte20 the cartaPorte20 to set
     */
    public void setCartaPorte20(CartaPorte20 cartaPorte20) {
        this.cartaPorte20 = cartaPorte20;
    }

    /**
     * @return FiguraTransporte20 return the FiguraTransporte20
     */
    public FiguraTransporte20 getFiguraTransporte20() {
        return FiguraTransporte20;
    }

    /**
     * @param FiguraTransporte20 the FiguraTransporte20 to set
     */
    public void setFiguraTransporte20(FiguraTransporte20 FiguraTransporte20) {
        this.FiguraTransporte20 = FiguraTransporte20;
    }

}
