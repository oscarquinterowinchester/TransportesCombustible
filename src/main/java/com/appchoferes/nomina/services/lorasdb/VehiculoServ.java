package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.models.lorasdb.dtos.getVehiculoDTO;
import com.appchoferes.nomina.repositories.lorasdb.VehiculoRepo;

@Service
public class VehiculoServ {

    @Autowired
    private VehiculoRepo vehiculoRepo;

    public List<getVehiculoDTO> getMisVehiculos(Integer visitanteId){
        List<Vehiculo> vehiculos = vehiculoRepo.findByVisitante(visitanteId);

        return vehiculos.stream()
                .map(v -> new getVehiculoDTO(
                    v.getId(),
                    v.getId(),
                    v.getModelo(),
                    v.getPlacas(),
                    v.getAnio(),
                    v.getVisitante(),
                    v.getFecha(),
                    0
                ))
                .collect(Collectors.toList());
    }
}
