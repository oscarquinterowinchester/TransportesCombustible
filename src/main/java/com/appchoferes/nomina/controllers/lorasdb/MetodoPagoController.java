package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.MetodoPagoDTO;
import com.appchoferes.nomina.services.lorasdb.MetodoPagoService;

@RestController
@RequestMapping("/combustible")
public class MetodoPagoController {
    
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("/metodos-pago")
    public List<MetodoPagoDTO> getMetodosPago(){
        return metodoPagoService.getMetodosPago();
    }
}
