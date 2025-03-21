package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "registro_entradas_salidas_tbl")
public class RegistroEntradaSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ChoferID")
    private int choferID;

    @Column(name = "Firma", columnDefinition = "TEXT")
    private String firma;

    @Column(name = "FechaEntrada")
    private String fechaEntrada;

    @Column(name = "FechaSalida")
    private String fechaSalida;

    @Column(name = "Fecha")
    private String fecha;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChoferID() {
        return choferID;
    }

    public void setChoferID(int choferID) {
        this.choferID = choferID;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
