package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ClientesModel;
import com.appchoferes.nomina.repositories.durandb.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    public ArrayList<ClientesModel> obtenerClientes() {
        return (ArrayList<ClientesModel>) clientesRepository.findAll();
    }

    public ClientesModel registrarCliente(ClientesModel cliente) {
        return clientesRepository.save(cliente);
    }

    public Optional<ClientesModel> findById(int id) {
        return clientesRepository.findById(id);
    }
}
