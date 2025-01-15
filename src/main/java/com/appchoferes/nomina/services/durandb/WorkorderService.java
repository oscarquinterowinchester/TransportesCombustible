package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.WorkorderModel;
import com.appchoferes.nomina.repositories.durandb.WorkorderRepository;

@Service
public class WorkorderService {

    @Autowired
    WorkorderRepository workorderRepository;

    public ArrayList<WorkorderModel> obtenerWorkorder() {
        return (ArrayList<WorkorderModel>) workorderRepository.findAll();
    }

    public Optional<WorkorderModel> findById(int id) {
        return workorderRepository.findById(id);
    }

    public WorkorderModel registrarOrden(WorkorderModel orden) {
        return workorderRepository.save(orden);
    }
}
