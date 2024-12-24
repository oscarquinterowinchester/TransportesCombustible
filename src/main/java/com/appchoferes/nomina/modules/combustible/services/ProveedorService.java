package com.appchoferes.nomina.modules.combustible.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.ProveedorDTO;
import com.appchoferes.nomina.modules.combustible.models.Proveedor;
import com.appchoferes.nomina.modules.combustible.repositories.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<ProveedorDTO> getProveedores(){

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<ProveedorDTO> proveedores = proveedorRepository.getProveedores()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

        DatabaseContextHolder.clearDatabaseType();

        return proveedores;
    }

    public ProveedorDTO convertEntityToDto(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setProveedorID(proveedor.getProveedorID());
        proveedorDTO.setNombre(proveedor.getNombre());
        return proveedorDTO;
    }

}
