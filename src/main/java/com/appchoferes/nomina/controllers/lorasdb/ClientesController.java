package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ClientesResponse;
import com.appchoferes.nomina.services.lorasdb.ClientesServ;

@RestController
@RequestMapping("/patios")
public class ClientesController {

    @Autowired
    private ClientesServ clientesServ;

    @GetMapping("/clientes-patios")
    public ClientesResponse getClientesPatio() {
        return clientesServ.getClientesPatios();
    }

}
