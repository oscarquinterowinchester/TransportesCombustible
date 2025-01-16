package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.CajasConCargaDTO;
import com.appchoferes.nomina.services.lorasdb.CajasConCargaService;


@RestController
@RequestMapping("/combustible")
public class CajasConCargaController {

    @Autowired
    private CajasConCargaService cajasConCargaService;

    @GetMapping("/cajas-cargas")
    public List<CajasConCargaDTO> getAllCajasConCarga() {
        return cajasConCargaService.getAllCajasConCarga();
    }

    
    @GetMapping("/cajas-cargas/{id}")
    public CajasConCargaDTO getCaja(@PathVariable Long id) {
        return cajasConCargaService.getCaja(id);
    }
}

