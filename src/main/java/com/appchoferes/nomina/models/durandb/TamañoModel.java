package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "tamanoremo_tbl")
public class TamañoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TamanoID")
    private Integer TamanoID;

    @Column(name = "Tamano")
    private String Tamano;

    // Getters and Setters

    /**
     * @return Integer return the TamanoID
     */
    public Integer getTamanoID() {
        return TamanoID;
    }

    /**
     * @param TamanoID the TamanoID to set
     */
    public void setTamanoID(Integer TamanoID) {
        this.TamanoID = TamanoID;
    }

    /**
     * @return String return the Tamano
     */
    public String getTamano() {
        return Tamano;
    }

    /**
     * @param Tamano the Tamano to set
     */
    public void setTamano(String Tamano) {
        this.Tamano = Tamano;
    }

}
