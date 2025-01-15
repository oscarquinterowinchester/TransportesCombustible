package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "rutas_tbl")
public class RutasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RutaID")
    private Integer RutaID;

    @Column(name = "TarifaID")
    private Integer TarifaID;

    @Column(name = "Status")
    private Byte Status;

    private String nombre;
    private String origen;
    private String destino;
    private Float km;
    private Float viaticos; // a
    private Float casetas; // a
    private Float ltDiesel;
    private Integer ltGenerador;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private Integer moneda;
    private Integer monedaChofer;
    private Float viaticosUSD;
    private String nota;
    private String duracion;
    private Integer tipoRuta;
    private Integer cuentaID;
    private String contacto;
    private String codigo;
    private Integer tipoImpo;
    private Integer conceptoSATID;
    private String descripcionSAT;
    private Integer tipoTarifa;
    private Integer locacionPUID;
    private Integer locacionTOID;

    private Float costoServicio;
    private Float millasMX;
    private Integer clienteID;
    private Byte roundTrip;
    private Byte hazmat;
    private Integer usuarioMod;
    private Byte controlhoras;

    @Temporal(TemporalType.DATE)
    private Date fechaMod;

    private Integer tipoCruce;
    private Integer empresaCobroID;
    private Byte objimprt;
    private Integer ivart;
    private Integer ivaretrt;

    @Temporal(TemporalType.DATE)
    private String vigencia;

    private Integer empresaCCP;
    private Byte extrasJunto;
    private Byte aplicafsc;
    private Integer fscid;
    private Byte editable;
    private String comentario;

    // Getters and Setters

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
     * @return Integer return the TarifaID
     */
    public Integer getTarifaID() {
        return TarifaID;
    }

    /**
     * @param TarifaID the TarifaID to set
     */
    public void setTarifaID(Integer TarifaID) {
        this.TarifaID = TarifaID;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return String return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return Float return the km
     */
    public Float getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(Float km) {
        this.km = km;
    }

    /**
     * @return Float return the casetas
     */
    public Float getCasetas() {
        return casetas;
    }

    /**
     * @param casetas the casetas to set
     */
    public void setCasetas(Float casetas) {
        this.casetas = casetas;
    }

    /**
     * @return Float return the viaticos
     */
    public Float getViaticos() {
        return viaticos;
    }

    /**
     * @param viaticos the viaticos to set
     */
    public void setViaticos(Float viaticos) {
        this.viaticos = viaticos;
    }

    /**
     * @return Float return the ltDiesel
     */
    public Float getLtDiesel() {
        return ltDiesel;
    }

    /**
     * @param ltDiesel the ltDiesel to set
     */
    public void setLtDiesel(Float ltDiesel) {
        this.ltDiesel = ltDiesel;
    }

    /**
     * @return Integer return the ltGenerador
     */
    public Integer getLtGenerador() {
        return ltGenerador;
    }

    /**
     * @param ltGenerador the ltGenerador to set
     */
    public void setLtGenerador(Integer ltGenerador) {
        this.ltGenerador = ltGenerador;
    }

    /**
     * @return Date return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return Integer return the moneda
     */
    public Integer getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    /**
     * @return Integer return the monedaChofer
     */
    public Integer getMonedaChofer() {
        return monedaChofer;
    }

    /**
     * @param monedaChofer the monedaChofer to set
     */
    public void setMonedaChofer(Integer monedaChofer) {
        this.monedaChofer = monedaChofer;
    }

    /**
     * @return Float return the viaticosUSD
     */
    public Float getViaticosUSD() {
        return viaticosUSD;
    }

    /**
     * @param viaticosUSD the viaticosUSD to set
     */
    public void setViaticosUSD(Float viaticosUSD) {
        this.viaticosUSD = viaticosUSD;
    }

    /**
     * @return String return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return String return the duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * @return Integer return the tipoRuta
     */
    public Integer getTipoRuta() {
        return tipoRuta;
    }

    /**
     * @param tipoRuta the tipoRuta to set
     */
    public void setTipoRuta(Integer tipoRuta) {
        this.tipoRuta = tipoRuta;
    }

    /**
     * @return Integer return the cuentaID
     */
    public Integer getCuentaID() {
        return cuentaID;
    }

    /**
     * @param cuentaID the cuentaID to set
     */
    public void setCuentaID(Integer cuentaID) {
        this.cuentaID = cuentaID;
    }

    /**
     * @return String return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return String return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return Integer return the tipoImpo
     */
    public Integer getTipoImpo() {
        return tipoImpo;
    }

    /**
     * @param tipoImpo the tipoImpo to set
     */
    public void setTipoImpo(Integer tipoImpo) {
        this.tipoImpo = tipoImpo;
    }

    /**
     * @return Integer return the conceptoSATID
     */
    public Integer getConceptoSATID() {
        return conceptoSATID;
    }

    /**
     * @param conceptoSATID the conceptoSATID to set
     */
    public void setConceptoSATID(Integer conceptoSATID) {
        this.conceptoSATID = conceptoSATID;
    }

    /**
     * @return String return the descripcionSAT
     */
    public String getDescripcionSAT() {
        return descripcionSAT;
    }

    /**
     * @param descripcionSAT the descripcionSAT to set
     */
    public void setDescripcionSAT(String descripcionSAT) {
        this.descripcionSAT = descripcionSAT;
    }

    /**
     * @return Integer return the tipoTarifa
     */
    public Integer getTipoTarifa() {
        return tipoTarifa;
    }

    /**
     * @param tipoTarifa the tipoTarifa to set
     */
    public void setTipoTarifa(Integer tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    /**
     * @return Integer return the locacionPUID
     */
    public Integer getLocacionPUID() {
        return locacionPUID;
    }

    /**
     * @param locacionPUID the locacionPUID to set
     */
    public void setLocacionPUID(Integer locacionPUID) {
        this.locacionPUID = locacionPUID;
    }

    /**
     * @return Integer return the locacionTOID
     */
    public Integer getLocacionTOID() {
        return locacionTOID;
    }

    /**
     * @param locacionTOID the locacionTOID to set
     */
    public void setLocacionTOID(Integer locacionTOID) {
        this.locacionTOID = locacionTOID;
    }

    /**
     * @return Float return the costoServicio
     */
    public Float getCostoServicio() {
        return costoServicio;
    }

    /**
     * @param costoServicio the costoServicio to set
     */
    public void setCostoServicio(Float costoServicio) {
        this.costoServicio = costoServicio;
    }

    /**
     * @return Float return the millasMX
     */
    public Float getMillasMX() {
        return millasMX;
    }

    /**
     * @param millasMX the millasMX to set
     */
    public void setMillasMX(Float millasMX) {
        this.millasMX = millasMX;
    }

    /**
     * @return Integer return the clienteID
     */
    public Integer getClienteID() {
        return clienteID;
    }

    /**
     * @param clienteID the clienteID to set
     */
    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * @return Byte return the roundTrip
     */
    public Byte getRoundTrip() {
        return roundTrip;
    }

    /**
     * @param roundTrip the roundTrip to set
     */
    public void setRoundTrip(Byte roundTrip) {
        this.roundTrip = roundTrip;
    }

    /**
     * @return Byte return the hazmat
     */
    public Byte getHazmat() {
        return hazmat;
    }

    /**
     * @param hazmat the hazmat to set
     */
    public void setHazmat(Byte hazmat) {
        this.hazmat = hazmat;
    }

    /**
     * @return Integer return the usuarioMod
     */
    public Integer getUsuarioMod() {
        return usuarioMod;
    }

    /**
     * @param usuarioMod the usuarioMod to set
     */
    public void setUsuarioMod(Integer usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    /**
     * @return Date return the fechaMod
     */
    public Date getFechaMod() {
        return fechaMod;
    }

    /**
     * @param fechaMod the fechaMod to set
     */
    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    /**
     * @return Integer return the tipoCruce
     */
    public Integer getTipoCruce() {
        return tipoCruce;
    }

    /**
     * @param tipoCruce the tipoCruce to set
     */
    public void setTipoCruce(Integer tipoCruce) {
        this.tipoCruce = tipoCruce;
    }

    /**
     * @return Integer return the empresaCobroID
     */
    public Integer getEmpresaCobroID() {
        return empresaCobroID;
    }

    /**
     * @param empresaCobroID the empresaCobroID to set
     */
    public void setEmpresaCobroID(Integer empresaCobroID) {
        this.empresaCobroID = empresaCobroID;
    }

    /**
     * @return Byte return the objimprt
     */
    public Byte getObjimprt() {
        return objimprt;
    }

    /**
     * @param objimprt the objimprt to set
     */
    public void setObjimprt(Byte objimprt) {
        this.objimprt = objimprt;
    }

    /**
     * @return DecimalFormat return the ivart
     */
    public Integer getIvart() {
        return ivart;
    }

    /**
     * @param ivart the ivart to set
     */
    public void setIvart(Integer ivart) {
        this.ivart = ivart;
    }

    /**
     * @return DecimalFormat return the ivaretrt
     */
    public Integer getIvaretrt() {
        return ivaretrt;
    }

    /**
     * @param ivaretrt the ivaretrt to set
     */
    public void setIvaretrt(Integer ivaretrt) {
        this.ivaretrt = ivaretrt;
    }

    /**
     * @return String return the vigencia
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * @return Integer return the empresaCCP
     */
    public Integer getEmpresaCCP() {
        return empresaCCP;
    }

    /**
     * @param empresaCCP the empresaCCP to set
     */
    public void setEmpresaCCP(Integer empresaCCP) {
        this.empresaCCP = empresaCCP;
    }

    /**
     * @return Byte return the extrasJunto
     */
    public Byte getExtrasJunto() {
        return extrasJunto;
    }

    /**
     * @param extrasJunto the extrasJunto to set
     */
    public void setExtrasJunto(Byte extrasJunto) {
        this.extrasJunto = extrasJunto;
    }

    /**
     * @return Byte return the aplicafsc
     */
    public Byte getAplicafsc() {
        return aplicafsc;
    }

    /**
     * @param aplicafsc the aplicafsc to set
     */
    public void setAplicafsc(Byte aplicafsc) {
        this.aplicafsc = aplicafsc;
    }

    /**
     * @return Integer return the fscid
     */
    public Integer getFscid() {
        return fscid;
    }

    /**
     * @param fscid the fscid to set
     */
    public void setFscid(Integer fscid) {
        this.fscid = fscid;
    }

    /**
     * @return Byte return the editable
     */
    public Byte getEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(Byte editable) {
        this.editable = editable;
    }

    /**
     * @return String return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return Byte return the controlhoras
     */
    public Byte getControlhoras() {
        return controlhoras;
    }

    /**
     * @param controlhoras the controlhoras to set
     */
    public void setControlhoras(Byte controlhoras) {
        this.controlhoras = controlhoras;
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

}
