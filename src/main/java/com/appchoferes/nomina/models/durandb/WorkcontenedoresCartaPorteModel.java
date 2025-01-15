package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "workcontenedores_cartaporte")
public class WorkcontenedoresCartaPorteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ClaveProdServCP")
    private String claveProductoServicio;

    @Column(name = "ClaveProdServCP_descripcion")
    private String descripcionClaveProductoServicio;

    @Column(name = "ClaveUnidad")
    private String claveUnidad;

    @Column(name = "Unidad")
    private String unidad;

    @Column(name = "Cantidad")
    private Float cantidad;

    @Column(name = "MaterialPeligroso")
    private String materialPeligroso;

    @Column(name = "CveMaterialPeligroso")
    private String codigoMaterialPeligroso;

    @Column(name = "Embalaje")
    private String embalaje;

    @Column(name = "DescripEmbalaje")
    private String descripcionEmbalaje;

    @Column(name = "PesoEnKg")
    private Float peso;

    @Column(name = "ValorMercancia")
    private Integer valor;

    @Column(name = "Moneda")
    private String moneda;

    @Column(name = "FraccionArancelaria")
    private String fraccion;

    @Column(name = "UUIDComercioExt")
    private String uuid;

    @Column(name = "Dimensiones")
    private String dimensiones;

    @Column(name = "Pedimentos")
    private String pedimento;

    @Column(name = "WContID")
    private Integer wcontID;    

    @Column(name = "IcontID")
    private Integer icontID;

    @Column(name = "TipoMateria")
    private String  tipoMateria;

    @Column(name = "TipoDocumento")
    private String  tipoDocumento;

    @Column(name = "rfcimpo")
    private String  rfcimpo;

    @Column(name = "perfilTipo")
    private Integer perfilTipo;

    public Integer getperfilTipo() {
        return perfilTipo;
    }

    public void setperfilTipo(Integer perfilTipo) {
        this.perfilTipo = perfilTipo;
    }

    public String getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(String tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getrfcimpo() {
        return rfcimpo;
    }

    public void setrfcimpo(String rfcimpo) {
        this.rfcimpo = rfcimpo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaveProductoServicio() {
        return claveProductoServicio;
    }

    public void setClaveProductoServicio(String claveProductoServicio) {
        this.claveProductoServicio = claveProductoServicio;
    }

    public String getDescripcionClaveProductoServicio() {
        return descripcionClaveProductoServicio;
    }

    public void setDescripcionClaveProductoServicio(String descripcionClaveProductoServicio) {
        this.descripcionClaveProductoServicio = descripcionClaveProductoServicio;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getMaterialPeligroso() {
        return materialPeligroso;
    }

    public void setMaterialPeligroso(String materialPeligroso) {
        this.materialPeligroso = materialPeligroso;
    }

    public String getCodigoMaterialPeligroso() {
        return codigoMaterialPeligroso;
    }

    public void setCodigoMaterialPeligroso(String codigoMaterialPeligroso) {
        this.codigoMaterialPeligroso = codigoMaterialPeligroso;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    public String getDescripcionEmbalaje() {
        return descripcionEmbalaje;
    }

    public void setDescripcionEmbalaje(String descripcionEmbalaje) {
        this.descripcionEmbalaje = descripcionEmbalaje;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        this.fraccion = fraccion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getPedimento() {
        return pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public Integer getWcontID() {
        return wcontID;
    }

    public void setWcontID(Integer wcontID) {
        this.wcontID = wcontID;
    }

    public Integer getIcontID() {
        return icontID;
    }

    public void setIcontID(Integer icontID) {
        this.icontID = icontID;
    }

}
