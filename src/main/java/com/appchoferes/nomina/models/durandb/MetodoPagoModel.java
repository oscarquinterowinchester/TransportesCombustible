package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "metodospago_tbl")
public class MetodoPagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MetodoID")
    private Integer MetodoID;

    @Column(name = "Codigo")
    private String Codigo;

    @Column(name = "Nombre")
    private String Nombre;

    // Getters and Setter

    /**
     * @return Integer return the MetodoID
     */
    public Integer getMetodoID() {
        return MetodoID;
    }

    /**
     * @param MetodoID the MetodoID to set
     */
    public void setMetodoID(Integer MetodoID) {
        this.MetodoID = MetodoID;
    }

    /**
     * @return String return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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

}
