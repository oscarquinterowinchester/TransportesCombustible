package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.EmOperadorModel;
import com.appchoferes.nomina.repositories.durandb.EmOperadorRepository;
import com.appchoferes.nomina.services.durandb.EmOperadorService;

@RestController
@RequestMapping("/emoperadores")
public class EmOperadorController {
    @Autowired
    EmOperadorService emOperadorService;

    @Autowired
    EmOperadorRepository emOperadorRepository;


    @GetMapping()
    public ArrayList<EmOperadorModel> getAll(){
        return emOperadorService.getAll();
    }

    @PostMapping()
    public EmOperadorModel save(@RequestBody EmOperadorModel emOperadorModel){
        return emOperadorService.save(emOperadorModel);
    }
}
