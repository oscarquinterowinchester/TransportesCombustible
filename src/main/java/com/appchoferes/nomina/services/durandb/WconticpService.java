package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.WconticpModel;
import com.appchoferes.nomina.repositories.durandb.WconticpRepository;

@Service
public class WconticpService {

    @Autowired
    WconticpRepository wconticpRepository;

    public ArrayList<WconticpModel> obtenerWcont() {
        return (ArrayList<WconticpModel>) wconticpRepository.findAll();
    }

    public WconticpModel registrarOrden(WconticpModel orden) {
        return wconticpRepository.save(orden);
    }

}
