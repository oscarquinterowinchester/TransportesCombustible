package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.services.lorasdb.RegistroVisitorServ;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class P_RegistroVisitorController {

    @Autowired
    private RegistroVisitorServ registroService;

    @GetMapping("/getRegistrosHistorial")
    public List<RegistroHistorialDTO> getRegistrosHistorial(
        @RequestParam(required = false) Integer id,
        @RequestParam(required = false) String inicio,
        @RequestParam(required = false) String fin
    ) {
        return registroService.getRegistrosHistorial(id, inicio, fin);
    }
}