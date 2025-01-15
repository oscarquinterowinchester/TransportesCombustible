package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.NavierasModel;
import com.appchoferes.nomina.repositories.durandb.NavierasRepository;

@Service
public class NavierasService {

    @Autowired
    NavierasRepository navierasRepository;

    public ArrayList<NavierasModel> obtenerNaviera() {
        return (ArrayList<NavierasModel>) navierasRepository.findAll();
    }
}
