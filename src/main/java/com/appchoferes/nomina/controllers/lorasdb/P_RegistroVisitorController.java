package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroPendientesDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorRegistroRepo;
import com.appchoferes.nomina.services.lorasdb.RegistroVisitorServ;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class P_RegistroVisitorController {

    @Autowired
    private RegistroVisitorServ registroService;

    @Autowired
    protected VisitorRegistroRepo visitorRegistroRepo;

    @GetMapping("/getRegistrosHistorial")
    public List<RegistroHistorialDTO> getRegistrosHistorial(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String inicio,
        @RequestParam(required = false) String fin
    ) {
        return registroService.getRegistrosHistorial(id, inicio, fin);
    }

    @GetMapping("/getRegistrosPendientes")
    public List<RegistroPendientesDTO> getRegistrosPendientes(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "inicio", required = false) String inicio,
            @RequestParam(value = "final", required = false) String finalFecha) {
    
        // Si los parámetros de fecha son nulos, puedes asignar valores predeterminados o usar la lógica adecuada
        if (inicio == null || inicio.isEmpty()) {
            inicio = "1900-01-01"; // o algún valor por defecto
        }
        if (finalFecha == null || finalFecha.isEmpty()) {
            finalFecha = "2100-01-01"; // o algún valor por defecto
        }
    
        System.out.println("id: " + id);
        System.out.println("inicio: " + inicio);
        System.out.println("final: " + finalFecha);
    
        return visitorRegistroRepo.findRegistrosPendientes(inicio, finalFecha, id);
    }
    
}