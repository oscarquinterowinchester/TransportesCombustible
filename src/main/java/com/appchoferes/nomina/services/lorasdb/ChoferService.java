package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Chofer;
import com.appchoferes.nomina.models.lorasdb.dtos.ChoferDTO;
import com.appchoferes.nomina.repositories.lorasdb.ChoferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChoferService {

    @Autowired
    private ChoferRepository choferRepository;

    public List<ChoferDTO> getAllChoferes() {
        List<ChoferDTO> choferes = choferRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return choferes;
    }

    public ChoferDTO convertEntityToDto(Chofer chofer) {
        ChoferDTO choferDTO = new ChoferDTO();
        choferDTO.setId(chofer.getId());
        choferDTO.setNombre(chofer.getNombre());
        return choferDTO;
    }

    // Metodo para recuperar choferes del modulo Patios
    // Se toma la misma clase de Chofer para los modulos de combustible 
    // y patios
    public List<Chofer> getChoferesPatios(){
        List<Chofer> choferesPatios = choferRepository.getChoferesPatios();
        return choferesPatios;

    }

}
