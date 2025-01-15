package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.MercanciaConfiguracionModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasConfiguracionRepository;
import com.appchoferes.nomina.services.durandb.MercanciaConfiguracionService;


@RestController
@RequestMapping("/mercancias-configuracion")
public class MercanciaConfiguracionController {
    @Autowired
    MercanciaConfiguracionService mercanciaConfiguracionService;

    @Autowired
    MercanciasConfiguracionRepository mercanciasConfiguracionRepository;

    @GetMapping()
    public ArrayList<MercanciaConfiguracionModel> obtenerConfiguraciones(){
        return mercanciaConfiguracionService.getAllConfiguraciones(); 
    }

    @PostMapping()
    public MercanciaConfiguracionModel registrarConfiguracion(@RequestBody MercanciaConfiguracionModel nuevaConfiguracion){
        return mercanciaConfiguracionService.saveConfiguracion(nuevaConfiguracion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> eliminarConfiguracion(@PathVariable Integer id){
        return mercanciaConfiguracionService.deleteConfiguracion(id);
    }
}
