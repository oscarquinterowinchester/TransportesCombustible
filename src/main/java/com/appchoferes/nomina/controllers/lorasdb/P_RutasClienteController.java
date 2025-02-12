package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.RutasClientePatio;
import com.appchoferes.nomina.services.lorasdb.RutasClienteServ;

@RestController
@RequestMapping("/patios")
public class P_RutasClienteController {

    @Autowired
    private RutasClienteServ rutasClienteServ;

    @GetMapping("/getRutasCliente")
    public List<RutasClientePatio> getRutasClientePatios(@RequestParam Long clienteID){
        return rutasClienteServ.getRutasClientesPatios(clienteID);
    }
    
}
