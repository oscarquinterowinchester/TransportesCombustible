package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.UsoCFDIModel;
import com.appchoferes.nomina.services.durandb.UsoCFDIService;

@RestController
@RequestMapping("/usocfdi")
public class UsoCFDIController {

    @Autowired
    UsoCFDIService usoCFDIService;

    @GetMapping()
    public ArrayList<UsoCFDIModel> obtenerCfdi() {
        return usoCFDIService.obtenerCfdi();
    }
}
