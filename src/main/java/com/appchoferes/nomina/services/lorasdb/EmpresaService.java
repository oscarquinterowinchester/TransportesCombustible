package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.EmpresaModel;
import com.appchoferes.nomina.repositories.lorasdb.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public EmpresaModel seleccionarEmpresa(Integer id) {
        return empresaRepository.seleccionarEmpresa(id);
    }
}
