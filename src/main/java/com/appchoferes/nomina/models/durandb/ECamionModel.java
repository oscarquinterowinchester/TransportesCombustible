package com.appchoferes.nomina.models.durandb;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "emcamion")
public class ECamionModel {
    /*
     * 
     * 
     * 
     * `id` int(11) NOT NULL AUTO_INCREMENT,
  `camionfk` int(11) DEFAULT NULL,
  `codigo` varchar(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 1,
  `fecha` datetime DEFAULT current_timestamp(),
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "camionfk")
    private Integer camionFK;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private Integer status;

    @Column(name = "fecha")
    private Date fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCamionFK() {
        return camionFK;
    }

    public void setCamionFK(Integer camionFK) {
        this.camionFK = camionFK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

}
