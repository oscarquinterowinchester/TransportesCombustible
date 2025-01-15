package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.OperadoricpModel;
import com.appchoferes.nomina.repositories.durandb.OperadoricpRepository;

@Service
public class OperadoricpService {

    @Autowired
    OperadoricpRepository operadoricpRepository;

    public ArrayList<OperadoricpModel> obtenerOperador() {
        return (ArrayList<OperadoricpModel>) operadoricpRepository.findAll();
    }

    public OperadoricpModel registrarOperador(OperadoricpModel operador) {
        return operadoricpRepository.save(operador);
    }
}
