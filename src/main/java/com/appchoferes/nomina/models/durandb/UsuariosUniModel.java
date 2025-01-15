package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "usuariosuni_tbl")
public class UsuariosUniModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioUID")
    private Integer UsuarioUID;

    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "CamionID")
    private Integer CamionID;

    // getters and setter

    /**
     * @return Integer return the UsuarioUID
     */
    public Integer getUsuarioUID() {
        return UsuarioUID;
    }

    /**
     * @param UsuarioUID the UsuarioUID to set
     */
    public void setUsuarioUID(Integer UsuarioUID) {
        this.UsuarioUID = UsuarioUID;
    }

    /**
     * @return Integer return the UsuarioID
     */
    public Integer getUsuarioID() {
        return UsuarioID;
    }

    /**
     * @param UsuarioID the UsuarioID to set
     */
    public void setUsuarioID(Integer UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    /**
     * @return Integer return the CamionID
     */
    public Integer getCamionID() {
        return CamionID;
    }

    /**
     * @param CamionID the CamionID to set
     */
    public void setCamionID(Integer CamionID) {
        this.CamionID = CamionID;
    }

}
