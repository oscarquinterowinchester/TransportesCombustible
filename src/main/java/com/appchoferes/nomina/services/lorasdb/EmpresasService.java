package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.EmpresaModel;
import com.appchoferes.nomina.models.lorasdb.EmpresasModel;
import com.appchoferes.nomina.repositories.lorasdb.EmpresaRepository;
import com.appchoferes.nomina.repositories.lorasdb.EmpresasRepository;

@Service
public class EmpresasService {

    @Autowired
    EmpresasRepository empresasRepository;

    @Autowired
    EmpresaRepository empRepository;

    public ArrayList<EmpresasModel> obtenerEmpresas() {
        return (ArrayList<EmpresasModel>) empresasRepository.findAll();
    }

    public Optional<EmpresasModel> findById(int id) {
        return empresasRepository.findById(id);
    }

    public Optional<EmpresaModel> efindById(int id) {
        return empRepository.findById(id);
    }

}
