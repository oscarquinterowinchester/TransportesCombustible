package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.FSCModel;
import com.appchoferes.nomina.repositories.durandb.FSCRepository;

@Service
public class FSCService {

    @Autowired
    FSCRepository fscRepository;

    public ArrayList<FSCModel> obtenerFsc() {
        return (ArrayList<FSCModel>) fscRepository.findAll();
    }
}
