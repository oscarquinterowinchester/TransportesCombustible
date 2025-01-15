package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "wconticp_tbl")
public class WconticpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "WContID")
    private Integer wcontID;

    @Column(name = "ICartaID")
    private Integer ICartaID;

    @Column(name = "CartaPorteID")
    private Integer CartaPorte;

    @Column(name = "Status")
    private Byte status;

    // Getters and Setters

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Integer return the WContID
     */
    public Integer getWContID() {
        return wcontID;
    }

    /**
     * @param WContID the WContID to set
     */
    public void setWContID(Integer wcontID) {
        this.wcontID = wcontID;
    }

    /**
     * @return Integer return the ICartaID
     */
    public Integer getICartaID() {
        return ICartaID;
    }

    /**
     * @param ICartaID the ICartaID to set
     */
    public void setICartaID(Integer ICartaID) {
        this.ICartaID = ICartaID;
    }

    /**
     * @return Integer return the CartaPorte
     */
    public Integer getCartaPorte() {
        return CartaPorte;
    }

    /**
     * @param CartaPorte the CartaPorte to set
     */
    public void setCartaPorte(Integer CartaPorte) {
        this.CartaPorte = CartaPorte;
    }

    /**
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

}
