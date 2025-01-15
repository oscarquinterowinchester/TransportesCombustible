package com.appchoferes.nomina.models.durandb;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "emoperador")
public class EmOperadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ChoferID")
    private Integer choferID;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidoP")
    private String apellidoP;

    @Column(name = "apellidoM")
    private String apellidoM;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paisLic")
    private String paisLic;

    @Column(name = "estadoLic")
    private String estadoLic;


    @Column(name = "status")
    private Integer status;

    @Column(name ="fecha")
    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChoferID() {
        return choferID;
    }

    public void setChoferID(Integer choferID) {
        this.choferID = choferID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisLic() {
        return paisLic;
    }

    public void setPaisLic(String paisLic) {
        this.paisLic = paisLic;
    }

    public String getEstadoLic() {
        return estadoLic;
    }

    public void setEstadoLic(String estadoLic) {
        this.estadoLic = estadoLic;
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


/*
 * 
 * 
  `status` tinyint(4) DEFAULT 1,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1
 */
