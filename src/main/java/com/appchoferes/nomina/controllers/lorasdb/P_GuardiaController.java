package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.GuardiaConRegistroDTO;
import com.appchoferes.nomina.services.lorasdb.GuardiaService;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class P_GuardiaController {

    @Autowired
    private GuardiaService guardiaService;

    @GetMapping("/guardias-registro-semana")
    public List<GuardiaConRegistroDTO> getGuardiasConRegistroEnLaSemana(@RequestParam int id_guardia) {
        return guardiaService.getGuardiasConRegistroEnLaSemana(id_guardia);
    }
}