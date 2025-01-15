package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "iticartasporte_tbl")
public class ItiCartasPorteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ICartaID")
    private Integer ICartaID;

    @ManyToOne
    @JoinColumn(name = "itinerarioID")
    private ItinerariosModel itinerario;

    @Column(name = "CartaPorteID")
    private Integer cartaPorteID;

    @Column(name = "ItinerarioID")
    private Integer ItinerarioID;

    @Column(name = "NoCartaPorte")
    private String NoCartaPorte;

    @Column(name = "WContID1")
    private Integer WContID1;

    @Column(name = "Descripcion")
    private String Descripcion;

    @Column(name = "ConceptoSAT")
    private String ConceptoSAT;

    @Column(name = "UnidadSAT")
    private String UnidadSAT;

    @Column(name = "Importe")
    private String Importe;

    @Column(name = "Cantidad")
    private Float Cantidad;

    @Column(name = "objimpcp")
    private Byte objimpcp;

    @Column(name = "IVAcp")
    private Integer IVAcp;

    @Column(name = "IVARETcp")
    private Integer IVARETcp;

    @Column(name = "TransporteInter")
    private String TransporteInter;

    @Column(name = "EntradaSalida")
    private String EntradaSalida;

    @Column(name = "DistanciaTotal")
    private Float DistanciaTotal;

    @Column(name = "PesoBruto")
    private Float PesoBruto;

    @Column(name = "UnidadPeso")
    private String UnidadPeso;

    @Column(name = "PesoNeto")
    private Float PesoNeto;

    @Column(name = "TotalMercancias")
    private Integer TotalMercancias;

    @Column(name = "ConfigVehicular")
    private String ConfigVehicular;

    @Column(name = "Status")
    private Byte status;

    // Getters and Setters

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
     * @return Integer return the CartaPorteID
     */
    public Integer getCartaPorteID() {
        return cartaPorteID;
    }

    /**
     * @param CartaPorteID the CartaPorteID to set
     */
    public void setCartaPorteID(Integer CartaPorteID) {
        this.cartaPorteID = CartaPorteID;
    }

    /**
     * @return Integer return the ItinerarioID
     */
    public Integer getItinerarioID() {
        return ItinerarioID;
    }

    /**
     * @param ItinerarioID the ItinerarioID to set
     */
    public void setItinerarioID(Integer ItinerarioID) {
        this.ItinerarioID = ItinerarioID;
    }

    /**
     * @return String return the NoCartaPorte
     */
    public String getNoCartaPorte() {
        return NoCartaPorte;
    }

    /**
     * @param NoCartaPorte the NoCartaPorte to set
     */
    public void setNoCartaPorte(String NoCartaPorte) {
        this.NoCartaPorte = NoCartaPorte;
    }

    /**
     * @return Integer return the WContID1
     */
    public Integer getWContID1() {
        return WContID1;
    }

    /**
     * @param WContID1 the WContID1 to set
     */
    public void setWContID1(Integer WContID1) {
        this.WContID1 = WContID1;
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
     * @return Byte return the objimpcp
     */
    public Byte getObjimpcp() {
        return objimpcp;
    }

    /**
     * @param objimpcp the objimpcp to set
     */
    public void setObjimpcp(Byte objimpcp) {
        this.objimpcp = objimpcp;
    }

    /**
     * @return Integer return the IVAcp
     */
    public Integer getIVAcp() {
        return IVAcp;
    }

    /**
     * @param IVAcp the IVAcp to set
     */
    public void setIVAcp(Integer IVAcp) {
        this.IVAcp = IVAcp;
    }

    /**
     * @return Integer return the IVARETcp
     */
    public Integer getIVARETcp() {
        return IVARETcp;
    }

    /**
     * @param IVARETcp the IVARETcp to set
     */
    public void setIVARETcp(Integer IVARETcp) {
        this.IVARETcp = IVARETcp;
    }

    /**
     * @return String return the TransporteInter
     */
    public String getTransporteInter() {
        return TransporteInter;
    }

    /**
     * @param TransporteInter the TransporteInter to set
     */
    public void setTransporteInter(String TransporteInter) {
        this.TransporteInter = TransporteInter;
    }

    /**
     * @return String return the EntradaSalida
     */
    public String getEntradaSalida() {
        return EntradaSalida;
    }

    /**
     * @param EntradaSalida the EntradaSalida to set
     */
    public void setEntradaSalida(String EntradaSalida) {
        this.EntradaSalida = EntradaSalida;
    }

    /**
     * @return Float return the DistanciaTotal
     */
    public Float getDistanciaTotal() {
        return DistanciaTotal;
    }

    /**
     * @param DistanciaTotal the DistanciaTotal to set
     */
    public void setDistanciaTotal(Float DistanciaTotal) {
        this.DistanciaTotal = DistanciaTotal;
    }

    /**
     * @return Float return the PesoBruto
     */
    public Float getPesoBruto() {
        return PesoBruto;
    }

    /**
     * @param PesoBruto the PesoBruto to set
     */
    public void setPesoBruto(Float PesoBruto) {
        this.PesoBruto = PesoBruto;
    }

    /**
     * @return String return the UnidadPeso
     */
    public String getUnidadPeso() {
        return UnidadPeso;
    }

    /**
     * @param UnidadPeso the UnidadPeso to set
     */
    public void setUnidadPeso(String UnidadPeso) {
        this.UnidadPeso = UnidadPeso;
    }

    /**
     * @return Float return the PesoNeto
     */
    public Float getPesoNeto() {
        return PesoNeto;
    }

    /**
     * @param PesoNeto the PesoNeto to set
     */
    public void setPesoNeto(Float PesoNeto) {
        this.PesoNeto = PesoNeto;
    }

    /**
     * @return Integer return the TotalMercancias
     */
    public Integer getTotalMercancias() {
        return TotalMercancias;
    }

    /**
     * @param TotalMercancias the TotalMercancias to set
     */
    public void setTotalMercancias(Integer TotalMercancias) {
        this.TotalMercancias = TotalMercancias;
    }

    /**
     * @return String return the ConfigVehicular
     */
    public String getConfigVehicular() {
        return ConfigVehicular;
    }

    /**
     * @param ConfigVehicular the ConfigVehicular to set
     */
    public void setConfigVehicular(String ConfigVehicular) {
        this.ConfigVehicular = ConfigVehicular;
    }

    /**
     * @return Byte return the status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return false;
    }

}
