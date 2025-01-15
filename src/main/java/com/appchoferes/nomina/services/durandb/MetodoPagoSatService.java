package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.MetodoPagoSatModel;
import com.appchoferes.nomina.repositories.durandb.MetodoPagoSatRepository;

@Service
public class MetodoPagoSatService {

    @Autowired
    MetodoPagoSatRepository metodoPagoSatRepository;

    public ArrayList<MetodoPagoSatModel> obtenerMetodoPago() {
        return (ArrayList<MetodoPagoSatModel>) metodoPagoSatRepository.findAll();
    }
}
