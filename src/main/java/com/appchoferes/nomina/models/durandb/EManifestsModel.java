package com.appchoferes.nomina.models.durandb;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emanifests")
public class EManifestsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "itiid")
    private Integer itiID;

    @Column(name = "scac")
    private String scac;

    @Column(name = "usuariofk")
    private Integer usuarioFK;

    @Column(name = "status")
    private Integer status;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "nodoc")
    private String nodoc;

    
    public void setUsuarioFK(Integer usuarioFK) {
        this.usuarioFK = usuarioFK;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNodoc() {
        return nodoc;
    }

    public void setNodoc(String nodoc) {
        this.nodoc = nodoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItiID() {
        return itiID;
    }

    public void setItiID(Integer itiID) {
        this.itiID = itiID;
    }

    public String getScac() {
        return scac;
    }

    public void setScac(String scac) {
        this.scac = scac;
    }

    
}

/*
 * CREATE TABLE `emanifests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itiid` int(11) DEFAULT 0,
  `scac` varchar(20) DEFAULT '',
  `usuariofk` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 1,
  `fecha` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
 */
