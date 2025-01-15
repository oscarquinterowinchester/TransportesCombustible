package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ItinerariosModel;
import com.appchoferes.nomina.models.durandb.dtos.ItinerariosDTO;
import com.appchoferes.nomina.repositories.durandb.ItinerariosDTORepository;
import com.appchoferes.nomina.repositories.durandb.ItinerariosRepository;

@Service
public class ItinerariosService {

    @Autowired
    ItinerariosRepository itinerariosRepository;

    @Autowired
    ItinerariosDTORepository itinerariosDTORepository;

    public ArrayList<ItinerariosModel> obtenerItinerarios() {
        return (ArrayList<ItinerariosModel>) itinerariosRepository.findAll();
    }

    public ArrayList<ItinerariosModel> obtenerItinerarios50() {
        return (ArrayList<ItinerariosModel>) itinerariosRepository.findTop50ByOrderByStatusAsc();
    }

    public ItinerariosDTO registrarItinerario(ItinerariosDTO itinerario) {
        return itinerariosDTORepository.save(itinerario);
    }
}
