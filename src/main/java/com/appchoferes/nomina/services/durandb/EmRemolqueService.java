package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EmRemolqueModel;
import com.appchoferes.nomina.repositories.durandb.EmRemolqueRepository;

@Service
public class EmRemolqueService {

    private final EmRemolqueRepository emRemolqueRepository;

    @Autowired
    public EmRemolqueService(EmRemolqueRepository emRemolqueRepository) {
        this.emRemolqueRepository = emRemolqueRepository;
    }

    // Métodos de servicio

    public ArrayList<EmRemolqueModel> obtenerTodosLosEmRemolques() {
        return (ArrayList<EmRemolqueModel>) emRemolqueRepository.findAll();
    }

    public EmRemolqueModel guardar(EmRemolqueModel emRemolqueModel){
        return emRemolqueRepository.save(emRemolqueModel);
    }

    // Puedes agregar más métodos de servicio según tus necesidades
}
