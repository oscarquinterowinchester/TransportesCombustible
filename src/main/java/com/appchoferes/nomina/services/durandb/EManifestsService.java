package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EManifestsModel;
import com.appchoferes.nomina.repositories.durandb.EManifestsRepository;

@Service
public class EManifestsService {
    
    @Autowired
    EManifestsRepository eManifestsRepository;

    public ArrayList<EManifestsModel> findAll(){
        return (ArrayList<EManifestsModel>) eManifestsRepository.findAll();
    }

    public EManifestsModel save(EManifestsModel eManifestsModel){
        return eManifestsRepository.save(eManifestsModel);
    }

    public EManifestsModel updateNodoc(Long id){
        Optional<EManifestsModel> exist = eManifestsRepository.findById(id);
        if(exist.isPresent()){
            EManifestsModel eManifestsModel = exist.get();
            String nodoc = eManifestsModel.getId().toString() + eManifestsModel.getScac();
            eManifestsModel.setNodoc(nodoc);
            return eManifestsRepository.save(eManifestsModel);
        }else{
            return new EManifestsModel();
        }
    }

    public EManifestsModel updateStatus(Long id){
        Optional<EManifestsModel> exist = eManifestsRepository.findById(id);
        if (exist.isPresent()) {
            EManifestsModel eManifestsModel = exist.get();
            eManifestsModel.setStatus(2);
            return eManifestsRepository.save(eManifestsModel);
        }else{
            return new EManifestsModel();
        }
    }
}
