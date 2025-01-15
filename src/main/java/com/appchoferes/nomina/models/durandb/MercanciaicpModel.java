package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "mercanciaicp_tbl")
public class MercanciaicpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MercanciaID")
    private Integer MercanciaID;

    @Column(name = "ICartaID")
    private Integer ICartaID;

    @Column(name = "WContID")
    private Integer WContID;

    @Column(name = "BienesTransp")
    private String BienesTransp;

    @Column(name = "Descripcionmerc")
    private String Descripcionmerc;

    @Column(name = "Cantidadmerc")
    private Float Cantidadmerc;

    @Column(name = "ClaveUnidad")
    private String ClaveUnidad;

    @Column(name = "Unidad")
    private String Unidad;

    @Column(name = "Dimensiones")
    private String Dimensiones;

    @Column(name = "MaterialPeligroso")
    private String MaterialPeligroso;

    @Column(name = "ClaveMatPel")
    private String ClaveMatPel;

    @Column(name = "Embalaje")
    private String Embalaje;

    @Column(name = "Descripcionemb")
    private String Descripcionemb;

    @Column(name = "PesoKG")
    private Float PesoKG;

    @Column(name = "ValorMerc")
    private Float ValorMerc;

    @Column(name = "MonedaMerc")
    private Integer MonedaMerc;

    @Column(name = "FraccionArancelaria")
    private String FraccionArancelaria;

    @Column(name = "UUIDComercioExt")
    private String UUIDComercioExt;

    @Column(name = "Pedimentos")
    private String Pedimentos;

    @Column(name = "TipoMateria")
    private String TipoMateria;

    @Column(name = "rfcimpo")
    private String rfcImpo;

    @Column(name = "wcontFK")
    private String wcontFK;


    /*public String getwcontFKo() {
        return wcontFK;
    }

    public void setwcontFK(String wcontFK) {
        this.wcontFK = wcontFK;
    }*/

    public String getRfcImpo() {
        return rfcImpo;
    }

    public void setRfcImpo(String rfcImpo) {
        this.rfcImpo = rfcImpo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Column(name = "TipoDocumento")
    private String tipoDocumento;

    // Getter and setter

    /**
     * @return Integer return the MercanciaID
     */
    public Integer getMercanciaID() {
        return MercanciaID;
    }

    /**
     * @param MercanciaID the MercanciaID to set
     */
    public void setMercanciaID(Integer MercanciaID) {
        this.MercanciaID = MercanciaID;
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
     * @return Integer return the WContID
     */
    public Integer getWContID() {
        return WContID;
    }

    /**
     * @param WContID the WContID to set
     */
    public void setWContID(Integer WContID) {
        this.WContID = WContID;
    }

    /**
     * @return String return the BienesTransp
     */
    public String getBienesTransp() {
        return BienesTransp;
    }

    /**
     * @param BienesTransp the BienesTransp to set
     */
    public void setBienesTransp(String BienesTransp) {
        this.BienesTransp = BienesTransp;
    }

    /**
     * @return String return the Descripcionmerc
     */
    public String getDescripcionmerc() {
        return Descripcionmerc;
    }

    /**
     * @param Descripcionmerc the Descripcionmerc to set
     */
    public void setDescripcionmerc(String Descripcionmerc) {
        this.Descripcionmerc = Descripcionmerc;
    }

    /**
     * @return Float return the Cantidadmerc
     */
    public Float getCantidadmerc() {
        return Cantidadmerc;
    }

    /**
     * @param Cantidadmerc the Cantidadmerc to set
     */
    public void setCantidadmerc(Float Cantidadmerc) {
        this.Cantidadmerc = Cantidadmerc;
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
     * @return String return the Dimensiones
     */
    public String getDimensiones() {
        return Dimensiones;
    }

    /**
     * @param Dimensiones the Dimensiones to set
     */
    public void setDimensiones(String Dimensiones) {
        this.Dimensiones = Dimensiones;
    }

    /**
     * @return String return the MaterialPeligroso
     */
    public String getMaterialPeligroso() {
        return MaterialPeligroso;
    }

    /**
     * @param MaterialPeligroso the MaterialPeligroso to set
     */
    public void setMaterialPeligroso(String MaterialPeligroso) {
        this.MaterialPeligroso = MaterialPeligroso;
    }

    /**
     * @return String return the ClaveMatPel
     */
    public String getClaveMatPel() {
        return ClaveMatPel;
    }

    /**
     * @param ClaveMatPel the ClaveMatPel to set
     */
    public void setClaveMatPel(String ClaveMatPel) {
        this.ClaveMatPel = ClaveMatPel;
    }

    /**
     * @return String return the Embalaje
     */
    public String getEmbalaje() {
        return Embalaje;
    }

    /**
     * @param Embalaje the Embalaje to set
     */
    public void setEmbalaje(String Embalaje) {
        this.Embalaje = Embalaje;
    }

    /**
     * @return String return the Descripcionemb
     */
    public String getDescripcionemb() {
        return Descripcionemb;
    }

    /**
     * @param Descripcionemb the Descripcionemb to set
     */
    public void setDescripcionemb(String Descripcionemb) {
        this.Descripcionemb = Descripcionemb;
    }

    /**
     * @return Float return the PesoKG
     */
    public Float getPesoKG() {
        return PesoKG;
    }

    /**
     * @param PesoKG the PesoKG to set
     */
    public void setPesoKG(Float PesoKG) {
        this.PesoKG = PesoKG;
    }

    /**
     * @return Float return the ValorMerc
     */
    public Float getValorMerc() {
        return ValorMerc;
    }

    /**
     * @param ValorMerc the ValorMerc to set
     */
    public void setValorMerc(Float ValorMerc) {
        this.ValorMerc = ValorMerc;
    }

    /**
     * @return Integer return the MonedaMerc
     */
    public Integer getMonedaMerc() {
        return MonedaMerc;
    }

    /**
     * @param MonedaMerc the MonedaMerc to set
     */
    public void setMonedaMerc(Integer MonedaMerc) {
        this.MonedaMerc = MonedaMerc;
    }

    /**
     * @return String return the FraccionArancelaria
     */
    public String getFraccionArancelaria() {
        return FraccionArancelaria;
    }

    /**
     * @param FraccionArancelaria the FraccionArancelaria to set
     */
    public void setFraccionArancelaria(String FraccionArancelaria) {
        this.FraccionArancelaria = FraccionArancelaria;
    }

    /**
     * @return String return the UUIDComercioExt
     */
    public String getUUIDComercioExt() {
        return UUIDComercioExt;
    }

    /**
     * @param UUIDComercioExt the UUIDComercioExt to set
     */
    public void setUUIDComercioExt(String UUIDComercioExt) {
        this.UUIDComercioExt = UUIDComercioExt;
    }

    /**
     * @return String return the Pedimentos
     */
    public String getPedimentos() {
        return Pedimentos;
    }

    /**
     * @param Pedimentos the Pedimentos to set
     */
    public void setPedimentos(String Pedimentos) {
        this.Pedimentos = Pedimentos;
    }

    /**
     * @return String return the TipoMateria
     */
    public String getTipoMateria() {
        return TipoMateria;
    }

    /**
     * @param TipoMateria the TipoMateria to set
     */
    public void setTipoMateria(String TipoMateria) {
        this.TipoMateria = TipoMateria;
    }

}
