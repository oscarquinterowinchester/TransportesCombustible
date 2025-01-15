package com.appchoferes.nomina.controllers.durandb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.ConsultasModel;
import com.appchoferes.nomina.repositories.durandb.ConsultasRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    ConsultasRepository consultasRepository;

    @GetMapping("/getistraslado/{empresaID}/{clienteID}")
    public ConsultasModel getRFCIsTraslado(@PathVariable Integer empresaID, @PathVariable Integer clienteID) {
        Optional<ConsultasModel> entidad = consultasRepository.findisTraslado(empresaID, clienteID);

        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @GetMapping("/getdataRutas/{conceptoSATID}/{itinerarioID}")
    public ConsultasModel getdataRutas(@PathVariable Integer conceptoSATID, @PathVariable Integer itinerarioID) {
        Optional<ConsultasModel> entidad = consultasRepository.getdataRutas(conceptoSATID, itinerarioID);

        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }
}
