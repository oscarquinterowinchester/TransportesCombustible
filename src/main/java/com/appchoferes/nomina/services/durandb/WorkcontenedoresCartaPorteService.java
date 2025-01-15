package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.WorkcontenedoresCartaPorteModel;
import com.appchoferes.nomina.repositories.durandb.WorkcontenedoresCartaPorteRepository;

@Service
public class WorkcontenedoresCartaPorteService {

    @Autowired
    WorkcontenedoresCartaPorteRepository workcontenedoresCartaPorteRepository;

    public ArrayList<WorkcontenedoresCartaPorteModel> obtenerWorkcontenedor() {
        return (ArrayList<WorkcontenedoresCartaPorteModel>) workcontenedoresCartaPorteRepository.findAll();
    }

    public WorkcontenedoresCartaPorteModel registrarWorkcontenedorCarta(WorkcontenedoresCartaPorteModel orden) {
        return workcontenedoresCartaPorteRepository.save(orden);
    }

    public ResponseEntity<Map<String, String>> deleteConfiguracion(Long id){
        workcontenedoresCartaPorteRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Camión eliminado correctamente"));
    } 

}
