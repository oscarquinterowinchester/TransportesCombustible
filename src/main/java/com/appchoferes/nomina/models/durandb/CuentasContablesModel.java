package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentascontables_tbl")
public class CuentasContablesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CuentaID")
    private Integer CuentaID;

    @Column(name = "Cuenta")
    private String Cuenta;

    @Column(name = "Status")
    private Byte Status;
    // Getters and Setters

    /**
     * @return Integer return the CuentaID
     */
    public Integer getCuentaID() {
        return CuentaID;
    }

    /**
     * @param CuentaID the CuentaID to set
     */
    public void setCuentaID(Integer CuentaID) {
        this.CuentaID = CuentaID;
    }

    /**
     * @return String return the Cuenta
     */
    public String getCuenta() {
        return Cuenta;
    }

    /**
     * @param Cuenta the Cuenta to set
     */
    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    /**
     * @return Byte return the Status
     */
    public Byte getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Byte Status) {
        this.Status = Status;
    }

}
