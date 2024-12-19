package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.ProveedoresCombustible;
import com.appchoferes.nomina.repositories.IProveedoresRepository;

@Service
public class ProveedoresService {

@Autowired
IProveedoresRepository proveedoresRepository;

public ArrayList<ProveedoresCombustible> getProveedoresCombustible(String dbType){
    DatabaseContextHolder.setDatabaseType(dbType);
    return (ArrayList<ProveedoresCombustible>) proveedoresRepository.getProveedoresCombustible();
}


}
