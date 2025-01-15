package com.appchoferes.nomina.models.durandb;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "fuel_group_tbl")
public class FuelGroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FuelGID")
    private Integer FuelGID;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Status")
    private Integer Status;

    @Column(name = "Min", precision = 10, scale = 2)
    private BigDecimal Min;

    @Column(name = "Max", precision = 10, scale = 2)
    private BigDecimal Max;

    // Setter and Getters

    /**
     * @return Integer return the FuelGID
     */
    public Integer getFuelGID() {
        return FuelGID;
    }

    /**
     * @param FuelGID the FuelGID to set
     */
    public void setFuelGID(Integer FuelGID) {
        this.FuelGID = FuelGID;
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
     * @return Integer return the Status
     */
    public Integer getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(Integer Status) {
        this.Status = Status;
    }

    /**
     * @return BigDecimal return the Min
     */
    public BigDecimal getMin() {
        return Min;
    }

    /**
     * @param Min the Min to set
     */
    public void setMin(BigDecimal Min) {
        this.Min = Min;
    }

    /**
     * @return BigDecimal return the Max
     */
    public BigDecimal getMax() {
        return Max;
    }

    /**
     * @param Max the Max to set
     */
    public void setMax(BigDecimal Max) {
        this.Max = Max;
    }

}
