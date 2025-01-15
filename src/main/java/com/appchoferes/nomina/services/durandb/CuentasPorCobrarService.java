package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CuentasPorCobrarModel;
import com.appchoferes.nomina.repositories.durandb.CuentasPorCobrarRepository;

@Service
public class CuentasPorCobrarService {
    @Autowired
    CuentasPorCobrarRepository cuentasPorCobrarRepository;

    public ArrayList<CuentasPorCobrarModel> obtenCuentasPorCobrarByCliente(Integer clienteID){
        return (ArrayList<CuentasPorCobrarModel>) cuentasPorCobrarRepository.obtenCuentasPorCobrarByCliente(clienteID);
    }
}
