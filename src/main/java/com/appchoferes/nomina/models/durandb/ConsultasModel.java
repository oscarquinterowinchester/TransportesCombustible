package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas_tbl")
public class ConsultasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dato")
    private boolean dato;
    @Column(name = "ConceptoSAT")
    private String ConceptoSAT;
    @Column(name = "UnidadSAT")
    private String UnidadSAT;
    @Column(name = "DescripcionCompleta")
    private String DescripcionCompleta;

    
    
    // getters and setters

    /**
     * @return String return the DescripcionCompleta
     */
    public String getDescripcionCompleta() {
        return DescripcionCompleta;
    }

    /**
     * @param DescripcionCompleta the DescripcionCompleta to set
     */
    public void setDescripcionCompleta(String DescripcionCompleta) {
        this.DescripcionCompleta = DescripcionCompleta;
    }

    /**
     * @return String return the ConceptoSAT
     */
    public String getConceptoSAT() {
        return ConceptoSAT;
    }

    /**
     * @param ConceptoSAT the ConceptoSAT to set
     */
    public void setConceptoSAT(String ConceptoSAT) {
        this.ConceptoSAT = ConceptoSAT;
    }

    /**
     * @return Integer return the EmpresaID
     */
    public String getUnidadSAT() {
        return UnidadSAT;
    }

    /**
     * @param UnidadSAT the UnidadSAT to set
     */
    public void setUnidadSAT(String UnidadSAT) {
        this.UnidadSAT = UnidadSAT;
    }

    /**
     * @return Integer return the EmpresaID
     */
    public boolean getDato() {
        return dato;
    }

    /**
     * @param dato the EmpresaID to set
     */
    public void setDato(boolean dato) {
        this.dato = dato;
    }

}
