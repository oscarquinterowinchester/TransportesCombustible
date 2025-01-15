package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EmOperadorModel;
import com.appchoferes.nomina.repositories.durandb.EmOperadorRepository;

@Service
public class EmOperadorService {
    @Autowired
    EmOperadorRepository emOperadorRepository;

    public ArrayList<EmOperadorModel> getAll(){
        return (ArrayList<EmOperadorModel>) emOperadorRepository.findAll();
    }

    public EmOperadorModel save(EmOperadorModel emOperadorModel){
        return emOperadorRepository.save(emOperadorModel);
    }
}
