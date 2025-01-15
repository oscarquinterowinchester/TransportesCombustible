package com.appchoferes.nomina.models.durandb;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "paradaswc_tbl")
public class ParadaswcModel {
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

}
