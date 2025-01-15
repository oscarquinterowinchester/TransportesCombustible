package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.IcontModel;
import com.appchoferes.nomina.repositories.durandb.IcontRepository;

@Service
public class IcontService {

    @Autowired
    IcontRepository icontRepository;

    public ArrayList<IcontModel> obtenerIcont() {
        return (ArrayList<IcontModel>) icontRepository.findAll();
    }

}
