package com.appchoferes.nomina.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appchoferes.nomina.auth.models.EmpresaModel;
import com.appchoferes.nomina.auth.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public EmpresaModel seleccionarEmpresa(Integer id){
        return empresaRepository.seleccionarEmpresa(id);
    }
}
