package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "tipocajas_tbl")
public class TipoCajasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoID")
    private Integer TipoID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Tipo")
    private Integer Tipo;

    // Getters and Setters

    /**
     * @return Integer return the TipoID
     */
    public Integer getTipoID() {
        return TipoID;
    }

    /**
     * @param TipoID the TipoID to set
     */
    public void setTipoID(Integer TipoID) {
        this.TipoID = TipoID;
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
     * @return Integer return the Tipo
     */
    public Integer getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(Integer Tipo) {
        this.Tipo = Tipo;
    }

}
