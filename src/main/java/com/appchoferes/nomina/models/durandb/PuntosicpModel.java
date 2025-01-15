package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "puntosicp_tbl")
public class PuntosicpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PuntosID")
    private Integer PuntosID;

    @Column(name = "ICartaID")
    private Integer ICartaID;

    @Column(name = "Tipo")
    private Integer Tipo;

    @Column(name = "IDPunto")
    private String IDPunto;

    @Column(name = "RFCPunto")
    private String RFCPunto;

    @Column(name = "NombrePunto")
    private String NombrePunto;

    @Column(name = "NumeroRegistro")
    private String NumeroRegistro;

    @Column(name = "ResidenciaFiscal")
    private String ResidenciaFiscal;

    @Column(name = "FormatoFecha")
    private String FormatoFecha;

    @Column(name = "RFCp")
    private String RFCp;

    @Column(name = "Calle")
    private String Calle;

    @Column(name = "NumeroExterior")
    private String NumeroExterior;

    @Column(name = "Colonia")
    private String Colonia;

    @Column(name = "Localidad")
    private String Localidad;

    @Column(name = "Municipio")
    private String Municipio;

    @Column(name = "Estado")
    private String Estado;

    @Column(name = "Pais")
    private String Pais;

    @Column(name = "CP")
    private String CP;

    // Getters and Setters

    /**
     * @return Integer return the PuntosID
     */
    public Integer getPuntosID() {
        return PuntosID;
    }

    /**
     * @param PuntosID the PuntosID to set
     */
    public void setPuntosID(Integer PuntosID) {
        this.PuntosID = PuntosID;
    }

    /**
     * @return Integer return the ICartaID
     */
    public Integer getICartaID() {
        return ICartaID;
    }

    /**
     * @param ICartaID the ICartaID to set
     */
    public void setICartaID(Integer ICartaID) {
        this.ICartaID = ICartaID;
    }

    /**
     * @return Integer return the Tipo
     */
    public Integer getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return String return the IDPunto
     */
    public String getIDPunto() {
        return IDPunto;
    }

    /**
     * @param IDPunto the IDPunto to set
     */
    public void setIDPunto(String IDPunto) {
        this.IDPunto = IDPunto;
    }

    /**
     * @return String return the RFCPunto
     */
    public String getRFCPunto() {
        return RFCPunto;
    }

    /**
     * @param RFCPunto the RFCPunto to set
     */
    public void setRFCPunto(String RFCPunto) {
        this.RFCPunto = RFCPunto;
    }

    /**
     * @return String return the NombrePunto
     */
    public String getNombrePunto() {
        return NombrePunto;
    }

    /**
     * @param NombrePunto the NombrePunto to set
     */
    public void setNombrePunto(String NombrePunto) {
        this.NombrePunto = NombrePunto;
    }

    /**
     * @return String return the NumeroRegistro
     */
    public String getNumeroRegistro() {
        return NumeroRegistro;
    }

    /**
     * @param NumeroRegistro the NumeroRegistro to set
     */
    public void setNumeroRegistro(String NumeroRegistro) {
        this.NumeroRegistro = NumeroRegistro;
    }

    /**
     * @return String return the ResidenciaFiscal
     */
    public String getResidenciaFiscal() {
        return ResidenciaFiscal;
    }

    /**
     * @param ResidenciaFiscal the ResidenciaFiscal to set
     */
    public void setResidenciaFiscal(String ResidenciaFiscal) {
        this.ResidenciaFiscal = ResidenciaFiscal;
    }

    /**
     * @return String return the FormatoFecha
     */
    public String getFormatoFecha() {
        return FormatoFecha;
    }

    /**
     * @param FormatoFecha the FormatoFecha to set
     */
    public void setFormatoFecha(String FormatoFecha) {
        this.FormatoFecha = FormatoFecha;
    }

    /**
     * @return String return the RFCp
     */
    public String getRFCp() {
        return RFCp;
    }

    /**
     * @param RFCp the RFCp to set
     */
    public void setRFCp(String RFCp) {
        this.RFCp = RFCp;
    }

    /**
     * @return String return the Calle
     */
    public String getCalle() {
        return Calle;
    }

    /**
     * @param Calle the Calle to set
     */
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    /**
     * @return String return the NumeroExterior
     */
    public String getNumeroExterior() {
        return NumeroExterior;
    }

    /**
     * @param NumeroExterior the NumeroExterior to set
     */
    public void setNumeroExterior(String NumeroExterior) {
        this.NumeroExterior = NumeroExterior;
    }

    /**
     * @return String return the Colonia
     */
    public String getColonia() {
        return Colonia;
    }

    /**
     * @param Colonia the Colonia to set
     */
    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    /**
     * @return String return the Localidad
     */
    public String getLocalidad() {
        return Localidad;
    }

    /**
     * @param Localidad the Localidad to set
     */
    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    /**
     * @return String return the Municipio
     */
    public String getMunicipio() {
        return Municipio;
    }

    /**
     * @param Municipio the Municipio to set
     */
    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    /**
     * @return String return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return String return the Pais
     */
    public String getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    /**
     * @return String return the CP
     */
    public String getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(String CP) {
        this.CP = CP;
    }

}
