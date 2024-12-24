package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.ProveedorDTO;
import com.appchoferes.nomina.modules.combustible.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<ProveedorDTO> getProveedores(){
        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> proveedorRaw = proveedorRepository.getProveedoresRaw();

        DatabaseContextHolder.clearDatabaseType();

        List<ProveedorDTO> proveedores = new ArrayList<>();
        for (Object [] result : proveedorRaw) {
            ProveedorDTO proveedor = new ProveedorDTO();

            proveedor.setProveedorId(((Number) result[0]).longValue());
            proveedor.setNombre(result[1] != null ? result[1].toString() : null);

            proveedores.add(proveedor);

        }


        return proveedores;
    }

}
