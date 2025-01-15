package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CuentasContablesModel;
import com.appchoferes.nomina.repositories.durandb.CuentasContablesRepository;

@Service
public class CuentasContablesService {
    @Autowired
    CuentasContablesRepository cuentasContablesRepository;

    public ArrayList<CuentasContablesModel> obtenerCuentas() {
        return (ArrayList<CuentasContablesModel>) cuentasContablesRepository.findAll();
    }
}
