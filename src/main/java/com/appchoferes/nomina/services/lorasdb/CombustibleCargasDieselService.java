package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.CargasDieselDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.HistorialAnteriorDTO;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleCargasDieselRepository;

@Service
public class CombustibleCargasDieselService {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    public List<CargasDieselDTO> getHistorialCargas(Long id, Integer tipo) {
        List<Object[]> historialCargas = combustibleCargasDieselRepository.getHistorialCargas(id, tipo);
        return historialCargas.stream()
                .map(this :: mapToDTO)
                .collect(Collectors.toList());
    }

    public List<HistorialAnteriorDTO> getHistorialAnterior(Long id, String fechaActual) {
        List<Object[]> historialAnterior = combustibleCargasDieselRepository.getHistorialAnterior(id, fechaActual);
        return historialAnterior.stream()
                .map(this :: mapToDTOHistorialAnterior)
                .collect(Collectors.toList());
    }

    private HistorialAnteriorDTO mapToDTOHistorialAnterior(Object[] result) {
        return HistorialAnteriorDTO.builder()
                .cargaId(getLong(result[0]))
                .fechayHora(getString(result[1]))
                .odometroCarga(getDouble(result[2]))
                .build();
    }

    private CargasDieselDTO mapToDTO(Object[] result) {
        return CargasDieselDTO.builder()
                .cargaId(getLong(result[0]))
                .nombreProveedor(getString(result[1]))
                .litros(getDouble(result[2]))
                .nota(getString(result[3]))
                .sellos(getString(result[4]))
                .fotoSello(getString(result[5]))
                .fechayHora(getString(result[6]))
                .folio(getString(result[7]))
                .rendimientoCarga(getDouble(result[8]))
                .rendimientoECM(getDouble(result[9]))
                .rendimientoRutas(getDouble(result[10]))
                .build();
    }

    private Long getLong(Object obj){
        return obj instanceof Number ? ((Number) obj).longValue() : null;
    }

    private Double getDouble(Object obj){
        return obj instanceof Number ? ((Number) obj).doubleValue() : null;
    }

    private String getString(Object obj){
        return obj != null ? obj.toString() : null;
    }
}
