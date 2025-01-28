package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.RutasClientePatio;
import com.appchoferes.nomina.services.lorasdb.RutasClienteServ;

@RestController
@RequestMapping("/patios")
public class P_RutasClienteController {

    @Autowired
    private RutasClienteServ rutasClienteServ;

    @GetMapping("/rutas-clientes/{clienteID}")
    public List<RutasClientePatio> getRutasClientePatios(@PathVariable Long clienteID){
        return rutasClienteServ.getRutasClientesPatios(clienteID);
    }
    
}
