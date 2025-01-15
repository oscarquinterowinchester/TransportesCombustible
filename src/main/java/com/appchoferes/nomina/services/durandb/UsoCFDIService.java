package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.UsoCFDIModel;
import com.appchoferes.nomina.repositories.durandb.UsoCFDIRepository;

@Service
public class UsoCFDIService {

    @Autowired
    UsoCFDIRepository usoCFDIRepository;

    public ArrayList<UsoCFDIModel> obtenerCfdi() {
        return (ArrayList<UsoCFDIModel>) usoCFDIRepository.findAll();
    }
}
