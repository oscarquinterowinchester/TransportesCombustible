package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "cargosclientes_tbl")
public class CargosClientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CargoID")
    private Integer CargoID;

    @Column(name = "Concepto")
    private String Concepto;

    @Column(name = "Cantidad")
    private Float Cantidad;

    @Column(name = "objimpc")
    private Byte objimpc;

    @Column(name = "IVAc")
    private Float IVAc;

    @Column(name = "IVARETc")
    private Float IVARETc;

    @Column(name = "ConceptoSAT")
    private String ConceptoSAT;

    @Column(name = "UnidadSAT")
    private String UnidadSAT;

    @Column(name = "WContID")
    private Integer WContID;

    // Getters and Setters

    /**
     * @return Integer return the CargoID
     */
    public Integer getCargoID() {
        return CargoID;
    }

    /**
     * @param CargoID the CargoID to set
     */
    public void setCargoID(Integer CargoID) {
        this.CargoID = CargoID;
    }

    /**
     * @return String return the Concepto
     */
    public String getConcepto() {
        return Concepto;
    }

    /**
     * @param Concepto the Concepto to set
     */
    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    /**
     * @return Float return the Cantidad
     */
    public Float getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(Float Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return Byte return the objimpc
     */
    public Byte getObjimpc() {
        return objimpc;
    }

    /**
     * @param objimpc the objimpc to set
     */
    public void setObjimpc(Byte objimpc) {
        this.objimpc = objimpc;
    }

    /**
     * @return Float return the IVAc
     */
    public Float getIVAc() {
        return IVAc;
    }

    /**
     * @param IVAc the IVAc to set
     */
    public void setIVAc(Float IVAc) {
        this.IVAc = IVAc;
    }

    /**
     * @return Float return the IVARETc
     */
    public Float getIVARETc() {
        return IVARETc;
    }

    /**
     * @param IVARETc the IVARETc to set
     */
    public void setIVARETc(Float IVARETc) {
        this.IVARETc = IVARETc;
    }

    /**
     * @return String return the ConceptoSAT
     */
    public String getConceptoSAT() {
        return ConceptoSAT;
    }

    /**
     * @param ConceptoSAT the ConceptoSAT to set
     */
    public void setConceptoSAT(String ConceptoSAT) {
        this.ConceptoSAT = ConceptoSAT;
    }

    /**
     * @return String return the UnidadSAT
     */
    public String getUnidadSAT() {
        return UnidadSAT;
    }

    /**
     * @param UnidadSAT the UnidadSAT to set
     */
    public void setUnidadSAT(String UnidadSAT) {
        this.UnidadSAT = UnidadSAT;
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

}
