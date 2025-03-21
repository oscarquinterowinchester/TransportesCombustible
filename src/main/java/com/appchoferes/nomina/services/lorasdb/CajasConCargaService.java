package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.CajasConCargaDTO;
import com.appchoferes.nomina.repositories.lorasdb.CajasConCargaRepository;

@Service
public class CajasConCargaService {

    @Autowired
    private CajasConCargaRepository cajasConCargaRepository;

    public List<CajasConCargaDTO> getAllCajasConCarga(){

        List<Object[]> cajasRaw = cajasConCargaRepository.getCajasConCargasRaw();
        List<CajasConCargaDTO> cajas = new ArrayList<>();
        for (Object [] result : cajasRaw) {
            CajasConCargaDTO caja = mapToDTO(result);
            cajas.add(caja);
        }
        return cajas;
    }

    public CajasConCargaDTO getCaja(Long id) {

        List<Object[]> result = cajasConCargaRepository.getCajaRaw(id);
        //recupera el primer dato de la lista
        return mapToDTO(result.get(0));
    }

    private  CajasConCargaDTO mapToDTO(Object [] result) {
        CajasConCargaDTO caja = new CajasConCargaDTO();

        caja.setId(((Number) result[0]).longValue());
        caja.setNoEconomico(result[1] != null ? result[1].toString() : null);

        caja.setTanqueCapacidad(result[2] != null ? ((Number) result[4]).doubleValue() : 0.0);
        caja.setTanqueActual(result[3] != null ? ((Number) result[5]).doubleValue() : 0.0);

        return caja;
    }
}
