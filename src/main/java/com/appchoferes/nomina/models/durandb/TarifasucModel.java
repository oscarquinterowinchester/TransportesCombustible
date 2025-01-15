package com.appchoferes.nomina.models.durandb;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tarifasuc_tbl")
public class TarifasucModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rutafk")
    private Integer rutafk;

    @Column(name = "tipoufk")
    private Integer tipoufk;

    @Column(name = "estadoc")
    private Integer estadoc;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "Status")
    private Byte Status;

    @Column(name = "usuariofk")
    private Integer usuariofk;

    @Column(name = "moneda")
    private Integer moneda;

    @Column(name = "importe")
    private Float importe;

    @Column(name = "importeccp")
    private Float importeccp;

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
     * @return Integer return the rutafk
     */
    public Integer getRutafk() {
        return rutafk;
    }

    /**
     * @param rutafk the rutafk to set
     */
    public void setRutafk(Integer rutafk) {
        this.rutafk = rutafk;
    }

    /**
     * @return Integer return the tipoufk
     */
    public Integer getTipoufk() {
        return tipoufk;
    }

    /**
     * @param tipoufk the tipoufk to set
     */
    public void setTipoufk(Integer tipoufk) {
        this.tipoufk = tipoufk;
    }

    /**
     * @return Integer return the estadoc
     */
    public Integer getEstadoc() {
        return estadoc;
    }

    /**
     * @param estadoc the estadoc to set
     */
    public void setEstadoc(Integer estadoc) {
        this.estadoc = estadoc;
    }

    /**
     * @return LocalDateTime return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    /**
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.Status = Status;
    }

    /**
     * @return Integer return the usuariofk
     */
    public Integer getUsuariofk() {
        return usuariofk;
    }

    /**
     * @param usuariofk the usuariofk to set
     */
    public void setUsuariofk(Integer usuariofk) {
        this.usuariofk = usuariofk;
    }

    /**
     * @return Integer return the moneda
     */
    public Integer getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(Integer moneda) {
        this.moneda = moneda;
    }

    /**
     * @return Float return the importe
     */
    public Float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(Float importe) {
        this.importe = importe;
    }

    /**
     * @return Float return the importeccp
     */
    public Float getImporteccp() {
        return importeccp;
    }

    /**
     * @param importeccp the importeccp to set
     */
    public void setImporteccp(Float importeccp) {
        this.importeccp = importeccp;
    }

}
