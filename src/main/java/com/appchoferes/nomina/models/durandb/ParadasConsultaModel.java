package com.appchoferes.nomina.models.durandb;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas_tbl")
public class ParadasConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "wcontfk")
    private Integer wcontfk;

    @Column(name = "tipop")
    private Integer tipop;

    @Column(name = "locacionfk")
    private Integer locacionfk;

    @Column(name = "ruta")
    private Byte ruta;

    @Column(name = "status")
    private Byte status;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "fechacita")
    private LocalDateTime fechacita;

    @Column(name = "TipoParada")
    private String TipoParada;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Direccion")
    private String Direccion;
    
    @Column(name = "Pais")
    private String Pais;

    @Column(name = "RFC")
    private String RFC;

    @Column(name = "codigoSat")
    private String codigoSat;

    @Column(name = "KM")
    private String KM;



    // Getters and setters

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Integer return the wcontfk
     */
    public Integer getWcontfk() {
        return wcontfk;
    }

    /**
     * @param wcontfk the wcontfk to set
     */
    public void setWcontfk(Integer wcontfk) {
        this.wcontfk = wcontfk;
    }

    /**
     * @return Integer return the tipop
     */
    public Integer getTipop() {
        return tipop;
    }

    /**
     * @param tipop the tipop to set
     */
    public void setTipop(Integer tipop) {
        this.tipop = tipop;
    }

    /**
     * @return Integer return the locacionfk
     */
    public Integer getLocacionfk() {
        return locacionfk;
    }

    /**
     * @param locacionfk the locacionfk to set
     */
    public void setLocacionfk(Integer locacionfk) {
        this.locacionfk = locacionfk;
    }

    /**
     * @return Byte return the ruta
     */
    public Byte getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(Byte ruta) {
        this.ruta = ruta;
    }

    /**
     * @return Byte return the status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return Integer return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    /**
     * @return LocalDateTime return the fechacita
     */
    public LocalDateTime getfechacita() {
        return fechacita;
    }

    /**
     * @param fechacita the fechacita to set
     */
    public void setfechacita(LocalDateTime fechacita) {
        this.fechacita = fechacita;
    }

    /**
     * @return String return the TipoParada
     */
    public String getTipoParada() {
        return TipoParada;
    }

    /**
     * @param TipoParada the TipoParada to set
     */
    public void setTipoParada(String TipoParada) {
        this.TipoParada = TipoParada;
    }

    /**
     * @return String return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param TipoPaNombrerada the Nombre to set
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
     * @return String return the Pais
     */
    public String getPais() {
        return Pais;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    /**
     * @return String return the Direccion
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
     * @return String return the codigoSat
     */
    public String getcodigoSat() {
        return codigoSat;
    }

    /**
     * @param codigoSat the codigoSat to set
     */
    public void setcodigoSat(String codigoSat) {
        this.codigoSat = codigoSat;
    }

    /**
     * @return String return the KM
     */
    public String getKM() {
        return KM;
    }

    /**
     * @param KM the KM to set
     */
    public void setKM(String KM) {
        this.KM = KM;
    }
}
