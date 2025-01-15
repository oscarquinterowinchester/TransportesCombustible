package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ItiCartasPorteModel;
import com.appchoferes.nomina.models.durandb.dtos.ItiCartasPorteDTO;
import com.appchoferes.nomina.repositories.durandb.ItiCartasPorteDTORepository;
import com.appchoferes.nomina.repositories.durandb.ItiCartasPorteRepository;

@Service
public class ItiCartasPorteService {

    @Autowired
    ItiCartasPorteRepository itiCartasPorteRepository;

    @Autowired
    ItiCartasPorteDTORepository itiCartasPorteDTORepository;

    public ArrayList<ItiCartasPorteDTO> obtenerItiCartaDTO() {
        return (ArrayList<ItiCartasPorteDTO>) itiCartasPorteDTORepository.findAll();
    }

    public ArrayList<ItiCartasPorteModel> obtenerItiCarta() {
        return (ArrayList<ItiCartasPorteModel>) itiCartasPorteRepository.findAll();
    }

    public Optional<ItiCartasPorteModel> findById(int id) {
        return itiCartasPorteRepository.findById(id);
    }

    public ItiCartasPorteDTO registrarItiCartas(ItiCartasPorteDTO cartas) {
        return itiCartasPorteDTORepository.save(cartas);
    }
}
