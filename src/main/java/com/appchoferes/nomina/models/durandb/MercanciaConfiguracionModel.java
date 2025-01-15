package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "mercancia_config_tbl")
public class MercanciaConfiguracionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MercaConfigID")
    private Integer mercaConfigID;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "ClaveProdServCP")
    private Integer claveProductoServicio;

    @Column(name = "ClaveProdServCP_descripcion")
    private Integer descripcionClaveProductoServicio;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "ClaveUnidad")
    private Integer claveUnidad;

    @Column(name = "Unidad")
    private Integer unidad;

    @Column(name = "Dimensiones")
    private Integer dimensiones;

    @Column(name = "MatPel")
    private Integer materialPeligroso;

    @Column(name = "MatPelCod")
    private Integer codigoMaterialPeligroso;

    @Column(name = "Embalaje")
    private Integer embalaje;

    @Column(name = "Embalaje_Desc")
    private Integer descripcionEmbalaje;

    @Column(name = "Peso")
    private Integer peso;

    @Column(name = "Valor")
    private Integer valor;

    @Column(name = "Moneda")
    private Integer moneda;

    @Column(name = "Fraccion")
    private Integer fraccion;

    @Column(name = "UUID")
    private Integer uuid;

    @Column(name = "Pedimento")
    private Integer pedimento;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Renglon")
    private Integer renglon;

    @Column(name = "Cliente_id")
    private Integer clienteId;
    
    @Column(name = "TipoDocumento")
    private Integer tipoDocumento;

    @Column(name = "RFCImpo")
    private Integer rfcimpo;
    
    @Column(name = "TipoMateria")
    private Integer tipoMateria;

    @Column(name = "regimenaduanero")
    private Integer regimenAduanero;

    public Integer getMercaConfigID() {
        return mercaConfigID;
    }

    public void setMercaConfigID(Integer mercaConfigID) {
        this.mercaConfigID = mercaConfigID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getClaveProductoServicio() {
        return claveProductoServicio;
    }

    public void setClaveProductoServicio(Integer claveProductoServicio) {
        this.claveProductoServicio = claveProductoServicio;
    }

    public Integer getDescripcionClaveProductoServicio() {
        return descripcionClaveProductoServicio;
    }

    public void setDescripcionClaveProductoServicio(Integer descripcionClaveProductoServicio) {
        this.descripcionClaveProductoServicio = descripcionClaveProductoServicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(Integer claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public Integer getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(Integer dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Integer getMaterialPeligroso() {
        return materialPeligroso;
    }

    public void setMaterialPeligroso(Integer materialPeligroso) {
        this.materialPeligroso = materialPeligroso;
    }

    public Integer getCodigoMaterialPeligroso() {
        return codigoMaterialPeligroso;
    }

    public void setCodigoMaterialPeligroso(Integer codigoMaterialPeligroso) {
        this.codigoMaterialPeligroso = codigoMaterialPeligroso;
    }

    public Integer getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Integer embalaje) {
        this.embalaje = embalaje;
    }

    public Integer getDescripcionEmbalaje() {
        return descripcionEmbalaje;
    }

    public void setDescripcionEmbalaje(Integer descripcionEmbalaje) {
        this.descripcionEmbalaje = descripcionEmbalaje;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getMoneda() {
        return moneda;
    }

    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    public Integer getFraccion() {
        return fraccion;
    }

    public void setFraccion(Integer fraccion) {
        this.fraccion = fraccion;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getPedimento() {
        return pedimento;
    }

    public void setPedimento(Integer pedimento) {
        this.pedimento = pedimento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRenglon() {
        return renglon;
    }

    public void setRenglon(Integer renglon) {
        this.renglon = renglon;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Integer tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getRfcimpo() {
        return rfcimpo;
    }

    public void setRfcimpo(Integer rfcimpo) {
        this.rfcimpo = rfcimpo;
    }

    public Integer getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(Integer tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public Integer getRegimenAduanero() {
        return regimenAduanero;
    }

    public void setRegimenAduanero(Integer regimenAduanero) {
        this.regimenAduanero = regimenAduanero;
    }

    
}
