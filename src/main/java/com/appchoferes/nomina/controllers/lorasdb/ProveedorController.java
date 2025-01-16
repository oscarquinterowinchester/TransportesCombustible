package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ProveedorDTO;
import com.appchoferes.nomina.services.lorasdb.ProveedorService;

@RestController
@RequestMapping("/combustible")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedores")
    public List<ProveedorDTO> getProveedores() {
        return proveedorService.getProveedores();
    }
}


