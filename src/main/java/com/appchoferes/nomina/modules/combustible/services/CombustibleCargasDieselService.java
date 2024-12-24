package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.CargasDieselDTO;
import com.appchoferes.nomina.modules.combustible.repositories.CombustibleCargasDieselRepository;

@Service
public class CombustibleCargasDieselService {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    public List<CargasDieselDTO> getHistorialCargas(Long id, Integer tipo) {
        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> historialCargasRaw = combustibleCargasDieselRepository.getHistorialCargasRaw(id, tipo);

        DatabaseContextHolder.clearDatabaseType();

        List<CargasDieselDTO> hCargas = new ArrayList<>();

        for (Object[] result : historialCargasRaw) {
            CargasDieselDTO historial = mapToDTO(result);
            hCargas.add(historial);
        }
       return hCargas;

    }

    private CargasDieselDTO mapToDTO(Object[] result) {
        CargasDieselDTO cargaDiesel = new CargasDieselDTO();

        cargaDiesel.setCargaId(result[0] instanceof Number ? ((Number) result[0]).longValue() : null);
        cargaDiesel.setNombreProveedor(result[1] != null ? result[1].toString() : null);
        cargaDiesel.setLitros(result[2] instanceof Number ? ((Number) result[2]).doubleValue() : null);
        cargaDiesel.setNota(result[3] != null ? result[3].toString() : null);
        cargaDiesel.setSellos(result[4] != null ? result[4].toString() : null);
        cargaDiesel.setFotoSello(result[5] != null ? result[5].toString() : null);
        cargaDiesel.setFechayHora(result[6] != null ? result[6].toString() : null);
        cargaDiesel.setFolio(result[7] != null ? result[7].toString() : null);
        cargaDiesel.setRendimientoCarga(result[8] instanceof Number ? ((Number) result[8]).doubleValue() : 0.0);
        cargaDiesel.setRendimientoECM(result[9] instanceof Number ? ((Number) result[9]).doubleValue() : 0.0);
        cargaDiesel.setRendimientoCarga(result[10] instanceof Number ? ((Number) result[10]).doubleValue() : 0.0);

        return cargaDiesel;
    }

}
