package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.WorkcontenedorModel;
import com.appchoferes.nomina.repositories.durandb.WorkcontenedorRepository;

@Service
public class WorkcontenedorService {

    @Autowired
    WorkcontenedorRepository workcontenedorRepository;

    public ArrayList<WorkcontenedorModel> obtenerWork() {
        return (ArrayList<WorkcontenedorModel>) workcontenedorRepository.findAll();
    }

    public Optional<WorkcontenedorModel> findById(int id) {
        return workcontenedorRepository.findById(id);
    }

    public WorkcontenedorModel registrarOrden(WorkcontenedorModel orden) {
        return workcontenedorRepository.save(orden);
    }
    
    public ArrayList<WorkcontenedorModel> getWorkContenedores() {
        return (ArrayList<WorkcontenedorModel>) workcontenedorRepository.findWorkContenedores();
    }
}
