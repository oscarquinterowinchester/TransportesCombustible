package com.appchoferes.nomina.modules.combustible.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.ChoferDTO;
import com.appchoferes.nomina.modules.combustible.models.Chofer;
import com.appchoferes.nomina.modules.combustible.repositories.ChoferRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChoferService {
    @Autowired
    private ChoferRepository choferRepository;

    public List<ChoferDTO> getAllChoferes(){
        DatabaseContextHolder.setDatabaseType("lorasdb");
        List<ChoferDTO> choferes = choferRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

        DatabaseContextHolder.clearDatabaseType();

        return choferes;
    }

    public ChoferDTO convertEntityToDto(Chofer chofer){
        ChoferDTO choferDTO = new ChoferDTO();
        choferDTO.setId(chofer.getId());
        choferDTO.setNombre(chofer.getNombre());
        return choferDTO;
    }

}
