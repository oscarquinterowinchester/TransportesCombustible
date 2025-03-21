package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.GuardiaConRegistroDTO;
import com.appchoferes.nomina.repositories.lorasdb.RegistroPuntoInspeccionRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuardiaService {

    @Autowired
    private RegistroPuntoInspeccionRepo registroRepository;

    public List<GuardiaConRegistroDTO> getGuardiasConRegistroEnLaSemana(Integer id_guardia) {
        List<Object[]> registros = registroRepository.findGuardiasConRegistroEnLaSemana(id_guardia);

        return registros.stream().map(registro -> {
            GuardiaConRegistroDTO dto = new GuardiaConRegistroDTO();
            dto.setId((Long) registro[0]); 
            dto.setNombre((String) registro[1]); 
            return dto;
        }).collect(Collectors.toList());
    }
}