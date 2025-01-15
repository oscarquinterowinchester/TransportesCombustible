package com.appchoferes.nomina.models.durandb;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "icont_tbl")
public class IcontModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IcontID")
    private Integer icontID;

    @Column(name = "ItinerarioID")
    private Integer itinerarioID;

    @Column(name = "WorkID")
    private Integer workID;

    @Column(name = "BL")
    private String bl;

    @Column(name = "CajaID")
    private Integer cajaId;

    @Column(name = "Caja")
    private String caja;

    @Column(name = "ncontenedorid")
    private Integer nContenedorId;

    @Column(name = "ncontenedor")
    private String ncontenedor;

    @Column(name = "PlacasCaja")
    private String placasCaja;

    @Column(name = "LitrosDiesel")
    private Integer litrosDiesel;

    @Column(name = "DieselG")
    private Integer dieselG;

    @Column(name = "DollyID")
    private Integer dollyId;

    @Column(name = "DollyExterno")
    private String dollyExterno;

    @Column(name = "Generadorid")
    private Integer generadorId;

    @Column(name = "Generador")
    private String generador;

    @Column(name = "Sello")
    private Integer sello;

    @Column(name = "PagoSV")
    private Integer pagoSV;

    @Column(name = "MonedaChof")
    private Integer monedaChof;

    @Column(name = "Temperatura")
    private String temperatura;

    @Column(name = "Estado")
    private Integer estado;

    @Column(name = "Vuelta")
    private Integer vuelta;

    @Column(name = "TipoCont")
    private Integer tipoCont;

    @Column(name = "Peso")
    private String peso;

    @Column(name = "GuiaSalida")
    private String guiaSalida;

    @Column(name = "GuiaLLegada")
    private String guiaLlegada;

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "Status")
    private Byte Status;

    @Column(name = "Pickup")
    private String pickUp;

    @Column(name = "Pickup2")
    private String pickUp2;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "StatusAdmin")
    private Integer statusAdmin;
    
    @Column(name = "WContID")
    private Integer wContId;

    @Column(name = "Archivo")
    private String archivo;

    @Column(name = "Extension")
    private String extension;

    @Column(name = "Booking")
    private String booking;

    @Column(name = "UsuarioID")
    private Integer usuarioId;

    @Column(name = "VerificarOVMT")
    private Integer verificarOVMT;

    @Column(name = "EnFalso")
    private Integer enFalso;

    @Column(name = "VGM")
    private Integer vgm;

    @Column(name = "ReferenciaFacturacion")
    private String referenciaFacturacion;

    @Column(name = "Considerado")
    private Integer considerado;

    @Column(name = "SeleccionFactura")
    private Integer seleccionFactura;

    @Column(name = "UsuarioSeleccion")
    private Integer usuarioSeleccion;

    @Column(name = "FacturaConsiderado")
    private Integer facturaConsiderado;

    @Column(name = "FolioTO")
    private String folioTO;

    @Column(name = "FolioSB")
    private String folioSB;

    public Integer getIcontID() {
        return icontID;
    }

    public void setIcontID(Integer icontID) {
        this.icontID = icontID;
    }

    public Integer getItinerarioID() {
        return itinerarioID;
    }

    public void setItinerarioID(Integer itinerarioID) {
        this.itinerarioID = itinerarioID;
    }

    public Integer getWorkID() {
        return workID;
    }

    public void setWorkID(Integer workID) {
        this.workID = workID;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public Integer getCajaId() {
        return cajaId;
    }

    public void setCajaId(Integer cajaId) {
        this.cajaId = cajaId;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public Integer getnContenedorId() {
        return nContenedorId;
    }

    public void setnContenedorId(Integer nContenedorId) {
        this.nContenedorId = nContenedorId;
    }

    public String getNcontenedor() {
        return ncontenedor;
    }

    public void setNcontenedor(String ncontenedor) {
        this.ncontenedor = ncontenedor;
    }

    public String getPlacasCaja() {
        return placasCaja;
    }

    public void setPlacasCaja(String placasCaja) {
        this.placasCaja = placasCaja;
    }

    public Integer getLitrosDiesel() {
        return litrosDiesel;
    }

    public void setLitrosDiesel(Integer litrosDiesel) {
        this.litrosDiesel = litrosDiesel;
    }

    public Integer getDieselG() {
        return dieselG;
    }

    public void setDieselG(Integer dieselG) {
        this.dieselG = dieselG;
    }

    public Integer getDollyId() {
        return dollyId;
    }

    public void setDollyId(Integer dollyId) {
        this.dollyId = dollyId;
    }

    public String getDollyExterno() {
        return dollyExterno;
    }

    public void setDollyExterno(String dollyExterno) {
        this.dollyExterno = dollyExterno;
    }

    public Integer getGeneradorId() {
        return generadorId;
    }

    public void setGeneradorId(Integer generadorId) {
        this.generadorId = generadorId;
    }

    public String getGenerador() {
        return generador;
    }

    public void setGenerador(String generador) {
        this.generador = generador;
    }

    public Integer getSello() {
        return sello;
    }

    public void setSello(Integer sello) {
        this.sello = sello;
    }

    public Integer getPagoSV() {
        return pagoSV;
    }

    public void setPagoSV(Integer pagoSV) {
        this.pagoSV = pagoSV;
    }

    public Integer getMonedaChof() {
        return monedaChof;
    }

    public void setMonedaChof(Integer monedaChof) {
        this.monedaChof = monedaChof;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getVuelta() {
        return vuelta;
    }

    public void setVuelta(Integer vuelta) {
        this.vuelta = vuelta;
    }

    public Integer getTipoCont() {
        return tipoCont;
    }

    public void setTipoCont(Integer tipoCont) {
        this.tipoCont = tipoCont;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGuiaSalida() {
        return guiaSalida;
    }

    public void setGuiaSalida(String guiaSalida) {
        this.guiaSalida = guiaSalida;
    }

    public String getGuiaLlegada() {
        return guiaLlegada;
    }

    public void setGuiaLlegada(String guiaLlegada) {
        this.guiaLlegada = guiaLlegada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Byte getStatus() {
        return Status;
    }

    public void setStatus(Byte status) {
        Status = status;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getPickUp2() {
        return pickUp2;
    }

    public void setPickUp2(String pickUp2) {
        this.pickUp2 = pickUp2;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getStatusAdmin() {
        return statusAdmin;
    }

    public void setStatusAdmin(Integer statusAdmin) {
        this.statusAdmin = statusAdmin;
    }

    public Integer getwContId() {
        return wContId;
    }

    public void setwContId(Integer wContId) {
        this.wContId = wContId;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getVerificarOVMT() {
        return verificarOVMT;
    }

    public void setVerificarOVMT(Integer verificarOVMT) {
        this.verificarOVMT = verificarOVMT;
    }

    public Integer getEnFalso() {
        return enFalso;
    }

    public void setEnFalso(Integer enFalso) {
        this.enFalso = enFalso;
    }

    public Integer getVgm() {
        return vgm;
    }

    public void setVgm(Integer vgm) {
        this.vgm = vgm;
    }

    public String getReferenciaFacturacion() {
        return referenciaFacturacion;
    }

    public void setReferenciaFacturacion(String referenciaFacturacion) {
        this.referenciaFacturacion = referenciaFacturacion;
    }

    public Integer getConsiderado() {
        return considerado;
    }

    public void setConsiderado(Integer considerado) {
        this.considerado = considerado;
    }

    public Integer getSeleccionFactura() {
        return seleccionFactura;
    }

    public void setSeleccionFactura(Integer seleccionFactura) {
        this.seleccionFactura = seleccionFactura;
    }

    public Integer getUsuarioSeleccion() {
        return usuarioSeleccion;
    }

    public void setUsuarioSeleccion(Integer usuarioSeleccion) {
        this.usuarioSeleccion = usuarioSeleccion;
    }

    public Integer getFacturaConsiderado() {
        return facturaConsiderado;
    }

    public void setFacturaConsiderado(Integer facturaConsiderado) {
        this.facturaConsiderado = facturaConsiderado;
    }

    public String getFolioTO() {
        return folioTO;
    }

    public void setFolioTO(String folioTO) {
        this.folioTO = folioTO;
    }

    public String getFolioSB() {
        return folioSB;
    }

    public void setFolioSB(String folioSB) {
        this.folioSB = folioSB;
    }

    
}
