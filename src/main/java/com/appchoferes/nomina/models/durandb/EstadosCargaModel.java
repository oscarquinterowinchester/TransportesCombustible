package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "estadoscarga_tbl")
public class EstadosCargaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "estadocr")
    private Integer estadocr;

    @Column(name = "ncorto")
    private String ncorto;

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
     * @return Integer return the estadocr
     */
    public Integer getEstadocr() {
        return estadocr;
    }

    /**
     * @param estadocr the estadocr to set
     */
    public void setEstadocr(Integer estadocr) {
        this.estadocr = estadocr;
    }

    /**
     * @return String return the ncorto
     */
    public String getNcorto() {
        return ncorto;
    }

    /**
     * @param ncorto the ncorto to set
     */
    public void setNcorto(String ncorto) {
        this.ncorto = ncorto;
    }

}
