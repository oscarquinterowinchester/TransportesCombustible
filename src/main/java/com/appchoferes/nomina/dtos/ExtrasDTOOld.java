package com.appchoferes.nomina.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ExtrasDTOOld {
    @Id
    Long id;
    String description;
    Integer currency;
    Integer quantity;
    String type;
    Integer amount;
    String divisa;
    Integer status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getCurrency() {
        return currency;
    }
    public void setCurrency(Integer currency) {
        this.currency = currency;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getDivisa() {
        return divisa;
    }
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }


}
