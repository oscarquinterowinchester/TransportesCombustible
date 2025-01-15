package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.PerfilRevenueModel;
import com.appchoferes.nomina.repositories.durandb.PerfilRevenueRepository;

@Service
public class PerfilRevenueService {
    @Autowired
    PerfilRevenueRepository perfilRevenueRepository;

    public ArrayList<PerfilRevenueModel> obtenerPerfil() {
        return (ArrayList<PerfilRevenueModel>) perfilRevenueRepository.findAll();
    }
}
