package com.appchoferes.nomina.services.durandb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EmpresaModel;
import com.appchoferes.nomina.repositories.durandb.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public EmpresaModel seleccionarEmpresa(Integer id) {
        return empresaRepository.seleccionarEmpresa(id);
    }
}
