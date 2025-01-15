package com.appchoferes.nomina.models.durandb;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cajas_tbl")
public class CajasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CajaID")
    private Integer CajaID;

    @Column(name = "NoEconomico")
    private String NoEconomico;

    @Column(name = "Status")
    private Boolean Status;

    @Column(name = "Modelo")
    private String Modelo;

    @Column(name = "Serie")
    private String Serie;

    @Column(name = "Tamano")
    private String Tamano;

    @Column(name = "Tipo")
    private Integer Tipo;

    @Column(name = "Tanque")
    private Float Tanque;

    @Column(name = "Placas")
    private String Placas;

    @Column(name = "ExpPlacas")
    private Date ExpPlacas;

    @Column(name = "Fecha")
    private Date Fecha;

    @Column(name = "Estado")
    private Integer Estado;

    @Column(name = "Categoria")
    private Integer Categoria;

    @Column(name = "PlacasUSA")
    private String PlacasUSA;

    @Column(name = "EstadoPlacas")
    private String EstadoPlacas;

    @Column(name = "EstadoPlacasUSA")
    private String EstadoPlacasUSA;

    @Column(name = "Marca")
    private String Marca;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ExpPlacasUSA")
    private Date ExpPlacasUSA;

    @Column(name = "Pertenece")
    private Integer Pertenece;

    @Column(name = "UNegocioID")
    private Integer UNegocioID;

    @Column(name = "UsuarioMod")
    private Integer UsuarioMod;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FechaMod")
    private Date FechaMod;

    @Column(name = "Comentarios")
    private String Comentarios;

    @Column(name = "SubTipoRem")
    private String SubTipoRem;

    @Column(name = "empresaID")
    private Integer empresaID;

    @Column(name = "descr")
    private String descr;

    @Column(name = "clasificacion")
    private String clasificacion;

    @Column(name = "operacion")
    private String operacion;

    @Column(name = "tarifamensual")
    private String tarifamensual;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "proveedorID")
    private Integer proveedorID;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_alquiler")
    private Date fecha_alquiler;

    @Column(name = "estatus_caja")
    private String estatus_caja;

    // Getters and Setters

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
     * @return String return the NoEconomico
     */
    public String getNoEconomico() {
        return NoEconomico;
    }

    /**
     * @param NoEconomico the NoEconomico to set
     */
    public void setNoEconomico(String NoEconomico) {
        this.NoEconomico = NoEconomico;
    }

    /**
     * @return Boolean return the Status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    /**
     * @return String return the Modelo
     */
    public String getModelo() {
        return Modelo;
    }

    /**
     * @param Modelo the Modelo to set
     */
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    /**
     * @return String return the Serie
     */
    public String getSerie() {
        return Serie;
    }

    /**
     * @param Serie the Serie to set
     */
    public void setSerie(String Serie) {
        this.Serie = Serie;
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
     * @return Integer return the Tipo
     */
    public Integer getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return Float return the Tanque
     */
    public Float getTanque() {
        return Tanque;
    }

    /**
     * @param Tanque the Tanque to set
     */
    public void setTanque(Float Tanque) {
        this.Tanque = Tanque;
    }

    /**
     * @return String return the Placas
     */
    public String getPlacas() {
        return Placas;
    }

    /**
     * @param Placas the Placas to set
     */
    public void setPlacas(String Placas) {
        this.Placas = Placas;
    }

    /**
     * @return Date return the ExpPlacas
     */
    public Date getExpPlacas() {
        return ExpPlacas;
    }

    /**
     * @param ExpPlacas the ExpPlacas to set
     */
    public void setExpPlacas(Date ExpPlacas) {
        this.ExpPlacas = ExpPlacas;
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
     * @return Integer return the Categoria
     */
    public Integer getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(Integer Categoria) {
        this.Categoria = Categoria;
    }

    /**
     * @return String return the PlacasUSA
     */
    public String getPlacasUSA() {
        return PlacasUSA;
    }

    /**
     * @param PlacasUSA the PlacasUSA to set
     */
    public void setPlacasUSA(String PlacasUSA) {
        this.PlacasUSA = PlacasUSA;
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
     * @return String return the Marca
     */
    public String getMarca() {
        return Marca;
    }

    /**
     * @param Marca the Marca to set
     */
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    /**
     * @return Date return the ExpPlacasUSA
     */
    public Date getExpPlacasUSA() {
        return ExpPlacasUSA;
    }

    /**
     * @param ExpPlacasUSA the ExpPlacasUSA to set
     */
    public void setExpPlacasUSA(Date ExpPlacasUSA) {
        this.ExpPlacasUSA = ExpPlacasUSA;
    }

    /**
     * @return Integer return the Pertenece
     */
    public Integer getPertenece() {
        return Pertenece;
    }

    /**
     * @param Pertenece the Pertenece to set
     */
    public void setPertenece(Integer Pertenece) {
        this.Pertenece = Pertenece;
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
     * @return String return the SubTipoRem
     */
    public String getSubTipoRem() {
        return SubTipoRem;
    }

    /**
     * @param SubTipoRem the SubTipoRem to set
     */
    public void setSubTipoRem(String SubTipoRem) {
        this.SubTipoRem = SubTipoRem;
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
     * @return String return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return String return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return String return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     * @return String return the tarifamensual
     */
    public String getTarifamensual() {
        return tarifamensual;
    }

    /**
     * @param tarifamensual the tarifamensual to set
     */
    public void setTarifamensual(String tarifamensual) {
        this.tarifamensual = tarifamensual;
    }

    /**
     * @return String return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

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
     * @return Date return the fecha_alquiler
     */
    public Date getFecha_alquiler() {
        return fecha_alquiler;
    }

    /**
     * @param fecha_alquiler the fecha_alquiler to set
     */
    public void setFecha_alquiler(Date fecha_alquiler) {
        this.fecha_alquiler = fecha_alquiler;
    }

    /**
     * @return String return the estatus_caja
     */
    public String getEstatus_caja() {
        return estatus_caja;
    }

    /**
     * @param estatus_caja the estatus_caja to set
     */
    public void setEstatus_caja(String estatus_caja) {
        this.estatus_caja = estatus_caja;
    }

}
