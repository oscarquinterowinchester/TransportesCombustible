package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.LlaveDTO;
import com.appchoferes.nomina.repositories.lorasdb.LlavesRepository;

import jakarta.persistence.Tuple;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/visitantes")
public class V_LlavesController {

    @Autowired
    private LlavesRepository llavesRepository;

    @GetMapping("/getLlavesDia")
    public List<LlaveDTO> getLlavesDia() {
        List<Tuple> tuples = llavesRepository.findLlaveTuples();
        return tuples.stream()
                .map(tuple -> new LlaveDTO(
                        tuple.get("tipo", String.class),
                        tuple.get("chofer", String.class),
                        tuple.get("camion", String.class)))
                .collect(Collectors.toList());
    }
}
