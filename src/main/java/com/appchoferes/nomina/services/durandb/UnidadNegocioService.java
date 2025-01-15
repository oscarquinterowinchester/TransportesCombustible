package com.appchoferes.nomina.services.durandb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.UnidadNegocioModel;
import com.appchoferes.nomina.repositories.durandb.UnidadNegocioRepository;

@Service
public class UnidadNegocioService {

    @Autowired
    private UnidadNegocioRepository unidadNegocioRepository;

    public Optional<UnidadNegocioModel> findById(int id) {
        return unidadNegocioRepository.findById(id);
    }

    public List<UnidadNegocioModel> obtenerEntidadesConStatusUno() {
        return unidadNegocioRepository.findByStatus((byte) 1);
    }

}
