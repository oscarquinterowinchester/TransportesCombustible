package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "locaciones_tbl")
public class LocacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocacionID")
    private Integer LocacionID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Byte status;

    private String Direccion;
    private String NoExterior;
    private String Estado;
    private String Pais;
    private String CP;
    private Integer ClienteID;
    // private String cliente;
    private String Municipio;
    private Byte Puerto;
    private Byte Tren;
    private String NombreCompleto;
    private String NombreCorto;
    private String CodigoL;
    private Integer PaisID;
    private Integer EstadoID;
    private String cestado;
    private Integer clocalidadid;
    private Integer cmunicipioid;
    private Integer ccoloniaid;
    private String RFCl;
    private Float longitud;
    private Float latitud;
    private Byte FiltraCP;
    private String Contacto;
    private String Telefono;
    private String geoname;
    private Byte agencia;
    private String horarios;

    // Getters and Setters

    /**
     * @return Integer return the LocacionID
     */
    public Integer getLocacionID() {
        return LocacionID;
    }

    /**
     * @param LocacionID the LocacionID to set
     */
    public void setLocacionID(Integer LocacionID) {
        this.LocacionID = LocacionID;
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
     * @return Byte return the Puerto
     */
    public Byte getPuerto() {
        return Puerto;
    }

    /**
     * @param Puerto the Puerto to set
     */
    public void setPuerto(Byte Puerto) {
        this.Puerto = Puerto;
    }

    /**
     * @return Byte return the Tren
     */
    public Byte getTren() {
        return Tren;
    }

    /**
     * @param Tren the Tren to set
     */
    public void setTren(Byte Tren) {
        this.Tren = Tren;
    }

    /**
     * @return String return the NombreCompleto
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * @param NombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    /**
     * @return String return the NombreCorto
     */
    public String getNombreCorto() {
        return NombreCorto;
    }

    /**
     * @param NombreCorto the NombreCorto to set
     */
    public void setNombreCorto(String NombreCorto) {
        this.NombreCorto = NombreCorto;
    }

    /**
     * @return String return the CodigoL
     */
    public String getCodigoL() {
        return CodigoL;
    }

    /**
     * @param CodigoL the CodigoL to set
     */
    public void setCodigoL(String CodigoL) {
        this.CodigoL = CodigoL;
    }

    /**
     * @return Integer return the PaisID
     */
    public Integer getPaisID() {
        return PaisID;
    }

    /**
     * @param PaisID the PaisID to set
     */
    public void setPaisID(Integer PaisID) {
        this.PaisID = PaisID;
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
     * @return String return the RFCl
     */
    public String getRFCl() {
        return RFCl;
    }

    /**
     * @param RFCl the RFCl to set
     */
    public void setRFCl(String RFCl) {
        this.RFCl = RFCl;
    }

    /**
     * @return Float return the longitud
     */
    public Float getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    /**
     * @return Float return the latitud
     */
    public Float getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    /**
     * @return Byte return the FiltraCP
     */
    public Byte getFiltraCP() {
        return FiltraCP;
    }

    /**
     * @param FiltraCP the FiltraCP to set
     */
    public void setFiltraCP(Byte FiltraCP) {
        this.FiltraCP = FiltraCP;
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
     * @return String return the geoname
     */
    public String getGeoname() {
        return geoname;
    }

    /**
     * @param geoname the geoname to set
     */
    public void setGeoname(String geoname) {
        this.geoname = geoname;
    }

    /**
     * @return Byte return the agencia
     */
    public Byte getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Byte agencia) {
        this.agencia = agencia;
    }

    /**
     * @return String return the horarios
     */
    public String getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

}
