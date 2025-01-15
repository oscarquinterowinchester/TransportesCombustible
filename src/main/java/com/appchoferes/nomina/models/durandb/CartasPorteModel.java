package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cartasporte_tbl")
public class CartasPorteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartaPorteID")
    private Integer cartaPorteID;

    @Column(name = "ClienteID")
    private Integer ClienteID;

    @Column(name = "NoCartaPorte")
    private String NoCartaPorte;

    @Column(name = "Seriecp")
    private String Seriecp;

    @Column(name = "Foliocp")
    private Integer Foliocp;

    @Column(name = "FolioFiscalcp")
    private String FolioFiscalcp;

    @Column(name = "GeneracionCartaPorte")
    private Integer generacionCartaPorte;

    @Column(name = "NotaCartaPorte")
    private String NotaCartaPorte;

    @Column(name = "UsuarioFK")
    private Integer UsuarioFK;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Monedacp")
    private Integer Monedacp;

    @Column(name = "UsoCFDI")
    private String UsoCFDI;

    @Column(name = "TipoComprobante")
    private String TipoComprobante;

    @Column(name = "TipoCambio")
    private Float TipoCambio;

    @Column(name = "transaccion")
    private String transaccion;

    @Column(name = "FormaPago")
    private String FormaPago;

    @Column(name = "MetodoPago")
    private String MetodoPago;

    @Column(name = "CondicionPago")
    private String CondicionPago;

    @Column(name = "EmpresaID")
    private Integer EmpresaID;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaVencimiento")
    private Date FechaVencimiento;

    @Column(name = "versiontimbre")
    private Integer versiontimbre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaRegistro")
    private Date fechaRegistro;

    @Column(name = "RegimenAduanero")
    private String RegimenAduanero;

    @Column(name = "CodigoMotivo")
    private String CodigoMotivo;

    @Column(name = "MensajeRevision")
    private String MensajeRevision;

    @Column(name = "Cancelar")
    private Integer Cancelar;

    @Column(name = "FacturaFK")
    private Integer FacturaFK;

    @Column(name = "NotaCP")
    private String NotaCP;

    @Column(name = "versionCCP")
    private Integer versionCCP;

    // Getters and setters

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
     * @return Integer return the ClienteID
     */
    public Integer getClienteID() {
        return ClienteID;
    }

    /**
     * @param ClienteID the ClienteID to set
     */
    public void setClienteID(Integer ClienteID) {
        this.ClienteID = ClienteID;
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
     * @return String return the Seriecp
     */
    public String getSeriecp() {
        return Seriecp;
    }

    /**
     * @param Seriecp the Seriecp to set
     */
    public void setSeriecp(String Seriecp) {
        this.Seriecp = Seriecp;
    }

    /**
     * @return Integer return the Foliocp
     */
    public Integer getFoliocp() {
        return Foliocp;
    }

    /**
     * @param Foliocp the Foliocp to set
     */
    public void setFoliocp(Integer Foliocp) {
        this.Foliocp = Foliocp;
    }

    /**
     * @return String return the FolioFiscalcp
     */
    public String getFolioFiscalcp() {
        return FolioFiscalcp;
    }

    /**
     * @param FolioFiscalcp the FolioFiscalcp to set
     */
    public void setFolioFiscalcp(String FolioFiscalcp) {
        this.FolioFiscalcp = FolioFiscalcp;
    }

    /**
     * @return Integer return the GeneracionCartaPorte
     */
    public Integer getGeneracionCartaPorte() {
        return generacionCartaPorte;
    }

    /**
     * @param GeneracionCartaPorte the GeneracionCartaPorte to set
     */
    public void setGeneracionCartaPorte(Integer GeneracionCartaPorte) {
        this.generacionCartaPorte = GeneracionCartaPorte;
    }

    /**
     * @return String return the NotaCartaPorte
     */
    public String getNotaCartaPorte() {
        return NotaCartaPorte;
    }

    /**
     * @param NotaCartaPorte the NotaCartaPorte to set
     */
    public void setNotaCartaPorte(String NotaCartaPorte) {
        this.NotaCartaPorte = NotaCartaPorte;
    }

    /**
     * @return Integer return the UsuarioFK
     */
    public Integer getUsuarioFK() {
        return UsuarioFK;
    }

    /**
     * @param UsuarioFK the UsuarioFK to set
     */
    public void setUsuarioFK(Integer UsuarioFK) {
        this.UsuarioFK = UsuarioFK;
    }

    /**
     * @return Integer return the Status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return Integer return the Monedacp
     */
    public Integer getMonedacp() {
        return Monedacp;
    }

    /**
     * @param Monedacp the Monedacp to set
     */
    public void setMonedacp(Integer Monedacp) {
        this.Monedacp = Monedacp;
    }

    /**
     * @return String return the UsoCFDI
     */
    public String getUsoCFDI() {
        return UsoCFDI;
    }

    /**
     * @param UsoCFDI the UsoCFDI to set
     */
    public void setUsoCFDI(String UsoCFDI) {
        this.UsoCFDI = UsoCFDI;
    }

    /**
     * @return String return the TipoComprobante
     */
    public String getTipoComprobante() {
        return TipoComprobante;
    }

    /**
     * @param TipoComprobante the TipoComprobante to set
     */
    public void setTipoComprobante(String TipoComprobante) {
        this.TipoComprobante = TipoComprobante;
    }

    /**
     * @return Float return the TipoCambio
     */
    public Float getTipoCambio() {
        return TipoCambio;
    }

    /**
     * @param TipoCambio the TipoCambio to set
     */
    public void setTipoCambio(Float TipoCambio) {
        this.TipoCambio = TipoCambio;
    }

    /**
     * @return String return the FormaPago
     */
    public String getFormaPago() {
        return FormaPago;
    }

    /**
     * @param FormaPago the FormaPago to set
     */
    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    /**
     * @return String return the MetodoPago
     */
    public String getMetodoPago() {
        return MetodoPago;
    }

    /**
     * @param MetodoPago the MetodoPago to set
     */
    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    /**
     * @return String return the CondicionPago
     */
    public String getCondicionPago() {
        return CondicionPago;
    }

    /**
     * @param CondicionPago the CondicionPago to set
     */
    public void setCondicionPago(String CondicionPago) {
        this.CondicionPago = CondicionPago;
    }

    /**
     * @return Integer return the EmpresaID
     */
    public Integer getEmpresaID() {
        return EmpresaID;
    }

    /**
     * @param EmpresaID the EmpresaID to set
     */
    public void setEmpresaID(Integer EmpresaID) {
        this.EmpresaID = EmpresaID;
    }

    /**
     * @return Date return the FechaVencimiento
     */
    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    /**
     * @param FechaVencimiento the FechaVencimiento to set
     */
    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    /**
     * @return Integer return the versiontimbre
     */
    public Integer getVersiontimbre() {
        return versiontimbre;
    }

    /**
     * @param versiontimbre the versiontimbre to set
     */
    public void setVersiontimbre(Integer versiontimbre) {
        this.versiontimbre = versiontimbre;
    }

    /**
     * @return Date return the FechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param FechaRegistro the FechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return String return the RegimenAduanero
     */
    public String getRegimenAduanero() {
        return RegimenAduanero;
    }

    /**
     * @param RegimenAduanero the RegimenAduanero to set
     */
    public void setRegimenAduanero(String RegimenAduanero) {
        this.RegimenAduanero = RegimenAduanero;
    }

    /**
     * @return String return the CodigoMotivo
     */
    public String getCodigoMotivo() {
        return CodigoMotivo;
    }

    /**
     * @param CodigoMotivo the CodigoMotivo to set
     */
    public void setCodigoMotivo(String CodigoMotivo) {
        this.CodigoMotivo = CodigoMotivo;
    }

    /**
     * @return String return the MensajeRevision
     */
    public String getMensajeRevision() {
        return MensajeRevision;
    }

    /**
     * @param MensajeRevision the MensajeRevision to set
     */
    public void setMensajeRevision(String MensajeRevision) {
        this.MensajeRevision = MensajeRevision;
    }

    /**
     * @return Integer return the Cancelar
     */
    public Integer getCancelar() {
        return Cancelar;
    }

    /**
     * @param Cancelar the Cancelar to set
     */
    public void setCancelar(Integer Cancelar) {
        this.Cancelar = Cancelar;
    }

    /**
     * @return Integer return the FacturaFK
     */
    public Integer getFacturaFK() {
        return FacturaFK;
    }

    /**
     * @param FacturaFK the FacturaFK to set
     */
    public void setFacturaFK(Integer FacturaFK) {
        this.FacturaFK = FacturaFK;
    }

    /**
     * @return String return the NotaCP
     */
    public String getNotaCP() {
        return NotaCP;
    }

    /**
     * @param NotaCP the NotaCP to set
     */
    public void setNotaCP(String NotaCP) {
        this.NotaCP = NotaCP;
    }

    /**
     * @return Integer return the versionCCP
     */
    public Integer getVersionCCP() {
        return versionCCP;
    }

    /**
     * @param versionCCP the versionCCP to set
     */
    public void setVersionCCP(Integer versionCCP) {
        this.versionCCP = versionCCP;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    
}
