package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "tiposunidad_tbl")
public class TiposUnidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipoUID")
    private Integer TipoUID;

    @Column(name = "Nombre")
    private String Nombre;

    /**
     * @return Integer return the TipoUID
     */
    public Integer getTipoUID() {
        return TipoUID;
    }

    /**
     * @param TipoUID the TipoUID to set
     */
    public void setTipoUID(Integer TipoUID) {
        this.TipoUID = TipoUID;
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
