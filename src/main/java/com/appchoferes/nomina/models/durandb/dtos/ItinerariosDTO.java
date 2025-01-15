package com.appchoferes.nomina.models.durandb.dtos;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "itinerarios_tbl")
public class ItinerariosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItinerarioID")
    private Integer ItinerarioID;

    @Column(name = "RutaID")
    private Integer RutaID;

    @Column(name = "ChoferID")
    private Integer ChoferID;

    @Column(name = "CamionID")
    private Integer CamionID;

    @Column(name = "CajaID")
    private Integer CajaID;

    @Column(name = "Nota")
    private String Nota;

    @Column(name = "Caja")
    private String Caja;

    @Column(name = "Mercancia")
    private String Mercancia;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Fecha")
    private LocalDateTime Fecha;

    @Column(name = "PagodelCliente")
    private Float PagodelCliente;

    @Column(name = "PagoSV")
    private Float PagoSV;

    @Column(name = "PagoSC")
    private Float PagoSC;

    @Column(name = "PagoRV")
    private Float PagoRV;

    @Column(name = "PagoRC")
    private Float PagoRC;

    @Column(name = "MonedaCliente")
    private Integer MonedaCliente;

    @Column(name = "MonedaChofer")
    private Integer MonedaChofer;

    @Column(name = "Carga")
    private LocalDateTime Carga;

    @Column(name = "Viaticos")
    private Float Viaticos;

    @Column(name = "ViaticosUSD")
    private Float ViaticosUSD;

    @Column(name = "CantidadSellos")
    private Integer CantidadSellos;

    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "EstadoOrden")
    private Integer EstadoOrden;

    @Column(name = "ProgramacionID")
    private Integer ProgramacionID;

    @Column(name = "WcontFK")
    private Integer WcontFK;

    @Column(name = "StatusMov")
    private Integer StatusMov;

    @Column(name = "TipoContFK")
    private Integer TipoContFK;

    @Column(name = "ClienteSerID")
    private Integer ClienteSerID;

    @Column(name = "LocacionOrigenID")
    private Integer LocacionOrigenID;

    @Column(name = "Fuente")
    private Integer Fuente;

    @Column(name = "Estado")
    private Integer Estado;

    @Column(name = "TipoOperacion")
    private Integer TipoOperacion;

    @Column(name = "externalid")
    private String externalid;

    @Column(name = "UsuarioDocs")
    private Integer UsuarioDocs;

    @Column(name = "FechaDocs")
    private LocalDateTime FechaDocs;

    @Column(name = "CusRef")
    private String CusRef;

    // Gettes and setters

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
     * @return Integer return the ChoferID
     */
    public Integer getChoferID() {
        return ChoferID;
    }

    /**
     * @param ChoferID the ChoferID to set
     */
    public void setChoferID(Integer ChoferID) {
        this.ChoferID = ChoferID;
    }

    /**
     * @return Integer return the CamionID
     */
    public Integer getCamionID() {
        return CamionID;
    }

    /**
     * @param CamionID the CamionID to set
     */
    public void setCamionID(Integer CamionID) {
        this.CamionID = CamionID;
    }

    /**
     * @return Integer return the CajaID
     */
    public Integer getCajaID() {
        return CajaID;
    }

    /**
     * @param CajaID the CajaID to set
     */
    public void setCajaID(Integer CajaID) {
        this.CajaID = CajaID;
    }

    /**
     * @return String return the Nota
     */
    public String getNota() {
        return Nota;
    }

    /**
     * @param Nota the Nota to set
     */
    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    /**
     * @return String return the Caja
     */
    public String getCaja() {
        return Caja;
    }

    /**
     * @param Caja the Caja to set
     */
    public void setCaja(String Caja) {
        this.Caja = Caja;
    }

    /**
     * @return String return the Mercancia
     */
    public String getMercancia() {
        return Mercancia;
    }

    /**
     * @param Mercancia the Mercancia to set
     */
    public void setMercancia(String Mercancia) {
        this.Mercancia = Mercancia;
    }

    /**
     * @return Integer return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return LocalDateTime return the Fecha
     */
    public LocalDateTime getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return Float return the PagodelCliente
     */
    public Float getPagodelCliente() {
        return PagodelCliente;
    }

    /**
     * @param PagodelCliente the PagodelCliente to set
     */
    public void setPagodelCliente(Float PagodelCliente) {
        this.PagodelCliente = PagodelCliente;
    }

    /**
     * @return Float return the PagoSV
     */
    public Float getPagoSV() {
        return PagoSV;
    }

    /**
     * @param PagoSV the PagoSV to set
     */
    public void setPagoSV(Float PagoSV) {
        this.PagoSV = PagoSV;
    }

    /**
     * @return Float return the PagoSC
     */
    public Float getPagoSC() {
        return PagoSC;
    }

    /**
     * @param PagoSC the PagoSC to set
     */
    public void setPagoSC(Float PagoSC) {
        this.PagoSC = PagoSC;
    }

    /**
     * @return Float return the PagoRV
     */
    public Float getPagoRV() {
        return PagoRV;
    }

    /**
     * @param PagoRV the PagoRV to set
     */
    public void setPagoRV(Float PagoRV) {
        this.PagoRV = PagoRV;
    }

    /**
     * @return Float return the PagoRC
     */
    public Float getPagoRC() {
        return PagoRC;
    }

    /**
     * @param PagoRC the PagoRC to set
     */
    public void setPagoRC(Float PagoRC) {
        this.PagoRC = PagoRC;
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
     * @return Integer return the MonedaChofer
     */
    public Integer getMonedaChofer() {
        return MonedaChofer;
    }

    /**
     * @param MonedaChofer the MonedaChofer to set
     */
    public void setMonedaChofer(Integer MonedaChofer) {
        this.MonedaChofer = MonedaChofer;
    }

    /**
     * @return LocalDateTime return the Carga
     */
    public LocalDateTime getCarga() {
        return Carga;
    }

    /**
     * @param Carga the Carga to set
     */
    public void setCarga(LocalDateTime Carga) {
        this.Carga = Carga;
    }

    /**
     * @return Float return the Viaticos
     */
    public Float getViaticos() {
        return Viaticos;
    }

    /**
     * @param Viaticos the Viaticos to set
     */
    public void setViaticos(Float Viaticos) {
        this.Viaticos = Viaticos;
    }

    /**
     * @return Float return the ViaticosUSD
     */
    public Float getViaticosUSD() {
        return ViaticosUSD;
    }

    /**
     * @param ViaticosUSD the ViaticosUSD to set
     */
    public void setViaticosUSD(Float ViaticosUSD) {
        this.ViaticosUSD = ViaticosUSD;
    }

    /**
     * @return Integer return the CantidadSellos
     */
    public Integer getCantidadSellos() {
        return CantidadSellos;
    }

    /**
     * @param CantidadSellos the CantidadSellos to set
     */
    public void setCantidadSellos(Integer CantidadSellos) {
        this.CantidadSellos = CantidadSellos;
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
     * @return Integer return the EstadoOrden
     */
    public Integer getEstadoOrden() {
        return EstadoOrden;
    }

    /**
     * @param EstadoOrden the EstadoOrden to set
     */
    public void setEstadoOrden(Integer EstadoOrden) {
        this.EstadoOrden = EstadoOrden;
    }

    /**
     * @return Integer return the ProgramacionID
     */
    public Integer getProgramacionID() {
        return ProgramacionID;
    }

    /**
     * @param ProgramacionID the ProgramacionID to set
     */
    public void setProgramacionID(Integer ProgramacionID) {
        this.ProgramacionID = ProgramacionID;
    }

    /**
     * @return Integer return the WcontFK
     */
    public Integer getWcontFK() {
        return WcontFK;
    }

    /**
     * @param WcontFK the WcontFK to set
     */
    public void setWcontFK(Integer WcontFK) {
        this.WcontFK = WcontFK;
    }

    /**
     * @return Integer return the StatusMov
     */
    public Integer getStatusMov() {
        return StatusMov;
    }

    /**
     * @param StatusMov the StatusMov to set
     */
    public void setStatusMov(Integer StatusMov) {
        this.StatusMov = StatusMov;
    }

    /**
     * @return Integer return the TipoContFK
     */
    public Integer getTipoContFK() {
        return TipoContFK;
    }

    /**
     * @param TipoContFK the TipoContFK to set
     */
    public void setTipoContFK(Integer TipoContFK) {
        this.TipoContFK = TipoContFK;
    }

    /**
     * @return Integer return the ClienteSerID
     */
    public Integer getClienteSerID() {
        return ClienteSerID;
    }

    /**
     * @param ClienteSerID the ClienteSerID to set
     */
    public void setClienteSerID(Integer ClienteSerID) {
        this.ClienteSerID = ClienteSerID;
    }

    /**
     * @return Integer return the LocacionOrigenID
     */
    public Integer getLocacionOrigenID() {
        return LocacionOrigenID;
    }

    /**
     * @param LocacionOrigenID the LocacionOrigenID to set
     */
    public void setLocacionOrigenID(Integer LocacionOrigenID) {
        this.LocacionOrigenID = LocacionOrigenID;
    }

    /**
     * @return Integer return the Fuente
     */
    public Integer getFuente() {
        return Fuente;
    }

    /**
     * @param Fuente the Fuente to set
     */
    public void setFuente(Integer Fuente) {
        this.Fuente = Fuente;
    }

    /**
     * @return Integer return the Estado
     */
    public Integer getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(Integer Estado) {
        this.Estado = Estado;
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
     * @return String return the externalid
     */
    public String getExternalid() {
        return externalid;
    }

    /**
     * @param externalid the externalid to set
     */
    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    /**
     * @return Integer return the UsuarioDocs
     */
    public Integer getUsuarioDocs() {
        return UsuarioDocs;
    }

    /**
     * @param UsuarioDocs the UsuarioDocs to set
     */
    public void setUsuarioDocs(Integer UsuarioDocs) {
        this.UsuarioDocs = UsuarioDocs;
    }

    /**
     * @return LocalDateTime return the FechaDocs
     */
    public LocalDateTime getFechaDocs() {
        return FechaDocs;
    }

    /**
     * @param FechaDocs the FechaDocs to set
     */
    public void setFechaDocs(LocalDateTime FechaDocs) {
        this.FechaDocs = FechaDocs;
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

}
