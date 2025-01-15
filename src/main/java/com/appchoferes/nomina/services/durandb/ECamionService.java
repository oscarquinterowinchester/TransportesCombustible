package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ECamionModel;
import com.appchoferes.nomina.repositories.durandb.ECamionRepository;

@Service
public class ECamionService {

    @Autowired
    ECamionRepository eCamionRepository;

    public ArrayList<ECamionModel> getAll(){
        return (ArrayList<ECamionModel>) eCamionRepository.findAll();
    }

    public ECamionModel save(ECamionModel eCamionModel){
        return eCamionRepository.save(eCamionModel);
    }
}
