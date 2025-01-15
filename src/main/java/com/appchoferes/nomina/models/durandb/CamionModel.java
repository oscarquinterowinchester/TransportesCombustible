package com.appchoferes.nomina.models.durandb;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "camiones_tbl")
public class CamionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CamionID")
    private Integer camionId;

    @Column(name = "NoEconomico")
    private String NoEconomico;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "placas")
    private String placas;

    @Column(name = "PlacasUSA")
    private String PlacasUSA;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "ExpPlacas")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ExpPlacas;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "ExpPlacasUSA")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ExpPlacasUSA;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "ExpSeguro")
    private Date ExpSeguro;

    @Column(name = "NoPoliza")
    private String NoPoliza;

    @Column(name = "Serie")
    private String Serie;

    @Column(name = "Moto")
    private String Moto;

    @Column(name = "Transmision")
    private String Transmision;

    @Column(name = "Diferencial")
    private String Diferencial;

    @Column(name = "Suspension")
    private String Suspension;

    @Column(name = "TipoAutobus")
    private String TipoAutobus;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "VerifiMotor")
    private Date VerifiMotor;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "VerifiHumo")
    private Date VerifiHumo;

    @Temporal(TemporalType.TIMESTAMP) // Anotación para manejar DATETIME
    @Column(name = "Fecha")
    private Date Fecha;

    @Column(name = "KmMantenimiento")
    private Float KmMantenimiento;

    @Column(name = "Tanques")
    private Float Tanques;

    @Column(name = "Capacidad")
    private Float Capacidad;

    @Column(name = "Status")
    private Byte status;

    @Column(name = "CajaID", columnDefinition = "int default 0")
    private Integer CajaID;

    @Column(name = "PolizaUSA")
    private String PolizaUSA;

    @Column(name = "Transponder")
    private String Transponder;

    @Column(name = "TipoOdometro")
    private Integer TipoOdometro;

    @Column(name = "EstadoPlacas")
    private String EstadoPlacas;

    @Column(name = "EstadoPlacasUSA")
    private String EstadoPlacasUSA;

    @Column(name = "TipoPermiso")
    private Integer TipoPermiso;

    @Column(name = "SinOdometro")
    private Byte SinOdometro;

    @Column(name = "RegistroID")
    private Integer RegistroID;

    @Column(name = "GPSID")
    private String GPSID;

    @Column(name = "Lat")
    private String Lat;

    @Column(name = "Lon")
    private String Lon;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "UltimoOdometro")
    private Float UltimoOdometro;

    @Column(name = "PatioActualID")
    private Integer PatioActualID;

    @Column(name = "UNegocioID")
    private Integer UNegocioID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaMantenimiento")
    private Date FechaMantenimiento;

    @Column(name = "TanqueActual")
    private Float TanqueActual;

    @Column(name = "Rendimiento")
    private Float Rendimiento;

    @Column(name = "ItinerarioFK")
    private Integer ItinerarioFK;

    @Column(name = "NumIFTA")
    private String NumIFTA;

    @Column(name = "TarjetaCombustible")
    private String TarjetaCombustible;

    @Column(name = "UsuarioMod")
    private Integer UsuarioMod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaMod")
    private Date FechaMod;

    @Column(name = "UsuarioEli")
    private Integer UsuarioEli;

    @Column(name = "NotaEli")
    private String NotaEli;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaEli")
    private Date FechaEli;

    @Column(name = "MetaDiaria")
    private Float MetaDiaria;

    @Column(name = "Comentarios")
    private String Comentarios;

    @Column(name = "cIFTA")
    private Byte cIFTA;

    @Column(name = "NombreAseguradora")
    private String NombreAseguradora;

    @Column(name = "CostoporMillaMatto", precision = 10, scale = 2)
    private BigDecimal CostoporMillaMatto;

    @Column(name = "ConfigVehicular")
    private String ConfigVehicular;

    @Column(name = "NumPermSCT")
    private String NumPermSCT;

    @Column(name = "PermSCT")
    private String PermSCT;

    @Column(name = "anio")
    private String anio;

    @Column(name = "NombreAseguradoraMA")
    private String NombreAseguradoraMA;

    @Column(name = "PolizaMA")
    private String PolizaMA;

    @Column(name = "empresaID")
    private Integer empresaID;

    @Column(name = "boe")
    private String boe;

    @Column(name = "caat")
    private String caat;

    @Column(name = "scac")
    private String scac;

    @Column(name = "certhazmat")
    private String certhazmat;

    @Column(name = "nlic")
    private String nlic;

    @Column(name = "FuelGID")
    private Integer FuelGID;

    @Column(name = "TipoCamionID")
    private Integer TipoCamionID;

    @Column(name = "partetransporte")
    private String partetransporte;

    @Column(name = "tipofigura")
    private String tipofigura;

    // Getters y setters
    public Integer getCamionId() {
        return camionId;
    }

    public void setCamionId(Integer camionId) {
        this.camionId = camionId;
    }

    public String getNoEconomico() {
        return NoEconomico;
    }

    public void setNoEconomico(String NoEconomico) {
        this.NoEconomico = NoEconomico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getPlacasUSA() {
        return PlacasUSA;
    }

    public void setPlacasUSA(String PlacasUSA) {
        this.PlacasUSA = PlacasUSA;
    }

    public Date getExpPlacas() {
        return ExpPlacas;
    }

    public void setExpPlacas(Date ExpPlacas) {
        this.ExpPlacas = ExpPlacas;
    }

    public Date getExpPlacasUSA() {
        return ExpPlacasUSA;
    }

    public void setExpPlacasUSA(Date ExpPlacasUSA) {
        this.ExpPlacasUSA = ExpPlacasUSA;
    }

    public Date getExpSeguro() {
        return ExpSeguro;
    }

    public void setExpSeguro(Date ExpSeguro) {
        this.ExpSeguro = ExpSeguro;
    }

    public String getNoPoliza() {
        return NoPoliza;
    }

    public void setNoPoliza(String NoPoliza) {
        this.NoPoliza = NoPoliza;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public String getMoto() {
        return Moto;
    }

    public void setMoto(String Moto) {
        this.Moto = Moto;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String Transmision) {
        this.Transmision = Transmision;
    }

    public String getDiferencial() {
        return Diferencial;
    }

    public void setDiferencial(String Diferencial) {
        this.Diferencial = Diferencial;
    }

    public String getSuspension() {
        return Suspension;
    }

    public void setSuspension(String Suspension) {
        this.Suspension = Suspension;
    }

    public String getTipoAutobus() {
        return TipoAutobus;
    }

    public void setTipoAutobus(String TipoAutobus) {
        this.TipoAutobus = TipoAutobus;
    }

    /**
     * @return String return the VerifiMotor
     */
    public Date getVerifiMotor() {
        return VerifiMotor;
    }

    /**
     * @param VerifiMotor the VerifiMotor to set
     */
    public void setVerifiMotor(Date VerifiMotor) {
        this.VerifiMotor = VerifiMotor;
    }

    /**
     * @return Date return the VerifiHumo
     */
    public Date getVerifiHumo() {
        return VerifiHumo;
    }

    /**
     * @param VerifiHumo the VerifiHumo to set
     */
    public void setVerifiHumo(Date VerifiHumo) {
        this.VerifiHumo = VerifiHumo;
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
     * @return Float return the KmMantenimiento
     */
    public Float getKmMantenimiento() {
        return KmMantenimiento;
    }

    /**
     * @param KmMantenimiento the KmMantenimieto to set
     */
    public void setKmMantenimiento(Float KmMantenimiento) {
        this.KmMantenimiento = KmMantenimiento;
    }

    /**
     * @return Float return the Tanques
     */
    public Float getTanques() {
        return Tanques;
    }

    /**
     * @param Tanques the Tanques to set
     */
    public void setTanques(Float Tanques) {
        this.Tanques = Tanques;
    }

    /**
     * @return Float return the Capacidad
     */
    public Float getCapacidad() {
        return Capacidad;
    }

    /**
     * @param Capacidad the Capacidad to set
     */
    public void setCapacidad(Float Capacidad) {
        this.Capacidad = Capacidad;
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
     * @return String return the PolizaUSA
     */
    public String getPolizaUSA() {
        return PolizaUSA;
    }

    /**
     * @param PolizaUSA the PolizaUSA to set
     */
    public void setPolizaUSA(String PolizaUSA) {
        this.PolizaUSA = PolizaUSA;
    }

    /**
     * @return String return the Transponder
     */
    public String getTransponder() {
        return Transponder;
    }

    /**
     * @param Transponder the Transponder to set
     */
    public void setTransponder(String Transponder) {
        this.Transponder = Transponder;
    }

    /**
     * @return Integer return the TipoOdometro
     */
    public Integer getTipoOdometro() {
        return TipoOdometro;
    }

    /**
     * @param TipoOdometro the TipoOdometro to set
     */
    public void setTipoOdometro(Integer TipoOdometro) {
        this.TipoOdometro = TipoOdometro;
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
     * @return String return the EstadoPlacasUSA
     */
    public String getEstadoPlacasUSA() {
        return EstadoPlacasUSA;
    }

    /**
     * @param EstadoPlacasUSA the EstadoPlacasUSA to set
     */
    public void setEstadoPlacasUSA(String EstadoPlacasUSA) {
        this.EstadoPlacasUSA = EstadoPlacasUSA;
    }

    /**
     * @return Integer return the TipoPermiso
     */
    public Integer getTipoPermiso() {
        return TipoPermiso;
    }

    /**
     * @param TipoPermiso the TipoPermiso to set
     */
    public void setTipoPermiso(Integer TipoPermiso) {
        this.TipoPermiso = TipoPermiso;
    }

    /**
     * @return Byte return the SinOdometro
     */
    public Byte getSinOdometro() {
        return SinOdometro;
    }

    /**
     * @param SinOdometro the SinOdometro to set
     */
    public void setSinOdometro(Byte SinOdometro) {
        this.SinOdometro = SinOdometro;
    }

    /**
     * @return Integer return the RegistroID
     */
    public Integer getRegistroID() {
        return RegistroID;
    }

    /**
     * @param RegistroID the RegistroID to set
     */
    public void setRegistroID(Integer RegistroID) {
        this.RegistroID = RegistroID;
    }

    /**
     * @return String return the GPSID
     */
    public String getGPSID() {
        return GPSID;
    }

    /**
     * @param GPSID the GPSID to set
     */
    public void setGPSID(String GPSID) {
        this.GPSID = GPSID;
    }

    /**
     * @return String return the Lat
     */
    public String getLat() {
        return Lat;
    }

    /**
     * @param Lat the Lat to set
     */
    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    /**
     * @return String return the Lon
     */
    public String getLon() {
        return Lon;
    }

    /**
     * @param Lon the Lon to set
     */
    public void setLon(String Lon) {
        this.Lon = Lon;
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
     * @return Float return the UltimoOdometro
     */
    public Float getUltimoOdometro() {
        return UltimoOdometro;
    }

    /**
     * @param UltimoOdometro the UltimoOdometro to set
     */
    public void setUltimoOdometro(Float UltimoOdometro) {
        this.UltimoOdometro = UltimoOdometro;
    }

    /**
     * @return Integer return the PatioActualID
     */
    public Integer getPatioActualID() {
        return PatioActualID;
    }

    /**
     * @param PatioActualID the PatioActualID to set
     */
    public void setPatioActualID(Integer PatioActualID) {
        this.PatioActualID = PatioActualID;
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
     * @return Date return the FechaMantenimiento
     */
    public Date getFechaMantenimiento() {
        return FechaMantenimiento;
    }

    /**
     * @param FechaMantenimiento the FechaMantenimiento to set
     */
    public void setFechaMantenimiento(Date FechaMantenimiento) {
        this.FechaMantenimiento = FechaMantenimiento;
    }

    /**
     * @return Float return the TanqueActual
     */
    public Float getTanqueActual() {
        return TanqueActual;
    }

    /**
     * @param TanqueActual the TanqueActual to set
     */
    public void setTanqueActual(Float TanqueActual) {
        this.TanqueActual = TanqueActual;
    }

    /**
     * @return Float return the Rendimiento
     */
    public Float getRendimiento() {
        return Rendimiento;
    }

    /**
     * @param Rendimiento the Rendimiento to set
     */
    public void setRendimiento(Float Rendimiento) {
        this.Rendimiento = Rendimiento;
    }

    /**
     * @return Integer return the ItinerarioFK
     */
    public Integer getItinerarioFK() {
        return ItinerarioFK;
    }

    /**
     * @param ItinerarioFK the ItinerarioFK to set
     */
    public void setItinerarioFK(Integer ItinerarioFK) {
        this.ItinerarioFK = ItinerarioFK;
    }

    /**
     * @return String return the NumIFTA
     */
    public String getNumIFTA() {
        return NumIFTA;
    }

    /**
     * @param NumIFTA the NumIFTA to set
     */
    public void setNumIFTA(String NumIFTA) {
        this.NumIFTA = NumIFTA;
    }

    /**
     * @return String return the TarjetaCombustible
     */
    public String getTarjetaCombustible() {
        return TarjetaCombustible;
    }

    /**
     * @param TarjetaCombustible the TarjetaCombustible to set
     */
    public void setTarjetaCombustible(String TarjetaCombustible) {
        this.TarjetaCombustible = TarjetaCombustible;
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
     * @return Integer return the UsuarioEli
     */
    public Integer getUsuarioEli() {
        return UsuarioEli;
    }

    /**
     * @param UsuarioEli the UsuarioEli to set
     */
    public void setUsuarioEli(Integer UsuarioEli) {
        this.UsuarioEli = UsuarioEli;
    }

    /**
     * @return String return the NotaEli
     */
    public String getNotaEli() {
        return NotaEli;
    }

    /**
     * @param NotaEli the NotaEli to set
     */
    public void setNotaEli(String NotaEli) {
        this.NotaEli = NotaEli;
    }

    /**
     * @return Date return the FechaEli
     */
    public Date getFechaEli() {
        return FechaEli;
    }

    /**
     * @param FechaEli the FechaEli to set
     */
    public void setFechaEli(Date FechaEli) {
        this.FechaEli = FechaEli;
    }

    /**
     * @return Float return the MetaDiaria
     */
    public Float getMetaDiaria() {
        return MetaDiaria;
    }

    /**
     * @param MetaDiaria the MetaDiaria to set
     */
    public void setMetaDiaria(Float MetaDiaria) {
        this.MetaDiaria = MetaDiaria;
    }

    /**
     * @return String return the Comentarios
     */
    public String getComentarios() {
        return Comentarios;
    }

    /**
     * @param Comentarios the Comentarios to set
     */
    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    /**
     * @return Byte return the cIFTA
     */
    public Byte getCIFTA() {
        return cIFTA;
    }

    /**
     * @param cIFTA the cIFTA to set
     */
    public void setCIFTA(Byte cIFTA) {
        this.cIFTA = cIFTA;
    }

    /**
     * @return String return the NombreAseguradora
     */
    public String getNombreAseguradora() {
        return NombreAseguradora;
    }

    /**
     * @param NombreAseguradora the NombreAseguradora to set
     */
    public void setNombreAseguradora(String NombreAseguradora) {
        this.NombreAseguradora = NombreAseguradora;
    }

    /**
     * @return BigDecimal return the CostoporMillaMatto
     */
    public BigDecimal getCostoporMillaMatto() {
        return CostoporMillaMatto;
    }

    /**
     * @param CostoporMillaMatto the CostoporMillaMatto to set
     */
    public void setCostoporMillaMatto(BigDecimal CostoporMillaMatto) {
        this.CostoporMillaMatto = CostoporMillaMatto;
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
     * @return String return the NumPermSCT
     */
    public String getNumPermSCT() {
        return NumPermSCT;
    }

    /**
     * @param NumPermSCT the NumPermSCT to set
     */
    public void setNumPermSCT(String NumPermSCT) {
        this.NumPermSCT = NumPermSCT;
    }

    /**
     * @return String return the PermSCT
     */
    public String getPermSCT() {
        return PermSCT;
    }

    /**
     * @param PermSCT the PermSCT to set
     */
    public void setPermSCT(String PermSCT) {
        this.PermSCT = PermSCT;
    }

    /**
     * @return String return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     * @return String return the NombreAseguradoraMA
     */
    public String getNombreAseguradoraMA() {
        return NombreAseguradoraMA;
    }

    /**
     * @param NombreAseguradoraMA the NombreAseguradoraMA to set
     */
    public void setNombreAseguradoraMA(String NombreAseguradoraMA) {
        this.NombreAseguradoraMA = NombreAseguradoraMA;
    }

    /**
     * @return String return the PolizaMA
     */
    public String getPolizaMA() {
        return PolizaMA;
    }

    /**
     * @param PolizaMA the PolizaMA to set
     */
    public void setPolizaMA(String PolizaMA) {
        this.PolizaMA = PolizaMA;
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
     * @return String return the boe
     */
    public String getBoe() {
        return boe;
    }

    /**
     * @param boe the boe to set
     */
    public void setBoe(String boe) {
        this.boe = boe;
    }

    /**
     * @return String return the caat
     */
    public String getCaat() {
        return caat;
    }

    /**
     * @param caat the caat to set
     */
    public void setCaat(String caat) {
        this.caat = caat;
    }

    /**
     * @return String return the scac
     */
    public String getScac() {
        return scac;
    }

    /**
     * @param scac the scac to set
     */
    public void setScac(String scac) {
        this.scac = scac;
    }

    /**
     * @return String return the certhazmat
     */
    public String getCerthazmat() {
        return certhazmat;
    }

    /**
     * @param certhazmat the certhazmat to set
     */
    public void setCerthazmat(String certhazmat) {
        this.certhazmat = certhazmat;
    }

    /**
     * @return String return the nlic
     */
    public String getNlic() {
        return nlic;
    }

    /**
     * @param nlic the nlic to set
     */
    public void setNlic(String nlic) {
        this.nlic = nlic;
    }

    /**
     * @return Integer return the FuelGID
     */
    public Integer getFuelGID() {
        return FuelGID;
    }

    /**
     * @param FuelGID the FuelGID to set
     */
    public void setFuelGID(Integer FuelGID) {
        this.FuelGID = FuelGID;
    }

    /**
     * @return Integer return the TipoCamionID
     */
    public Integer getTipoCamionID() {
        return TipoCamionID;
    }

    /**
     * @param TipoCamionID the TipoCamionID to set
     */
    public void setTipoCamionID(Integer TipoCamionID) {
        this.TipoCamionID = TipoCamionID;
    }

    /**
     * @return String return the partetransporte
     */
    public String getPartetransporte() {
        return partetransporte;
    }

    /**
     * @param partetransporte the partetransporte to set
     */
    public void setPartetransporte(String partetransporte) {
        this.partetransporte = partetransporte;
    }

    /**
     * @return String return the tipofigura
     */
    public String getTipofigura() {
        return tipofigura;
    }

    /**
     * @param tipofigura the tipofigura to set
     */
    public void setTipofigura(String tipofigura) {
        this.tipofigura = tipofigura;
    }

}
