package com.appchoferes.nomina.models.durandb;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "workcontenedores_tbl")
public class WorkcontenedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WContenedorID")
    private Integer WContenedorID;

    @Column(name = "WorkOrderID")
    private Integer WorkOrderID;

    @Column(name = "Cantidad")
    private Integer Cantidad;

    @Column(name = "ConceptoSAT")
    private String ConceptoSAT;

    @Column(name = "UnidadSAT")
    private String UnidadSAT;

    @Column(name = "AvDate")
    @Temporal(TemporalType.DATE)
    private Date AvDate;

    @Column(name = "TipoOperacion")
    private Integer TipoOperacion;

    @Column(name = "TipoUID")
    private Integer TipoUID;

    @Column(name = "clientefk")
    private Integer clientefk;

    @Column(name = "RutaID")
    private Integer RutaID;

    @Column(name = "tipoMov")
    private Integer tipoMov;

    @Column(name = "FechaPosicion")
    //@Temporal(TemporalType.DATE)
    private Date FechaPosicion;

    @Column(name = "Contenedor")
    private String Contenedor;

    @Column(name = "ncontenedor")
    private String ncontenedor;

    @Column(name = "Tamano")
    private String Tamano;

    @Column(name = "EstadoCarga")
    private Integer EstadoCarga;

    @Column(name = "CusRef")
    private String CusRef;

    @Column(name = "NumeroReservacion")
    private String NumeroReservacion;

    @Column(name = "EdiID")
    private Integer EdiID;

    @Column(name = "copiable")
    private Byte copiable;

    @Column(name = "navierafk")
    private Integer navierafk;

    @Column(name = "navierawc")
    private String navierawc;

    @Column(name = "buquewc")
    private String buquewc;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "FolioTE")
    private String FolioTE;

    @Column(name = "PesoC")
    private Float PesoC;

    @Column(name = "BLwc")
    private String BLwc;

    @Column(name = "PONumber")
    private String PONumber;

    @Column(name = "inbond")
    private String inbond;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "NotaInterna")
    private String NotaInterna;

    @Column(name = "referenciaccp")
    private String referenciaccp;

    @Column(name = "equipprovid")
    private Integer equipprovid;

    @Column(name = "Status")
    private Byte Status;

    @Column(name = "Statusf")
    private Integer Statusf;

    @Column(name = "AppoimentDate")
    private LocalDateTime AppoimentDate;

    @Column(name = "OutPort")
    @Temporal(TemporalType.TIMESTAMP)
    private Date OutPort;

    @Column(name = "DeliveryDate")
    private LocalDateTime DeliveryDateReq;

    @Column(name = "cScale")
    private Byte cScale;

    @Column(name = "LastFreeDay")
    @Temporal(TemporalType.DATE)
    private Date LastFreeDay;

    @Column(name = "PlacasChasis")
    private String PlacasChasis;

    @Column(name = "EstadoPlacas")
    private String EstadoPlacas;

    @Column(name = "NotaProgramacion")
    private String NotaProgramacion;

    @Column(name = "NumeroSello")
    private String NumeroSello;

    @Column(name = "RFD")
    @Temporal(TemporalType.DATE)
    private Date RFD;

    @Column(name = "AppNumber")
    private String AppNumber;

    @Column(name = "USArrDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date USArrDate;

    // @Column(name = "DeliveryDate")
    // @Temporal(TemporalType.TIMESTAMP)
    // private Date DeliveryDate;

    @Column(name = "PUCliente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date PUCliente;

    @Column(name = "CobroCliente")
    private Float CobroCliente;

    @Column(name = "MonedaCliente")
    private Integer MonedaCliente;

    @Column(name = "cSubtipoRem")
    private String cSubtipoRem;

    @Column(name = "camionfk")
    private Integer camionfk;

    @Column(name = "choferfk")
    private Integer choferfk;

    @Column(name = "cajaid")
    private Integer cajaid;

    // Getters and Setters


    /**
     * @return Integer return the WContenedorID
     */
    public Integer getWContenedorID() {
        return WContenedorID;
    }


    /**
     * @param WContenedorID the WContenedorID to set
     */
    public void setWContenedorID(Integer WContenedorID) {
        this.WContenedorID = WContenedorID;
    }

    /**
     * @return Integer return the TipoOperacion
     */
    public Integer getTipoOperacion() {
        return TipoOperacion;
    }

    /**
     * @param TipoOperacion the TipoOperacion to set
     */
    public void setTipoOperacion(Integer TipoOperacion) {
        this.TipoOperacion = TipoOperacion;
    }

    /**
     * @return Integer return the TipoUID
     */
    public Integer getTipoUID() {
        return TipoUID;
    }

    /**
     * @param TipoUID the TipoUID to set
     */
    public void setTipoUID(Integer TipoUID) {
        this.TipoUID = TipoUID;
    }

    /**
     * @return Integer return the clientefk
     */
    public Integer getClientefk() {
        return clientefk;
    }

    /**
     * @param clientefk the clientefk to set
     */
    public void setClientefk(Integer clientefk) {
        this.clientefk = clientefk;
    }

    /**
     * @return Integer return the RutaID
     */
    public Integer getRutaID() {
        return RutaID;
    }

    /**
     * @param RutaID the RutaID to set
     */
    public void setRutaID(Integer RutaID) {
        this.RutaID = RutaID;
    }

    /**
     * @return Integer return the tipoMov
     */
    public Integer getTipoMov() {
        return tipoMov;
    }

    /**
     * @param tipoMov the tipoMov to set
     */
    public void setTipoMov(Integer tipoMov) {
        this.tipoMov = tipoMov;
    }

    /**
     * @return Date return the FechaPosicion
     */
    public Date getFechaPosicion() {
        return FechaPosicion;
    }

    /**
     * @param FechaPosicion the FechaPosicion to set
     */
    public void setFechaPosicion(Date FechaPosicion) {
        this.FechaPosicion = FechaPosicion;
    }

    /**
     * @return Date return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return String return the Contenedor
     */
    public String getContenedor() {
        return Contenedor;
    }

    /**
     * @param Contenedor the Contenedor to set
     */
    public void setContenedor(String Contenedor) {
        this.Contenedor = Contenedor;
    }

    /**
     * @return String return the ncontenedor
     */
    public String getNcontenedor() {
        return ncontenedor;
    }

    /**
     * @param ncontenedor the ncontenedor to set
     */
    public void setNcontenedor(String ncontenedor) {
        this.ncontenedor = ncontenedor;
    }

    /**
     * @return String return the Tamano
     */
    public String getTamano() {
        return Tamano;
    }

    /**
     * @param Tamano the Tamano to set
     */
    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }

    /**
     * @return Integer return the EstadoCarga
     */
    public Integer getEstadoCarga() {
        return EstadoCarga;
    }

    /**
     * @param EstadoCarga the EstadoCarga to set
     */
    public void setEstadoCarga(Integer EstadoCarga) {
        this.EstadoCarga = EstadoCarga;
    }

    /**
     * @return String return the CusRef
     */
    public String getCusRef() {
        return CusRef;
    }

    /**
     * @param CusRef the CusRef to set
     */
    public void setCusRef(String CusRef) {
        this.CusRef = CusRef;
    }

    /**
     * @return String return the NumeroReservacion
     */
    public String getNumeroReservacion() {
        return NumeroReservacion;
    }

    /**
     * @param NumeroReservacion the NumeroReservacion to set
     */
    public void setNumeroReservacion(String NumeroReservacion) {
        this.NumeroReservacion = NumeroReservacion;
    }

    /**
     * @return Integer return the EdiID
     */
    public Integer getEdiID() {
        return EdiID;
    }

    /**
     * @param EdiID the EdiID to set
     */
    public void setEdiID(Integer EdiID) {
        this.EdiID = EdiID;
    }

    /**
     * @return Byte return the copiable
     */
    public Byte getCopiable() {
        return copiable;
    }

    /**
     * @param copiable the copiable to set
     */
    public void setCopiable(Byte copiable) {
        this.copiable = copiable;
    }

    /**
     * @return Integer return the navierafk
     */
    public Integer getNavierafk() {
        return navierafk;
    }

    /**
     * @param navierafk the navierafk to set
     */
    public void setNavierafk(Integer navierafk) {
        this.navierafk = navierafk;
    }

    /**
     * @return String return the navierawc
     */
    public String getNavierawc() {
        return navierawc;
    }

    /**
     * @param navierawc the navierawc to set
     */
    public void setNavierawc(String navierawc) {
        this.navierawc = navierawc;
    }

    /**
     * @return String return the buquewc
     */
    public String getBuquewc() {
        return buquewc;
    }

    /**
     * @param buquewc the buquewc to set
     */
    public void setBuquewc(String buquewc) {
        this.buquewc = buquewc;
    }

    /**
     * @return Integer return the prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return String return the FolioTE
     */
    public String getFolioTE() {
        return FolioTE;
    }

    /**
     * @param FolioTE the FolioTE to set
     */
    public void setFolioTE(String FolioTE) {
        this.FolioTE = FolioTE;
    }

    /**
     * @return Float return the PesoC
     */
    public Float getPesoC() {
        return PesoC;
    }

    /**
     * @param PesoC the PesoC to set
     */
    public void setPesoC(Float PesoC) {
        this.PesoC = PesoC;
    }

    /**
     * @return String return the BLwc
     */
    public String getBLwc() {
        return BLwc;
    }

    /**
     * @param BLwc the BLwc to set
     */
    public void setBLwc(String BLwc) {
        this.BLwc = BLwc;
    }

    /**
     * @return String return the PONumber
     */
    public String getPONumber() {
        return PONumber;
    }

    /**
     * @param PONumber the PONumber to set
     */
    public void setPONumber(String PONumber) {
        this.PONumber = PONumber;
    }

    /**
     * @return String return the inbond
     */
    public String getInbond() {
        return inbond;
    }

    /**
     * @param inbond the inbond to set
     */
    public void setInbond(String inbond) {
        this.inbond = inbond;
    }

    /**
     * @return Integer return the UsuarioID
     */
    public Integer getUsuarioID() {
        return UsuarioID;
    }

    /**
     * @param UsuarioID the UsuarioID to set
     */
    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    /**
     * @return String return the NotaInterna
     */
    public String getNotaInterna() {
        return NotaInterna;
    }

    /**
     * @param NotaInterna the NotaInterna to set
     */
    public void setNotaInterna(String NotaInterna) {
        this.NotaInterna = NotaInterna;
    }

    /**
     * @return String return the referenciaccp
     */
    public String getReferenciaccp() {
        return referenciaccp;
    }

    /**
     * @param referenciaccp the referenciaccp to set
     */
    public void setReferenciaccp(String referenciaccp) {
        this.referenciaccp = referenciaccp;
    }

    /**
     * @return Integer return the equipprovid
     */
    public Integer getEquipprovid() {
        return equipprovid;
    }

    /**
     * @param equipprovid the equipprovid to set
     */
    public void setEquipprovid(Integer equipprovid) {
        this.equipprovid = equipprovid;
    }

    /**
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.Status = Status;
    }

    /**
     * @return Integer return the Statusf
     */
    public Integer getStatusf() {
        return Statusf;
    }

    /**
     * @param Statusf the Statusf to set
     */
    public void setStatusf(Integer Statusf) {
        this.Statusf = Statusf;
    }

    /**
     * @return Date return the AppoimentDate
     */

    public LocalDateTime getAppoimentDate() {
        return AppoimentDate;
    }

    /**
     * @param AppoimentDate the AppoimentDate to set
     */
    public void setAppoimentDate(LocalDateTime AppoimentDate) {
        this.AppoimentDate = AppoimentDate;
    }

    /**
     * @return Date return the DeliveryDateReq
     */
    public LocalDateTime getDeliveryDateReq() {
        return DeliveryDateReq;
    }

    /**
     * @param DeliveryDateReq the DeliveryDateReq to set
     */
    public void setDeliveryDateReq(LocalDateTime DeliveryDateReq) {
        this.DeliveryDateReq = DeliveryDateReq;
    }

    // /**
    // * @return Date return the DeliveryDate
    // */
    // public Date getDeliveryDate() {
    // return DeliveryDate;
    // }

    // /**
    // * @param DeliveryDate the DeliveryDate to set
    // */
    // public void setDeliveryDate(Date DeliveryDate) {
    // this.DeliveryDate = DeliveryDate;
    // }

    /**
     * @return Byte return the cScale
     */
    public Byte getCScale() {
        return cScale;
    }

    /**
     * @param cScale the cScale to set
     */
    public void setCScale(Byte cScale) {
        this.cScale = cScale;
    }

    /**
     * @return Date return the LastFreeDay
     */
    public Date getLastFreeDay() {
        return LastFreeDay;
    }

    /**
     * @param LastFreeDay the LastFreeDay to set
     */
    public void setLastFreeDay(Date LastFreeDay) {
        this.LastFreeDay = LastFreeDay;
    }

    /**
     * @return String return the PlacasChasis
     */
    public String getPlacasChasis() {
        return PlacasChasis;
    }

    /**
     * @param PlacasChasis the PlacasChasis to set
     */
    public void setPlacasChasis(String PlacasChasis) {
        this.PlacasChasis = PlacasChasis;
    }

    /**
     * @return String return the EstadoPlacas
     */
    public String getEstadoPlacas() {
        return EstadoPlacas;
    }

    /**
     * @param EstadoPlacas the EstadoPlacas to set
     */
    public void setEstadoPlacas(String EstadoPlacas) {
        this.EstadoPlacas = EstadoPlacas;
    }

    /**
     * @return String return the NotaProgramacion
     */
    public String getNotaProgramacion() {
        return NotaProgramacion;
    }

    /**
     * @param NotaProgramacion the NotaProgramacion to set
     */
    public void setNotaProgramacion(String NotaProgramacion) {
        this.NotaProgramacion = NotaProgramacion;
    }

    /**
     * @return String return the NumeroSello
     */
    public String getNumeroSello() {
        return NumeroSello;
    }

    /**
     * @param NumeroSello the NumeroSello to set
     */
    public void setNumeroSello(String NumeroSello) {
        this.NumeroSello = NumeroSello;
    }

    /**
     * @return Date return the RFD
     */
    public Date getRFD() {
        return RFD;
    }

    /**
     * @param RFD the RFD to set
     */
    public void setRFD(Date RFD) {
        this.RFD = RFD;
    }

    /**
     * @return String return the AppNumber
     */
    public String getAppNumber() {
        return AppNumber;
    }

    /**
     * @param AppNumber the AppNumber to set
     */
    public void setAppNumber(String AppNumber) {
        this.AppNumber = AppNumber;
    }

    /**
     * @return Date return the OutPort
     */
    public Date getOutPort() {
        return OutPort;
    }

    /**
     * @param OutPort the OutPort to set
     */
    public void setOutPort(Date OutPort) {
        this.OutPort = OutPort;
    }

    /**
     * @return Date return the USArrDate
     */
    public Date getUSArrDate() {
        return USArrDate;
    }

    /**
     * @param USArrDate the USArrDate to set
     */
    public void setUSArrDate(Date USArrDate) {
        this.USArrDate = USArrDate;
    }

    /**
     * @return Date return the PUCliente
     */
    public Date getPUCliente() {
        return PUCliente;
    }

    /**
     * @param PUCliente the PUCliente to set
     */
    public void setPUCliente(Date PUCliente) {
        this.PUCliente = PUCliente;
    }

    /**
     * @return Float return the CobroCliente
     */
    public Float getCobroCliente() {
        return CobroCliente;
    }

    /**
     * @param CobroCliente the CobroCliente to set
     */
    public void setCobroCliente(Float CobroCliente) {
        this.CobroCliente = CobroCliente;
    }

    /**
     * @return Integer return the MonedaCliente
     */
    public Integer getMonedaCliente() {
        return MonedaCliente;
    }

    /**
     * @param MonedaCliente the MonedaCliente to set
     */
    public void setMonedaCliente(Integer MonedaCliente) {
        this.MonedaCliente = MonedaCliente;
    }

    /**
     * @return String return the cSubtipoRem
     */
    public String getCSubtipoRem() {
        return cSubtipoRem;
    }

    /**
     * @param cSubtipoRem the cSubtipoRem to set
     */
    public void setCSubtipoRem(String cSubtipoRem) {
        this.cSubtipoRem = cSubtipoRem;
    }

    /**
     * @return Integer return the WorkOrderID
     */
    public Integer getWorkOrderID() {
        return WorkOrderID;
    }

    /**
     * @param WorkOrderID the WorkOrderID to set
     */
    public void setWorkOrderID(Integer WorkOrderID) {
        this.WorkOrderID = WorkOrderID;
    }

    /**
     * @return Integer return the Cantidad
     */
    public Integer getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
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
     * @return Date return the AvDate
     */
    public Date getAvDate() {
        return AvDate;
    }

    /**
     * @param AvDate the AvDate to set
     */
    public void setAvDate(Date AvDate) {
        this.AvDate = AvDate;
    }

    /**
     * @return Integer return the camionfk
     */
    public Integer getCamionfk() {
        return camionfk;
    }

    /**
     * @param camionfk the camionfk to set
     */
    public void setCamionfk(Integer camionfk) {
        this.camionfk = camionfk;
    }

    /**
     * @return Integer return the choferfk
     */
    public Integer getChoferfk() {
        return choferfk;
    }

    /**
     * @param choferfk the choferfk to set
     */
    public void setChoferfk(Integer choferfk) {
        this.choferfk = choferfk;
    }

    /**
     * @return Integer return the choferfk
     */
    public Integer getCajaID() {
        return choferfk;
    }

    /**
     * @param cajaid the choferfk to set
     */
    public void setCajaID(Integer cajaid) {
        this.cajaid = cajaid;
    }
}
