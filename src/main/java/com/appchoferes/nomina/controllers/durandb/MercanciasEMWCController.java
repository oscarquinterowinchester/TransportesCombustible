package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.MercanciasEMWCModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasEMWCRepository;
import com.appchoferes.nomina.services.durandb.MercanciasEMWCService;

@RestController
@RequestMapping("/mercanciasemwc")
public class MercanciasEMWCController {
    
    @Autowired
    MercanciasEMWCService mercanciasEMWCService;

    @Autowired
    MercanciasEMWCRepository mercanciasEMWCRepository;


    @GetMapping()
    public ArrayList<MercanciasEMWCModel> findAll(){
        return mercanciasEMWCService.findAll();
    }

    @PostMapping()
    public MercanciasEMWCModel save(@RequestBody MercanciasEMWCModel mercanciasEMWCModel){
        return mercanciasEMWCService.save(mercanciasEMWCModel);
    }

    @PostMapping("/mercancias")
    public ArrayList<MercanciasEMWCModel> saveArray(@RequestBody ArrayList<MercanciasEMWCModel> arrayList){
        ArrayList<MercanciasEMWCModel> saved = new ArrayList<MercanciasEMWCModel>();
        for (MercanciasEMWCModel mercanciasEMWCModel : arrayList) {
            saved.add(mercanciasEMWCService.save(mercanciasEMWCModel));
        }

        return saved;
    }

}
