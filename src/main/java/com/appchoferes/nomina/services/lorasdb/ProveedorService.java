package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ProveedorDTO;
import com.appchoferes.nomina.repositories.lorasdb.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<ProveedorDTO> getProveedores(){
        List<Object[]> proveedorRaw = proveedorRepository.getProveedoresRaw();

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
