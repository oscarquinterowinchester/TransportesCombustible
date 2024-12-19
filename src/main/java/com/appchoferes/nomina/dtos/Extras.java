package com.appchoferes.nomina.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Extras {
    @Id
    Long id;
    String name;
    Integer amount;
    Integer m0;
    Integer m1;
    String divisa;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getM0() {
        return m0;
    }
    public void setM0(Integer m0) {
        this.m0 = m0;
    }
    public Integer getM1() {
        return m1;
    }
    public void setM1(Integer m1) {
        this.m1 = m1;
    }
    public String getDivisa() {
        return divisa;
    }
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }    
}
