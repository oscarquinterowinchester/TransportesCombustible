package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Cliente;
import com.appchoferes.nomina.models.lorasdb.dtos.ClientesResponse;
import com.appchoferes.nomina.repositories.lorasdb.ClientesRepository;

@Service
public class ClientesServ {

    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesResponse getClientesPatios() {

        List<Cliente> clientes1 = clientesRepository.getClientes(3)
            .stream()
            .map(cliente -> new Cliente(cliente.getId(), cliente.getNombre()))
            .toList();


        List<Cliente> clientes2 = clientesRepository.getClientes(5)
            .stream()
            .map(cliente -> new Cliente(cliente.getId(), cliente.getNombre()))
            .toList();

        return new ClientesResponse(clientes1, clientes2);

    }

}
