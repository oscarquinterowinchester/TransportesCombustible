package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.FSCModel;
import com.appchoferes.nomina.services.durandb.FSCService;

@RestController
@RequestMapping("/fsc")
public class FSCController {

    @Autowired
    FSCService fscService;

    @GetMapping()
    public ArrayList<FSCModel> obtenerFsc() {
        return fscService.obtenerFsc();
    }
}
