package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.EManifestsModel;
import com.appchoferes.nomina.repositories.durandb.EManifestsRepository;
import com.appchoferes.nomina.services.durandb.EManifestsService;

@RestController
@RequestMapping("/emanifests")
public class EManifestsController {
    @Autowired
    EManifestsService eManifestsService;

    @Autowired
    EManifestsRepository eManifestsRepository;

    @GetMapping()
    public ArrayList<EManifestsModel> findAll(){
        return eManifestsService.findAll();
    }

    @PostMapping()
    public EManifestsModel save(@RequestBody EManifestsModel eManifestsModel){
        return eManifestsService.save(eManifestsModel);
    }

    @PutMapping("/{id}")
    public EManifestsModel updateNodoc(@PathVariable Long id){
        return eManifestsService.updateNodoc(id);
    }

    @PutMapping("/cancelado/{id}")
    public EManifestsModel updateStatus(@PathVariable Long id){
        return eManifestsService.updateStatus(id);
    }
}
