package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "estados_tbl")
public class EstadosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstadoID")
    private Integer EstadoID;

    @Column(name = "paisID")
    private Integer paisID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Abreviacion")
    private String Abreviacion;

    // Setters and Getters

    /**
     * @return Integer return the EstadoID
     */
    public Integer getEstadoID() {
        return EstadoID;
    }

    /**
     * @param EstadoID the EstadoID to set
     */
    public void setEstadoID(Integer EstadoID) {
        this.EstadoID = EstadoID;
    }

    /**
     * @return Integer return the PaisID
     */
    public Integer getPaisID() {
        return paisID;
    }

    /**
     * @param paisID the PaisID to set
     */
    public void setPaisID(Integer paisID) {
        this.paisID = paisID;
    }

    /**
     * @return String return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return String return the Abreviacion
     */
    public String getAbreviacion() {
        return Abreviacion;
    }

    /**
     * @param Abreviacion the Abreviacion to set
     */
    public void setAbreviacion(String Abreviacion) {
        this.Abreviacion = Abreviacion;
    }

}
