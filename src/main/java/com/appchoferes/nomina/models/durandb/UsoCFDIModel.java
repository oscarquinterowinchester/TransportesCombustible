package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "usocfdi_tbl")
public class UsoCFDIModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsoID")
    private Integer UsoID;

    @Column(name = "Codigo")
    private String Codigo;

    @Column(name = "Nombre")
    private String Nombre;

    // Getters and Setters

    /**
     * @return Integer return the UsoID
     */
    public Integer getUsoID() {
        return UsoID;
    }

    /**
     * @param UsoID the UsoID to set
     */
    public void setUsoID(Integer UsoID) {
        this.UsoID = UsoID;
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
