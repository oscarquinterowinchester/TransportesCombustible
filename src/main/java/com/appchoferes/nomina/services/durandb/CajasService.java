package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CajasModel;
import com.appchoferes.nomina.repositories.durandb.CajasRepository;


@Service
public class CajasService {

    @Autowired
    CajasRepository cajasRepository;

    public ArrayList<CajasModel> obtenerCajas() {
        return (ArrayList<CajasModel>) cajasRepository.findAll();
    }

    public CajasModel registrarCaja(CajasModel caja) {
        return cajasRepository.save(caja);
    }

    public List<CajasModel> obtenerCajasActivasOrdenadas() {
        return cajasRepository.findCajasActivasOrderByNoEconomico();
    }

}
