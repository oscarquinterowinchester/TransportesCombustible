package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "choferes_tbl")
public class ChoferesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChoferID")
    private Integer ChoferID;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "Direccion")
    private String Direccion;
    @Column(name = "Telefono")
    private String Telefono;
    @Column(name = "Celular")
    private String Celular;
    @Column(name = "Nextel")
    private String Nextel;
    @Column(name = "Status")
    private Byte status;

    @Temporal(TemporalType.DATE)
    @Column(name = "Nacimiento")
    private Date Nacimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "Ingreso")
    private Date Ingreso;

    @Column(name = "CURP")
    private String CURP;
    @Column(name = "Licencia")
    private String Licencia;
    @Column(name = "TipoLicencia")
    private String TipoLicencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "ExpLicencia")
    private Date ExpLicencia;

    @Column(name = "Escolaridad")
    private String Escolaridad;
    @Column(name = "SS")
    private String SS;

    @Temporal(TemporalType.DATE)
    @Column(name = "Contrato")
    private String Contrato;

    @Column(name = "Foto")
    private String Foto;
    @Column(name = "Puesto")
    private Integer Puesto;
    @Column(name = "Infonavit")
    private String Infonavit;
    @Column(name = "RFC")
    private String RFC;
    @Column(name = "Visa")
    private String Visa;
    @Column(name = "Fast")
    private String Fast;
    @Column(name = "CamionID")
    private Integer CamionID;
    @Column(name = "EstadoLicencia")
    private String EstadoLicencia;
    @Column(name = "TipoChofer")
    private Integer TipoChofer;
    @Column(name = "Gafete")
    private String Gafete;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "TipoPermiso")
    private Integer tipoPermiso;

    @Temporal(TemporalType.DATE)
    @Column(name = "VencimientoVisa")
    private Date VencimientoVisa;

    @Temporal(TemporalType.DATE)
    @Column(name = "VencimientoFast")
    private Date VencimientoFast;

    @Column(name = "Usuario")
    private String Usuario;
    @Column(name = "Contra")
    private String Contra;
    @Column(name = "NoEmpleado")
    private String NoEmpleado;
    @Column(name = "Notres")
    private String Notres;
    @Column(name = "TurnoID")
    private Integer TurnoID;
    @Column(name = "Cuenta")
    private String Cuenta;
    @Column(name = "NoTarjeta")
    private String NoTarjeta;
    @Column(name = "TipoOperador")
    private Integer TipoOperador;
    @Column(name = "Detener")
    private Byte Detener;
    @Column(name = "NoContrato")
    private String NoContrato;
    @Column(name = "Lentes")
    private Byte Lentes;
    @Column(name = "TipoSangre")
    private String TipoSangre;
    @Column(name = "NotaMedica")
    private String NotaMedica;

    @Temporal(TemporalType.DATE)
    @Column(name = "Antidoping")
    private Date Antidoping;

    @Temporal(TemporalType.DATE)
    @Column(name = "NoPenales")
    private Date NoPenales;

    @Column(name = "DollyID")
    private Integer DollyID;
    @Column(name = "ClaveHisense")
    private String ClaveHisense;
    @Column(name = "Externo")
    private Byte Externo;
    @Column(name = "NoTractor")
    private String NoTractor;
    @Column(name = "PlacasTractor")
    private String PlacasTractor;
    @Column(name = "ChoferUSA")
    private Byte ChoferUSA;
    @Column(name = "CuadrarNomina")
    private Byte CuadrarNomina;

    @Temporal(TemporalType.DATE)
    @Column(name = "VGIdentificacion")
    private Date VGIdentificacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "VGNoInfraccion")
    private Date VGNoInfraccion;

    @Temporal(TemporalType.DATE)
    private Date VGConsultaLicencia;
    @Temporal(TemporalType.DATE)
    private Date VGComprobanteDom;
    @Temporal(TemporalType.DATE)
    private Date VGGafeteEmpresa;
    @Temporal(TemporalType.DATE)
    private Date VGGafeteMexicano;
    @Temporal(TemporalType.DATE)
    private Date VGGafeteAmericano;
    @Temporal(TemporalType.DATE)
    private Date VGTarjetaTWIC;
    @Temporal(TemporalType.DATE)
    private Date VGRecordDMV;
    @Temporal(TemporalType.DATE)
    private Date VGPullNotice;
    @Temporal(TemporalType.DATE)
    private Date VGExamenMedico;
    @Temporal(TemporalType.DATE)
    private Date VGContrato;
    @Temporal(TemporalType.DATE)
    private Date VGApoyoCTPAT;
    @Temporal(TemporalType.DATE)
    private Date VGAnnualReviewDriving;
    @Temporal(TemporalType.DATE)
    private Date VGDriversCertificationViolations;
    @Temporal(TemporalType.DATE)
    private Date VGVisitaDomiciliaria;
    @Temporal(TemporalType.DATE)
    private Date VGConstancia;

    @Column(name = "usuarioID")
    private Integer usuarioID;
    @Column(name = "BaseDM")
    private Byte BaseDM;
    @Column(name = "GafeteAM")
    private String GafeteAm;
    @Column(name = "UNegocioID")
    private Integer UNegocioID;
    @Column(name = "Puestos")
    private String Puestos;
    @Column(name = "UsuarioMod")
    private Integer UsuarioMod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaMod;

    private String NoExterior;
    private String Estado;
    private Integer EstadoID;
    private String Pais;
    private Integer paisID;
    private String CP;
    private String Municipio;
    private String cestado;
    private String clocalidad;
    private Integer clocalidadid;
    private String cmunicipio;
    private Integer cmunicipioid;
    private String ccolonia;
    private Integer ccoloniaid;
    private Integer departamentoID;
    private Integer empresaID;
    private Integer perfilrfk;
    private String DriverType;

    // Getters and Setters

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
     * @return String return the Celular
     */
    public String getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    /**
     * @return String return the Nextel
     */
    public String getNextel() {
        return Nextel;
    }

    /**
     * @param Nextel the Nextel to set
     */
    public void setNextel(String Nextel) {
        this.Nextel = Nextel;
    }

    /**
     * @return Date return the Nacimiento
     */
    public Date getNacimiento() {
        return Nacimiento;
    }

    /**
     * @param Nacimiento the Nacimiento to set
     */
    public void setNacimiento(Date Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    /**
     * @return Date return the Ingreso
     */
    public Date getIngreso() {
        return Ingreso;
    }

    /**
     * @param Ingreso the Ingreso to set
     */
    public void setIngreso(Date Ingreso) {
        this.Ingreso = Ingreso;
    }

    /**
     * @return String return the CURP
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * @param CURP the CURP to set
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
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
     * @return String return the TipoLicencia
     */
    public String getTipoLicencia() {
        return TipoLicencia;
    }

    /**
     * @param TipoLicencia the TipoLicencia to set
     */
    public void setTipoLicencia(String TipoLicencia) {
        this.TipoLicencia = TipoLicencia;
    }

    /**
     * @return Date return the ExpLicencia
     */
    public Date getExpLicencia() {
        return ExpLicencia;
    }

    /**
     * @param ExpLicencia the ExpLicencia to set
     */
    public void setExpLicencia(Date ExpLicencia) {
        this.ExpLicencia = ExpLicencia;
    }

    /**
     * @return String return the Escolaridad
     */
    public String getEscolaridad() {
        return Escolaridad;
    }

    /**
     * @param Escolaridad the Escolaridad to set
     */
    public void setEscolaridad(String Escolaridad) {
        this.Escolaridad = Escolaridad;
    }

    /**
     * @return String return the SS
     */
    public String getSS() {
        return SS;
    }

    /**
     * @param SS the SS to set
     */
    public void setSS(String SS) {
        this.SS = SS;
    }

    /**
     * @return String return the Contrato
     */
    public String getContrato() {
        return Contrato;
    }

    /**
     * @param Contrato the Contrato to set
     */
    public void setContrato(String Contrato) {
        this.Contrato = Contrato;
    }

    /**
     * @return String return the Foto
     */
    public String getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    /**
     * @return Integer return the Puesto
     */
    public Integer getPuesto() {
        return Puesto;
    }

    /**
     * @param Puesto the Puesto to set
     */
    public void setPuesto(Integer Puesto) {
        this.Puesto = Puesto;
    }

    /**
     * @return String return the Infonavit
     */
    public String getInfonavit() {
        return Infonavit;
    }

    /**
     * @param Infonavit the Infonavit to set
     */
    public void setInfonavit(String Infonavit) {
        this.Infonavit = Infonavit;
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
     * @return String return the Visa
     */
    public String getVisa() {
        return Visa;
    }

    /**
     * @param Visa the Visa to set
     */
    public void setVisa(String Visa) {
        this.Visa = Visa;
    }

    /**
     * @return String return the Fast
     */
    public String getFast() {
        return Fast;
    }

    /**
     * @param Fast the Fast to set
     */
    public void setFast(String Fast) {
        this.Fast = Fast;
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
     * @return String return the EstadoLicencia
     */
    public String getEstadoLicencia() {
        return EstadoLicencia;
    }

    /**
     * @param EstadoLicencia the EstadoLicencia to set
     */
    public void setEstadoLicencia(String EstadoLicencia) {
        this.EstadoLicencia = EstadoLicencia;
    }

    /**
     * @return Integer return the TipoChofer
     */
    public Integer getTipoChofer() {
        return TipoChofer;
    }

    /**
     * @param TipoChofer the TipoChofer to set
     */
    public void setTipoChofer(Integer TipoChofer) {
        this.TipoChofer = TipoChofer;
    }

    /**
     * @return String return the Gafete
     */
    public String getGafete() {
        return Gafete;
    }

    /**
     * @param Gafete the Gafete to set
     */
    public void setGafete(String Gafete) {
        this.Gafete = Gafete;
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
     * @return Integer return the tipoPermiso
     */
    public Integer getTipoPermiso() {
        return tipoPermiso;
    }

    /**
     * @param tipoPermiso the tipoPermiso to set
     */
    public void setTipoPermiso(Integer tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }

    /**
     * @return Date return the VencimientoVisa
     */
    public Date getVencimientoVisa() {
        return VencimientoVisa;
    }

    /**
     * @param VencimientoVisa the VencimientoVisa to set
     */
    public void setVencimientoVisa(Date VencimientoVisa) {
        this.VencimientoVisa = VencimientoVisa;
    }

    /**
     * @return Date return the VencimientoFast
     */
    public Date getVencimientoFast() {
        return VencimientoFast;
    }

    /**
     * @param VencimientoFast the VencimientoFast to set
     */
    public void setVencimientoFast(Date VencimientoFast) {
        this.VencimientoFast = VencimientoFast;
    }

    /**
     * @return String return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return String return the Contra
     */
    public String getContra() {
        return Contra;
    }

    /**
     * @param Contra the Contra to set
     */
    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    /**
     * @return String return the NoEmpleado
     */
    public String getNoEmpleado() {
        return NoEmpleado;
    }

    /**
     * @param NoEmpleado the NoEmpleado to set
     */
    public void setNoEmpleado(String NoEmpleado) {
        this.NoEmpleado = NoEmpleado;
    }

    /**
     * @return String return the Notres
     */
    public String getNotres() {
        return Notres;
    }

    /**
     * @param Notres the Notres to set
     */
    public void setNotres(String Notres) {
        this.Notres = Notres;
    }

    /**
     * @return Integer return the TurnoID
     */
    public Integer getTurnoID() {
        return TurnoID;
    }

    /**
     * @param TurnoID the TurnoID to set
     */
    public void setTurnoID(Integer TurnoID) {
        this.TurnoID = TurnoID;
    }

    /**
     * @return String return the Cuenta
     */
    public String getCuenta() {
        return Cuenta;
    }

    /**
     * @param Cuenta the Cuenta to set
     */
    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    /**
     * @return String return the NoTarjeta
     */
    public String getNoTarjeta() {
        return NoTarjeta;
    }

    /**
     * @param NoTarjeta the NoTarjeta to set
     */
    public void setNoTarjeta(String NoTarjeta) {
        this.NoTarjeta = NoTarjeta;
    }

    /**
     * @return Integer return the TipoOperador
     */
    public Integer getTipoOperador() {
        return TipoOperador;
    }

    /**
     * @param TipoOperador the TipoOperador to set
     */
    public void setTipoOperador(Integer TipoOperador) {
        this.TipoOperador = TipoOperador;
    }

    /**
     * @return Byte return the Detener
     */
    public Byte getDetener() {
        return Detener;
    }

    /**
     * @param Detener the Detener to set
     */
    public void setDetener(Byte Detener) {
        this.Detener = Detener;
    }

    /**
     * @return String return the NoContrato
     */
    public String getNoContrato() {
        return NoContrato;
    }

    /**
     * @param NoContrato the NoContrato to set
     */
    public void setNoContrato(String NoContrato) {
        this.NoContrato = NoContrato;
    }

    /**
     * @return Byte return the Lentes
     */
    public Byte getLentes() {
        return Lentes;
    }

    /**
     * @param Lentes the Lentes to set
     */
    public void setLentes(Byte Lentes) {
        this.Lentes = Lentes;
    }

    /**
     * @return String return the TipoSangre
     */
    public String getTipoSangre() {
        return TipoSangre;
    }

    /**
     * @param TipoSangre the TipoSangre to set
     */
    public void setTipoSangre(String TipoSangre) {
        this.TipoSangre = TipoSangre;
    }

    /**
     * @return String return the NotaMedica
     */
    public String getNotaMedica() {
        return NotaMedica;
    }

    /**
     * @param NotaMedica the NotaMedica to set
     */
    public void setNotaMedica(String NotaMedica) {
        this.NotaMedica = NotaMedica;
    }

    /**
     * @return Date return the Antidoping
     */
    public Date getAntidoping() {
        return Antidoping;
    }

    /**
     * @param Antidoping the Antidoping to set
     */
    public void setAntidoping(Date Antidoping) {
        this.Antidoping = Antidoping;
    }

    /**
     * @return Date return the NoPenales
     */
    public Date getNoPenales() {
        return NoPenales;
    }

    /**
     * @param NoPenales the NoPenales to set
     */
    public void setNoPenales(Date NoPenales) {
        this.NoPenales = NoPenales;
    }

    /**
     * @return Integer return the DollyID
     */
    public Integer getDollyID() {
        return DollyID;
    }

    /**
     * @param DollyID the DollyID to set
     */
    public void setDollyID(Integer DollyID) {
        this.DollyID = DollyID;
    }

    /**
     * @return String return the ClaveHisense
     */
    public String getClaveHisense() {
        return ClaveHisense;
    }

    /**
     * @param ClaveHisense the ClaveHisense to set
     */
    public void setClaveHisense(String ClaveHisense) {
        this.ClaveHisense = ClaveHisense;
    }

    /**
     * @return Byte return the Externo
     */
    public Byte getExterno() {
        return Externo;
    }

    /**
     * @param Externo the Externo to set
     */
    public void setExterno(Byte Externo) {
        this.Externo = Externo;
    }

    /**
     * @return String return the NoTractor
     */
    public String getNoTractor() {
        return NoTractor;
    }

    /**
     * @param NoTractor the NoTractor to set
     */
    public void setNoTractor(String NoTractor) {
        this.NoTractor = NoTractor;
    }

    /**
     * @return String return the PlacasTractor
     */
    public String getPlacasTractor() {
        return PlacasTractor;
    }

    /**
     * @param PlacasTractor the PlacasTractor to set
     */
    public void setPlacasTractor(String PlacasTractor) {
        this.PlacasTractor = PlacasTractor;
    }

    /**
     * @return Byte return the ChoferUSA
     */
    public Byte getChoferUSA() {
        return ChoferUSA;
    }

    /**
     * @param ChoferUSA the ChoferUSA to set
     */
    public void setChoferUSA(Byte ChoferUSA) {
        this.ChoferUSA = ChoferUSA;
    }

    /**
     * @return Byte return the CuadrarNomina
     */
    public Byte getCuadrarNomina() {
        return CuadrarNomina;
    }

    /**
     * @param CuadrarNomina the CuadrarNomina to set
     */
    public void setCuadrarNomina(Byte CuadrarNomina) {
        this.CuadrarNomina = CuadrarNomina;
    }

    /**
     * @return Date return the VGIdentificacion
     */
    public Date getVGIdentificacion() {
        return VGIdentificacion;
    }

    /**
     * @param VGIdentificacion the VGIdentificacion to set
     */
    public void setVGIdentificacion(Date VGIdentificacion) {
        this.VGIdentificacion = VGIdentificacion;
    }

    /**
     * @return Date return the VGNoInfraccion
     */
    public Date getVGNoInfraccion() {
        return VGNoInfraccion;
    }

    /**
     * @param VGNoInfraccion the VGNoInfraccion to set
     */
    public void setVGNoInfraccion(Date VGNoInfraccion) {
        this.VGNoInfraccion = VGNoInfraccion;
    }

    /**
     * @return Date return the VGConsultaLicencia
     */
    public Date getVGConsultaLicencia() {
        return VGConsultaLicencia;
    }

    /**
     * @param VGConsultaLicencia the VGConsultaLicencia to set
     */
    public void setVGConsultaLicencia(Date VGConsultaLicencia) {
        this.VGConsultaLicencia = VGConsultaLicencia;
    }

    /**
     * @return Date return the VGComprobanteDom
     */
    public Date getVGComprobanteDom() {
        return VGComprobanteDom;
    }

    /**
     * @param VGComprobanteDom the VGComprobanteDom to set
     */
    public void setVGComprobanteDom(Date VGComprobanteDom) {
        this.VGComprobanteDom = VGComprobanteDom;
    }

    /**
     * @return Date return the VGGafeteEmpresa
     */
    public Date getVGGafeteEmpresa() {
        return VGGafeteEmpresa;
    }

    /**
     * @param VGGafeteEmpresa the VGGafeteEmpresa to set
     */
    public void setVGGafeteEmpresa(Date VGGafeteEmpresa) {
        this.VGGafeteEmpresa = VGGafeteEmpresa;
    }

    /**
     * @return Date return the VGGafeteMexicano
     */
    public Date getVGGafeteMexicano() {
        return VGGafeteMexicano;
    }

    /**
     * @param VGGafeteMexicano the VGGafeteMexicano to set
     */
    public void setVGGafeteMexicano(Date VGGafeteMexicano) {
        this.VGGafeteMexicano = VGGafeteMexicano;
    }

    /**
     * @return Date return the VGGafeteAmericano
     */
    public Date getVGGafeteAmericano() {
        return VGGafeteAmericano;
    }

    /**
     * @param VGGafeteAmericano the VGGafeteAmericano to set
     */
    public void setVGGafeteAmericano(Date VGGafeteAmericano) {
        this.VGGafeteAmericano = VGGafeteAmericano;
    }

    /**
     * @return Date return the VGTarjetaTWIC
     */
    public Date getVGTarjetaTWIC() {
        return VGTarjetaTWIC;
    }

    /**
     * @param VGTarjetaTWIC the VGTarjetaTWIC to set
     */
    public void setVGTarjetaTWIC(Date VGTarjetaTWIC) {
        this.VGTarjetaTWIC = VGTarjetaTWIC;
    }

    /**
     * @return Date return the VGRecordDMV
     */
    public Date getVGRecordDMV() {
        return VGRecordDMV;
    }

    /**
     * @param VGRecordDMV the VGRecordDMV to set
     */
    public void setVGRecordDMV(Date VGRecordDMV) {
        this.VGRecordDMV = VGRecordDMV;
    }

    /**
     * @return Date return the VGPullNotice
     */
    public Date getVGPullNotice() {
        return VGPullNotice;
    }

    /**
     * @param VGPullNotice the VGPullNotice to set
     */
    public void setVGPullNotice(Date VGPullNotice) {
        this.VGPullNotice = VGPullNotice;
    }

    /**
     * @return Date return the VGExamenMedico
     */
    public Date getVGExamenMedico() {
        return VGExamenMedico;
    }

    /**
     * @param VGExamenMedico the VGExamenMedico to set
     */
    public void setVGExamenMedico(Date VGExamenMedico) {
        this.VGExamenMedico = VGExamenMedico;
    }

    /**
     * @return Date return the VGContrato
     */
    public Date getVGContrato() {
        return VGContrato;
    }

    /**
     * @param VGContrato the VGContrato to set
     */
    public void setVGContrato(Date VGContrato) {
        this.VGContrato = VGContrato;
    }

    /**
     * @return Date return the VGApoyoCTPAT
     */
    public Date getVGApoyoCTPAT() {
        return VGApoyoCTPAT;
    }

    /**
     * @param VGApoyoCTPAT the VGApoyoCTPAT to set
     */
    public void setVGApoyoCTPAT(Date VGApoyoCTPAT) {
        this.VGApoyoCTPAT = VGApoyoCTPAT;
    }

    /**
     * @return Date return the VGAnnualReviewDriving
     */
    public Date getVGAnnualReviewDriving() {
        return VGAnnualReviewDriving;
    }

    /**
     * @param VGAnnualReviewDriving the VGAnnualReviewDriving to set
     */
    public void setVGAnnualReviewDriving(Date VGAnnualReviewDriving) {
        this.VGAnnualReviewDriving = VGAnnualReviewDriving;
    }

    /**
     * @return Date return the VGDriversCertificationViolations
     */
    public Date getVGDriversCertificationViolations() {
        return VGDriversCertificationViolations;
    }

    /**
     * @param VGDriversCertificationViolations the VGDriversCertificationViolations
     *                                         to set
     */
    public void setVGDriversCertificationViolations(Date VGDriversCertificationViolations) {
        this.VGDriversCertificationViolations = VGDriversCertificationViolations;
    }

    /**
     * @return Date return the VGVisitaDomiciliaria
     */
    public Date getVGVisitaDomiciliaria() {
        return VGVisitaDomiciliaria;
    }

    /**
     * @param VGVisitaDomiciliaria the VGVisitaDomiciliaria to set
     */
    public void setVGVisitaDomiciliaria(Date VGVisitaDomiciliaria) {
        this.VGVisitaDomiciliaria = VGVisitaDomiciliaria;
    }

    /**
     * @return Date return the VGConstancia
     */
    public Date getVGConstancia() {
        return VGConstancia;
    }

    /**
     * @param VGConstancia the VGConstancia to set
     */
    public void setVGConstancia(Date VGConstancia) {
        this.VGConstancia = VGConstancia;
    }

    /**
     * @return Integer return the usuarioID
     */
    public Integer getUsuarioID() {
        return usuarioID;
    }

    /**
     * @param usuarioID the usuarioID to set
     */
    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * @return Byte return the BaseDM
     */
    public Byte getBaseDM() {
        return BaseDM;
    }

    /**
     * @param BaseDM the BaseDM to set
     */
    public void setBaseDM(Byte BaseDM) {
        this.BaseDM = BaseDM;
    }

    /**
     * @return String return the GafeteAm
     */
    public String getGafeteAm() {
        return GafeteAm;
    }

    /**
     * @param GafeteAm the GafeteAm to set
     */
    public void setGafeteAm(String GafeteAm) {
        this.GafeteAm = GafeteAm;
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
     * @return String return the Puestos
     */
    public String getPuestos() {
        return Puestos;
    }

    /**
     * @param Puestos the Puestos to set
     */
    public void setPuestos(String Puestos) {
        this.Puestos = Puestos;
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
     * @return String return the NoExterior
     */
    public String getNoExterior() {
        return NoExterior;
    }

    /**
     * @param NoExterior the NoExterior to set
     */
    public void setNoExterior(String NoExterior) {
        this.NoExterior = NoExterior;
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
     * @return Integer return the EstadoID
     */
    public Integer getEstadoID() {
        return EstadoID;
    }

    /**
     * @param EstadoID the EstadoID to set
     */
    public void setEstadoID(Integer EstadoID) {
        this.EstadoID = EstadoID;
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
     * @return Integer return the PaisID
     */
    public Integer getPaisID() {
        return paisID;
    }

    /**
     * @param paisID the PaisID to set
     */
    public void setPaisID(Integer paisID) {
        this.paisID = paisID;
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
     * @return String return the cestado
     */
    public String getCestado() {
        return cestado;
    }

    /**
     * @param cestado the cestado to set
     */
    public void setCestado(String cestado) {
        this.cestado = cestado;
    }

    /**
     * @return String return the clocalidad
     */
    public String getClocalidad() {
        return clocalidad;
    }

    /**
     * @param clocalidad the clocalidad to set
     */
    public void setClocalidad(String clocalidad) {
        this.clocalidad = clocalidad;
    }

    /**
     * @return Integer return the clocalidadid
     */
    public Integer getClocalidadid() {
        return clocalidadid;
    }

    /**
     * @param clocalidadid the clocalidadid to set
     */
    public void setClocalidadid(Integer clocalidadid) {
        this.clocalidadid = clocalidadid;
    }

    /**
     * @return String return the cmunicipio
     */
    public String getCmunicipio() {
        return cmunicipio;
    }

    /**
     * @param cmunicipio the cmunicipio to set
     */
    public void setCmunicipio(String cmunicipio) {
        this.cmunicipio = cmunicipio;
    }

    /**
     * @return Integer return the cmunicipioid
     */
    public Integer getCmunicipioid() {
        return cmunicipioid;
    }

    /**
     * @param cmunicipioid the cmunicipioid to set
     */
    public void setCmunicipioid(Integer cmunicipioid) {
        this.cmunicipioid = cmunicipioid;
    }

    /**
     * @return String return the ccolonia
     */
    public String getCcolonia() {
        return ccolonia;
    }

    /**
     * @param ccolonia the ccolonia to set
     */
    public void setCcolonia(String ccolonia) {
        this.ccolonia = ccolonia;
    }

    /**
     * @return Integer return the ccoloniaid
     */
    public Integer getCcoloniaid() {
        return ccoloniaid;
    }

    /**
     * @param ccoloniaid the ccoloniaid to set
     */
    public void setCcoloniaid(Integer ccoloniaid) {
        this.ccoloniaid = ccoloniaid;
    }

    /**
     * @return Integer return the departamentoID
     */
    public Integer getDepartamentoID() {
        return departamentoID;
    }

    /**
     * @param departamentoID the departamentoID to set
     */
    public void setDepartamentoID(Integer departamentoID) {
        this.departamentoID = departamentoID;
    }

    /**
     * @return Integer return the empresaID
     */
    public Integer getEmpresaID() {
        return empresaID;
    }

    /**
     * @param empresaID the empresaID to set
     */
    public void setEmpresaID(Integer empresaID) {
        this.empresaID = empresaID;
    }

    /**
     * @return Integer return the perfilrfk
     */
    public Integer getPerfilrfk() {
        return perfilrfk;
    }

    /**
     * @param perfilrfk the perfilrfk to set
     */
    public void setPerfilrfk(Integer perfilrfk) {
        this.perfilrfk = perfilrfk;
    }

    /**
     * @return String return the DriverType
     */
    public String getDriverType() {
        return DriverType;
    }

    /**
     * @param DriverType the DriverType to set
     */
    public void setDriverType(String DriverType) {
        this.DriverType = DriverType;
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

}
