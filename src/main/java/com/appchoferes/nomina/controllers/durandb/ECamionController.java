package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.ECamionModel;
import com.appchoferes.nomina.repositories.durandb.ECamionRepository;
import com.appchoferes.nomina.services.durandb.ECamionService;

@RestController
@RequestMapping("/emcamion")
public class ECamionController {
    @Autowired
    ECamionService eCamionService;

    @Autowired
    ECamionRepository eCamionRepository;

    @GetMapping()
    public ArrayList<ECamionModel> getAllEMCamiones(){
        return eCamionService.getAll();
    }

    @PostMapping()
    public ECamionModel saveECamion(@RequestBody ECamionModel eCamionModel){
        System.out.print(eCamionModel);
        return eCamionRepository.save(eCamionModel);
    }
}
