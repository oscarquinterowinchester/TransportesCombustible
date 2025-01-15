package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "operadoricp_tbl")
public class OperadoricpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OperadorID")
    private Integer OperadorID;

    @Column(name = "ICartaID")
    private Integer ICartaID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Licencia")
    private String Licencia;

    @Column(name = "RFC")
    private String RFC;

    @Column(name = "NumRegIdTribOperador")
    private String NumRegIdTribOperador;

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
     * @return Integer return the OperadorID
     */
    public Integer getOperadorID() {
        return OperadorID;
    }

    /**
     * @param OperadorID the OperadorID to set
     */
    public void setOperadorID(Integer OperadorID) {
        this.OperadorID = OperadorID;
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
     * @return String return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return String return the Licencia
     */
    public String getLicencia() {
        return Licencia;
    }

    /**
     * @param Licencia the Licencia to set
     */
    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    /**
     * @return String return the RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * @param RFC the RFC to set
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * @return String return the NumRegIdTribOperador
     */
    public String getNumRegIdTribOperador() {
        return NumRegIdTribOperador;
    }

    /**
     * @param NumRegIdTribOperador the NumRegIdTribOperador to set
     */
    public void setNumRegIdTribOperador(String NumRegIdTribOperador) {
        this.NumRegIdTribOperador = NumRegIdTribOperador;
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
