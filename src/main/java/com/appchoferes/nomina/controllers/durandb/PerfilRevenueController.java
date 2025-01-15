package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.PerfilRevenueModel;
import com.appchoferes.nomina.services.durandb.PerfilRevenueService;

@RestController
@RequestMapping("/perfilrevenue")
public class PerfilRevenueController {

    @Autowired
    PerfilRevenueService perfilRevenueService;

    @GetMapping()
    public ArrayList<PerfilRevenueModel> obtenerPerfil() {
        return perfilRevenueService.obtenerPerfil();
    }
}
