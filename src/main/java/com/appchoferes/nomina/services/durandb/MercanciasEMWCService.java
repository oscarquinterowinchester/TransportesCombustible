package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.MercanciasEMWCModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasEMWCRepository;

@Service
public class MercanciasEMWCService {
    
    @Autowired
    MercanciasEMWCRepository mercanciasEMWCRepository;


    public ArrayList<MercanciasEMWCModel> findAll(){
        return (ArrayList<MercanciasEMWCModel>) mercanciasEMWCRepository.findAll();
    }

    public MercanciasEMWCModel save(MercanciasEMWCModel mercanciasEMWCModel){
        return mercanciasEMWCRepository.save(mercanciasEMWCModel);
    }
}
