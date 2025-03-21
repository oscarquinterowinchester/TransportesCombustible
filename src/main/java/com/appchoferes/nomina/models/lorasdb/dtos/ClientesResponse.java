package com.appchoferes.nomina.models.lorasdb.dtos;

import java.util.List;

import com.appchoferes.nomina.models.lorasdb.Cliente;

public class ClientesResponse {

    private List<Cliente> clientes1;
    private List<Cliente> clientes2;

    public List<Cliente> getClientes1() {
        return clientes1;
    }

    public void setCliente1(List<Cliente> clientes1) {
        this.clientes1 = clientes1;
    }

    public List<Cliente> getClientes2() {
        return clientes2;
    }

    public void setClientes2(List<Cliente> clientes2) {
        this.clientes2 = clientes2;
    }

    public ClientesResponse(List<Cliente> clientes1, List<Cliente> clientes2) {
        this.clientes1 = clientes1;
        this.clientes2 = clientes2;
    }

}
