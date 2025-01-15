package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "conceptossatr_tbl")
public class ConceptossatrModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConceptoID")
    private Integer ConceptoID;

    @Column(name = "Concepto")
    private String Concepto;

    @Column(name = "Unidad")
    private String Unidad;

    @Column(name = "Codigo")
    private String Codigo;

    // Getters and Setters

    /**
     * @return Integer return the ConceptoID
     */
    public Integer getConceptoID() {
        return ConceptoID;
    }

    /**
     * @param ConceptoID the ConceptoID to set
     */
    public void setConceptoID(Integer ConceptoID) {
        this.ConceptoID = ConceptoID;
    }

    /**
     * @return String return the Concepto
     */
    public String getConcepto() {
        return Concepto;
    }

    /**
     * @param Concepto the Concepto to set
     */
    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    /**
     * @return String return the Unidad
     */
    public String getUnidad() {
        return Unidad;
    }

    /**
     * @param Unidad the Unidad to set
     */
    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
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

}
