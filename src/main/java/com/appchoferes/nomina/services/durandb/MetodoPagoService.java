package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.MetodoPagoModel;
import com.appchoferes.nomina.repositories.durandb.MetodoPagoRepository;

@Service
public class MetodoPagoService {

    @Autowired
    MetodoPagoRepository metodoPagoRepository;

    public ArrayList<MetodoPagoModel> obtenerMetodoPago() {
        return (ArrayList<MetodoPagoModel>) metodoPagoRepository.findAll();
    }
}
