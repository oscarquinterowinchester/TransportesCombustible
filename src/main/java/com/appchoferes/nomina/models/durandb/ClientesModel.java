package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_tbl")
public class ClientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienteID")
    private Integer proveedorID;

    @Column(name = "RazonSocial")
    private String RazonSocial;

    private Integer UsuarioID;
    private String CodigoC;
    private String NComercial;
    private String NombreComercial;
    private String RFC;
    private String CP;
    private Integer MesesCTPAT;
    private String Telefono;
    private String Estado;
    private String Pais;
    private String Correo;
    private Integer DiasCredito;
    private Float LimiteCredito;
    private String Moneda;

    @Temporal(TemporalType.DATE)
    private Date Fecha;

    private String Contacto;
    private Integer FolioContpaq;
    private String NombreComun;
    private Integer TipoCliente;
    private Byte CTPAT;
    private String Banco;
    private String NoCuenta;
    private Integer CuentaID;
    private String CPF;
    private String EstadoF;
    private String PaisF;
    private String ContactoF;
    private String ContactoF1;
    private String TelefonoF;
    private String TelefonoF1;
    private String CorreoF;
    private String CorreoF1;
    private String ContactoT;
    private String ContactoT1;
    private String ContactoT2;
    private String TelefonoT;
    private String TelefonoT1;
    private String TelefonoT2;
    private String CorreoT;
    private String CorreoT1;
    private String CorreoT2;
    private String Beneficiario;
    private String ClaveInter;
    private String Swift;
    private Integer DiasRFD;
    private Integer TipoDiasRFD;
    private Integer DiasCFD;
    private Integer TipoDiasCFD;
    private String RFCBanco;
    private String Direccion;
    private String DireccionF;
    private Integer DiasSinFactura;
    private Integer TotalContenedoresVencidos;
    private Integer ContenedoresPorDia;
    private Integer ContenedoresFacturadosDiarios;
    private Integer ContenedoresNoFacturadosDiarios;
    private Integer TipoFac;
    private Integer UNegocioID;
    private String correoHoras;
    private Byte correoEnviar;
    private String CorreoInventario;
    private String CiudadF;
    private String Ciudad;
    private String CTPATID;
    private Byte InfoPendiente;
    @Column(name = "Status")
    private Byte status;

    private Byte Importacion;
    private Byte Exportacion;
    private Byte OEA;
    private Byte AutoBill;
    private Byte Inactivo;
    private String ComentarioInactivo;
    private String NombreQB;
    private Byte correoClient;
    private Byte correoEProvider;
    private Integer UsuarioMod;

    @Temporal(TemporalType.DATE)
    private Date FechaMod;

    private Byte MostrarExternos;
    private Byte equipmentprovider;
    private Byte emptyx;
    private Byte loadx;
    private String usuario;
    private String clave;
    private String NombrewsMerca;
    private String RegimenFiscal;
    private String RegimenCapital;
    private Integer versiontimbre;
    private String comentario;
    private String UsoCFDIc;
    private String MetodoPagoc;
    private String FormaPagoc;
    private String CondicionPagoc;
    private String NotaFacturac;
    private Integer versionCCP;

    // Getters and Setters

    /**
     * @return Integer return the proveedorID
     */
    public Integer getProveedorID() {
        return proveedorID;
    }

    /**
     * @param proveedorID the proveedorID to set
     */
    public void setProveedorID(Integer proveedorID) {
        this.proveedorID = proveedorID;
    }

    /**
     * @return String return the RazonSocial
     */
    public String getRazonSocial() {
        return RazonSocial;
    }

    /**
     * @param RazonSocial the RazonSocial to set
     */
    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
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
     * @return String return the CodigoC
     */
    public String getCodigoC() {
        return CodigoC;
    }

    /**
     * @param CodigoC the CodigoC to set
     */
    public void setCodigoC(String CodigoC) {
        this.CodigoC = CodigoC;
    }

    /**
     * @return String return the NComercial
     */
    public String getNComercial() {
        return NComercial;
    }

    /**
     * @param NComercial the NComercial to set
     */
    public void setNComercial(String NComercial) {
        this.NComercial = NComercial;
    }

    /**
     * @return String return the NombreComercial
     */
    public String getNombreComercial() {
        return NombreComercial;
    }

    /**
     * @param NombreComercial the NombreComercial to set
     */
    public void setNombreComercial(String NombreComercial) {
        this.NombreComercial = NombreComercial;
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

    /**
     * @return Integer return the MesesCTPAT
     */
    public Integer getMesesCTPAT() {
        return MesesCTPAT;
    }

    /**
     * @param MesesCTPAT the MesesCTPAT to set
     */
    public void setMesesCTPAT(Integer MesesCTPAT) {
        this.MesesCTPAT = MesesCTPAT;
    }

    /**
     * @return String return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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
     * @return String return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return Integer return the DiasCredito
     */
    public Integer getDiasCredito() {
        return DiasCredito;
    }

    /**
     * @param DiasCredito the DiasCredito to set
     */
    public void setDiasCredito(Integer DiasCredito) {
        this.DiasCredito = DiasCredito;
    }

    /**
     * @return Float return the LimiteCredito
     */
    public Float getLimiteCredito() {
        return LimiteCredito;
    }

    /**
     * @param LimiteCredito the LimiteCredito to set
     */
    public void setLimiteCredito(Float LimiteCredito) {
        this.LimiteCredito = LimiteCredito;
    }

    /**
     * @return String return the Moneda
     */
    public String getMoneda() {
        return Moneda;
    }

    /**
     * @param Moneda the Moneda to set
     */
    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
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
     * @return String return the Contacto
     */
    public String getContacto() {
        return Contacto;
    }

    /**
     * @param Contacto the Contacto to set
     */
    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    /**
     * @return Integer return the FolioContpaq
     */
    public Integer getFolioContpaq() {
        return FolioContpaq;
    }

    /**
     * @param FolioContpaq the FolioContpaq to set
     */
    public void setFolioContpaq(Integer FolioContpaq) {
        this.FolioContpaq = FolioContpaq;
    }

    /**
     * @return String return the NombreComun
     */
    public String getNombreComun() {
        return NombreComun;
    }

    /**
     * @param NombreComun the NombreComun to set
     */
    public void setNombreComun(String NombreComun) {
        this.NombreComun = NombreComun;
    }

    /**
     * @return Integer return the TipoCliente
     */
    public Integer getTipoCliente() {
        return TipoCliente;
    }

    /**
     * @param TipoCliente the TipoCliente to set
     */
    public void setTipoCliente(Integer TipoCliente) {
        this.TipoCliente = TipoCliente;
    }

    /**
     * @return Byte return the CTPAT
     */
    public Byte getCTPAT() {
        return CTPAT;
    }

    /**
     * @param CTPAT the CTPAT to set
     */
    public void setCTPAT(Byte CTPAT) {
        this.CTPAT = CTPAT;
    }

    /**
     * @return String return the Banco
     */
    public String getBanco() {
        return Banco;
    }

    /**
     * @param Banco the Banco to set
     */
    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    /**
     * @return String return the NoCuenta
     */
    public String getNoCuenta() {
        return NoCuenta;
    }

    /**
     * @param NoCuenta the NoCuenta to set
     */
    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    /**
     * @return Integer return the CuentaID
     */
    public Integer getCuentaID() {
        return CuentaID;
    }

    /**
     * @param CuentaID the CuentaID to set
     */
    public void setCuentaID(Integer CuentaID) {
        this.CuentaID = CuentaID;
    }

    /**
     * @return String return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return String return the EstadoF
     */
    public String getEstadoF() {
        return EstadoF;
    }

    /**
     * @param EstadoF the EstadoF to set
     */
    public void setEstadoF(String EstadoF) {
        this.EstadoF = EstadoF;
    }

    /**
     * @return String return the PaisF
     */
    public String getPaisF() {
        return PaisF;
    }

    /**
     * @param PaisF the PaisF to set
     */
    public void setPaisF(String PaisF) {
        this.PaisF = PaisF;
    }

    /**
     * @return String return the ContactoF
     */
    public String getContactoF() {
        return ContactoF;
    }

    /**
     * @param ContactoF the ContactoF to set
     */
    public void setContactoF(String ContactoF) {
        this.ContactoF = ContactoF;
    }

    /**
     * @return String return the ContactoF1
     */
    public String getContactoF1() {
        return ContactoF1;
    }

    /**
     * @param ContactoF1 the ContactoF1 to set
     */
    public void setContactoF1(String ContactoF1) {
        this.ContactoF1 = ContactoF1;
    }

    /**
     * @return String return the TelefonoF
     */
    public String getTelefonoF() {
        return TelefonoF;
    }

    /**
     * @param TelefonoF the TelefonoF to set
     */
    public void setTelefonoF(String TelefonoF) {
        this.TelefonoF = TelefonoF;
    }

    /**
     * @return String return the TelefonoF1
     */
    public String getTelefonoF1() {
        return TelefonoF1;
    }

    /**
     * @param TelefonoF1 the TelefonoF1 to set
     */
    public void setTelefonoF1(String TelefonoF1) {
        this.TelefonoF1 = TelefonoF1;
    }

    /**
     * @return String return the CorreoF
     */
    public String getCorreoF() {
        return CorreoF;
    }

    /**
     * @param CorreoF the CorreoF to set
     */
    public void setCorreoF(String CorreoF) {
        this.CorreoF = CorreoF;
    }

    /**
     * @return String return the CorreoF1
     */
    public String getCorreoF1() {
        return CorreoF1;
    }

    /**
     * @param CorreoF1 the CorreoF1 to set
     */
    public void setCorreoF1(String CorreoF1) {
        this.CorreoF1 = CorreoF1;
    }

    /**
     * @return String return the ContactoT
     */
    public String getContactoT() {
        return ContactoT;
    }

    /**
     * @param ContactoT the ContactoT to set
     */
    public void setContactoT(String ContactoT) {
        this.ContactoT = ContactoT;
    }

    /**
     * @return String return the ContactoT1
     */
    public String getContactoT1() {
        return ContactoT1;
    }

    /**
     * @param ContactoT1 the ContactoT1 to set
     */
    public void setContactoT1(String ContactoT1) {
        this.ContactoT1 = ContactoT1;
    }

    /**
     * @return String return the ContactoT2
     */
    public String getContactoT2() {
        return ContactoT2;
    }

    /**
     * @param ContactoT2 the ContactoT2 to set
     */
    public void setContactoT2(String ContactoT2) {
        this.ContactoT2 = ContactoT2;
    }

    /**
     * @return String return the TelefonoT
     */
    public String getTelefonoT() {
        return TelefonoT;
    }

    /**
     * @param TelefonoT the TelefonoT to set
     */
    public void setTelefonoT(String TelefonoT) {
        this.TelefonoT = TelefonoT;
    }

    /**
     * @return String return the TelefonoT1
     */
    public String getTelefonoT1() {
        return TelefonoT1;
    }

    /**
     * @param TelefonoT1 the TelefonoT1 to set
     */
    public void setTelefonoT1(String TelefonoT1) {
        this.TelefonoT1 = TelefonoT1;
    }

    /**
     * @return String return the TelefonoT2
     */
    public String getTelefonoT2() {
        return TelefonoT2;
    }

    /**
     * @param TelefonoT2 the TelefonoT2 to set
     */
    public void setTelefonoT2(String TelefonoT2) {
        this.TelefonoT2 = TelefonoT2;
    }

    /**
     * @return String return the CorreoT
     */
    public String getCorreoT() {
        return CorreoT;
    }

    /**
     * @param CorreoT the CorreoT to set
     */
    public void setCorreoT(String CorreoT) {
        this.CorreoT = CorreoT;
    }

    /**
     * @return String return the CorreoT1
     */
    public String getCorreoT1() {
        return CorreoT1;
    }

    /**
     * @param CorreoT1 the CorreoT1 to set
     */
    public void setCorreoT1(String CorreoT1) {
        this.CorreoT1 = CorreoT1;
    }

    /**
     * @return String return the CorreoT2
     */
    public String getCorreoT2() {
        return CorreoT2;
    }

    /**
     * @param CorreoT2 the CorreoT2 to set
     */
    public void setCorreoT2(String CorreoT2) {
        this.CorreoT2 = CorreoT2;
    }

    /**
     * @return String return the Beneficiario
     */
    public String getBeneficiario() {
        return Beneficiario;
    }

    /**
     * @param Beneficiario the Beneficiario to set
     */
    public void setBeneficiario(String Beneficiario) {
        this.Beneficiario = Beneficiario;
    }

    /**
     * @return String return the ClaveInter
     */
    public String getClaveInter() {
        return ClaveInter;
    }

    /**
     * @param ClaveInter the ClaveInter to set
     */
    public void setClaveInter(String ClaveInter) {
        this.ClaveInter = ClaveInter;
    }

    /**
     * @return String return the Swift
     */
    public String getSwift() {
        return Swift;
    }

    /**
     * @param Swift the Swift to set
     */
    public void setSwift(String Swift) {
        this.Swift = Swift;
    }

    /**
     * @return Integer return the DiasRFD
     */
    public Integer getDiasRFD() {
        return DiasRFD;
    }

    /**
     * @param DiasRFD the DiasRFD to set
     */
    public void setDiasRFD(Integer DiasRFD) {
        this.DiasRFD = DiasRFD;
    }

    /**
     * @return Integer return the TipoDiasRFD
     */
    public Integer getTipoDiasRFD() {
        return TipoDiasRFD;
    }

    /**
     * @param TipoDiasRFD the TipoDiasRFD to set
     */
    public void setTipoDiasRFD(Integer TipoDiasRFD) {
        this.TipoDiasRFD = TipoDiasRFD;
    }

    /**
     * @return Integer return the DiasCFD
     */
    public Integer getDiasCFD() {
        return DiasCFD;
    }

    /**
     * @param DiasCFD the DiasCFD to set
     */
    public void setDiasCFD(Integer DiasCFD) {
        this.DiasCFD = DiasCFD;
    }

    /**
     * @return Integer return the TipoDiasCFD
     */
    public Integer getTipoDiasCFD() {
        return TipoDiasCFD;
    }

    /**
     * @param TipoDiasCFD the TipoDiasCFD to set
     */
    public void setTipoDiasCFD(Integer TipoDiasCFD) {
        this.TipoDiasCFD = TipoDiasCFD;
    }

    /**
     * @return String return the RFCBanco
     */
    public String getRFCBanco() {
        return RFCBanco;
    }

    /**
     * @param RFCBanco the RFCBanco to set
     */
    public void setRFCBanco(String RFCBanco) {
        this.RFCBanco = RFCBanco;
    }

    /**
     * @return String return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * @return String return the DireccionF
     */
    public String getDireccionF() {
        return DireccionF;
    }

    /**
     * @param DireccionF the DireccionF to set
     */
    public void setDireccionF(String DireccionF) {
        this.DireccionF = DireccionF;
    }

    /**
     * @return Integer return the DiasSinFactura
     */
    public Integer getDiasSinFactura() {
        return DiasSinFactura;
    }

    /**
     * @param DiasSinFactura the DiasSinFactura to set
     */
    public void setDiasSinFactura(Integer DiasSinFactura) {
        this.DiasSinFactura = DiasSinFactura;
    }

    /**
     * @return Integer return the TotalContenedoresVencidos
     */
    public Integer getTotalContenedoresVencidos() {
        return TotalContenedoresVencidos;
    }

    /**
     * @param TotalContenedoresVencidos the TotalContenedoresVencidos to set
     */
    public void setTotalContenedoresVencidos(Integer TotalContenedoresVencidos) {
        this.TotalContenedoresVencidos = TotalContenedoresVencidos;
    }

    /**
     * @return Integer return the ContenedoresPorDia
     */
    public Integer getContenedoresPorDia() {
        return ContenedoresPorDia;
    }

    /**
     * @param ContenedoresPorDia the ContenedoresPorDia to set
     */
    public void setContenedoresPorDia(Integer ContenedoresPorDia) {
        this.ContenedoresPorDia = ContenedoresPorDia;
    }

    /**
     * @return Integer return the ContenedoresFacturadosDiarios
     */
    public Integer getContenedoresFacturadosDiarios() {
        return ContenedoresFacturadosDiarios;
    }

    /**
     * @param ContenedoresFacturadosDiarios the ContenedoresFacturadosDiarios to set
     */
    public void setContenedoresFacturadosDiarios(Integer ContenedoresFacturadosDiarios) {
        this.ContenedoresFacturadosDiarios = ContenedoresFacturadosDiarios;
    }

    /**
     * @return Integer return the ContenedoresNoFacturadosDiarios
     */
    public Integer getContenedoresNoFacturadosDiarios() {
        return ContenedoresNoFacturadosDiarios;
    }

    /**
     * @param ContenedoresNoFacturadosDiarios the ContenedoresNoFacturadosDiarios to
     *                                        set
     */
    public void setContenedoresNoFacturadosDiarios(Integer ContenedoresNoFacturadosDiarios) {
        this.ContenedoresNoFacturadosDiarios = ContenedoresNoFacturadosDiarios;
    }

    /**
     * @return Integer return the TipoFac
     */
    public Integer getTipoFac() {
        return TipoFac;
    }

    /**
     * @param TipoFac the TipoFac to set
     */
    public void setTipoFac(Integer TipoFac) {
        this.TipoFac = TipoFac;
    }

    /**
     * @return Integer return the UNegocioID
     */
    public Integer getUNegocioID() {
        return UNegocioID;
    }

    /**
     * @param UNegocioID the UNegocioID to set
     */
    public void setUNegocioID(Integer UNegocioID) {
        this.UNegocioID = UNegocioID;
    }

    /**
     * @return String return the correoHoras
     */
    public String getCorreoHoras() {
        return correoHoras;
    }

    /**
     * @param correoHoras the correoHoras to set
     */
    public void setCorreoHoras(String correoHoras) {
        this.correoHoras = correoHoras;
    }

    /**
     * @return Byte return the correoEnviar
     */
    public Byte getCorreoEnviar() {
        return correoEnviar;
    }

    /**
     * @param correoEnviar the correoEnviar to set
     */
    public void setCorreoEnviar(Byte correoEnviar) {
        this.correoEnviar = correoEnviar;
    }

    /**
     * @return String return the CorreoInventario
     */
    public String getCorreoInventario() {
        return CorreoInventario;
    }

    /**
     * @param CorreoInventario the CorreoInventario to set
     */
    public void setCorreoInventario(String CorreoInventario) {
        this.CorreoInventario = CorreoInventario;
    }

    /**
     * @return String return the CiudadF
     */
    public String getCiudadF() {
        return CiudadF;
    }

    /**
     * @param CiudadF the CiudadF to set
     */
    public void setCiudadF(String CiudadF) {
        this.CiudadF = CiudadF;
    }

    /**
     * @return String return the Ciudad
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * @param Ciudad the Ciudad to set
     */
    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    /**
     * @return String return the CTPATID
     */
    public String getCTPATID() {
        return CTPATID;
    }

    /**
     * @param CTPATID the CTPATID to set
     */
    public void setCTPATID(String CTPATID) {
        this.CTPATID = CTPATID;
    }

    /**
     * @return Byte return the InfoPendiente
     */
    public Byte getInfoPendiente() {
        return InfoPendiente;
    }

    /**
     * @param InfoPendiente the InfoPendiente to set
     */
    public void setInfoPendiente(Byte InfoPendiente) {
        this.InfoPendiente = InfoPendiente;
    }

    /**
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.status = Status;
    }

    /**
     * @return Byte return the Importacion
     */
    public Byte getImportacion() {
        return Importacion;
    }

    /**
     * @param Importacion the Importacion to set
     */
    public void setImportacion(Byte Importacion) {
        this.Importacion = Importacion;
    }

    /**
     * @return Byte return the Exportacion
     */
    public Byte getExportacion() {
        return Exportacion;
    }

    /**
     * @param Exportacion the Exportacion to set
     */
    public void setExportacion(Byte Exportacion) {
        this.Exportacion = Exportacion;
    }

    /**
     * @return Byte return the OEA
     */
    public Byte getOEA() {
        return OEA;
    }

    /**
     * @param OEA the OEA to set
     */
    public void setOEA(Byte OEA) {
        this.OEA = OEA;
    }

    /**
     * @return Byte return the AutoBill
     */
    public Byte getAutoBill() {
        return AutoBill;
    }

    /**
     * @param AutoBill the AutoBill to set
     */
    public void setAutoBill(Byte AutoBill) {
        this.AutoBill = AutoBill;
    }

    /**
     * @return Byte return the Inactivo
     */
    public Byte getInactivo() {
        return Inactivo;
    }

    /**
     * @param Inactivo the Inactivo to set
     */
    public void setInactivo(Byte Inactivo) {
        this.Inactivo = Inactivo;
    }

    /**
     * @return String return the ComentarioInactivo
     */
    public String getComentarioInactivo() {
        return ComentarioInactivo;
    }

    /**
     * @param ComentarioInactivo the ComentarioInactivo to set
     */
    public void setComentarioInactivo(String ComentarioInactivo) {
        this.ComentarioInactivo = ComentarioInactivo;
    }

    /**
     * @return String return the NombreQB
     */
    public String getNombreQB() {
        return NombreQB;
    }

    /**
     * @param NombreQB the NombreQB to set
     */
    public void setNombreQB(String NombreQB) {
        this.NombreQB = NombreQB;
    }

    /**
     * @return Byte return the correoClient
     */
    public Byte getCorreoClient() {
        return correoClient;
    }

    /**
     * @param correoClient the correoClient to set
     */
    public void setCorreoClient(Byte correoClient) {
        this.correoClient = correoClient;
    }

    /**
     * @return Byte return the correoEProvider
     */
    public Byte getCorreoEProvider() {
        return correoEProvider;
    }

    /**
     * @param correoEProvider the correoEProvider to set
     */
    public void setCorreoEProvider(Byte correoEProvider) {
        this.correoEProvider = correoEProvider;
    }

    /**
     * @return Integer return the UsuarioMod
     */
    public Integer getUsuarioMod() {
        return UsuarioMod;
    }

    /**
     * @param UsuarioMod the UsuarioMod to set
     */
    public void setUsuarioMod(Integer UsuarioMod) {
        this.UsuarioMod = UsuarioMod;
    }

    /**
     * @return Date return the FechaMod
     */
    public Date getFechaMod() {
        return FechaMod;
    }

    /**
     * @param FechaMod the FechaMod to set
     */
    public void setFechaMod(Date FechaMod) {
        this.FechaMod = FechaMod;
    }

    /**
     * @return Byte return the MostrarExternos
     */
    public Byte getMostrarExternos() {
        return MostrarExternos;
    }

    /**
     * @param MostrarExternos the MostrarExternos to set
     */
    public void setMostrarExternos(Byte MostrarExternos) {
        this.MostrarExternos = MostrarExternos;
    }

    /**
     * @return Byte return the equipmentprovider
     */
    public Byte getEquipmentprovider() {
        return equipmentprovider;
    }

    /**
     * @param equipmentprovider the equipmentprovider to set
     */
    public void setEquipmentprovider(Byte equipmentprovider) {
        this.equipmentprovider = equipmentprovider;
    }

    /**
     * @return Byte return the emptyx
     */
    public Byte getEmptyx() {
        return emptyx;
    }

    /**
     * @param emptyx the emptyx to set
     */
    public void setEmptyx(Byte emptyx) {
        this.emptyx = emptyx;
    }

    /**
     * @return Byte return the loadx
     */
    public Byte getLoadx() {
        return loadx;
    }

    /**
     * @param loadx the loadx to set
     */
    public void setLoadx(Byte loadx) {
        this.loadx = loadx;
    }

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return String return the NombrewsMerca
     */
    public String getNombrewsMerca() {
        return NombrewsMerca;
    }

    /**
     * @param NombrewsMerca the NombrewsMerca to set
     */
    public void setNombrewsMerca(String NombrewsMerca) {
        this.NombrewsMerca = NombrewsMerca;
    }

    /**
     * @return String return the RegimenFiscal
     */
    public String getRegimenFiscal() {
        return RegimenFiscal;
    }

    /**
     * @param RegimenFiscal the RegimenFiscal to set
     */
    public void setRegimenFiscal(String RegimenFiscal) {
        this.RegimenFiscal = RegimenFiscal;
    }

    /**
     * @return String return the RegimenCapital
     */
    public String getRegimenCapital() {
        return RegimenCapital;
    }

    /**
     * @param RegimenCapital the RegimenCapital to set
     */
    public void setRegimenCapital(String RegimenCapital) {
        this.RegimenCapital = RegimenCapital;
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
     * @return String return the UsoCFDIc
     */
    public String getUsoCFDIc() {
        return UsoCFDIc;
    }

    /**
     * @param UsoCFDIc the UsoCFDIc to set
     */
    public void setUsoCFDIc(String UsoCFDIc) {
        this.UsoCFDIc = UsoCFDIc;
    }

    /**
     * @return String return the MetodoPagoc
     */
    public String getMetodoPagoc() {
        return MetodoPagoc;
    }

    /**
     * @param MetodoPagoc the MetodoPagoc to set
     */
    public void setMetodoPagoc(String MetodoPagoc) {
        this.MetodoPagoc = MetodoPagoc;
    }

    /**
     * @return String return the FormaPagoc
     */
    public String getFormaPagoc() {
        return FormaPagoc;
    }

    /**
     * @param FormaPagoc the FormaPagoc to set
     */
    public void setFormaPagoc(String FormaPagoc) {
        this.FormaPagoc = FormaPagoc;
    }

    /**
     * @return String return the CondicionPagoc
     */
    public String getCondicionPagoc() {
        return CondicionPagoc;
    }

    /**
     * @param CondicionPagoc the CondicionPagoc to set
     */
    public void setCondicionPagoc(String CondicionPagoc) {
        this.CondicionPagoc = CondicionPagoc;
    }

    /**
     * @return String return the NotaFacturac
     */
    public String getNotaFacturac() {
        return NotaFacturac;
    }

    /**
     * @param NotaFacturac the NotaFacturac to set
     */
    public void setNotaFacturac(String NotaFacturac) {
        this.NotaFacturac = NotaFacturac;
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

}
