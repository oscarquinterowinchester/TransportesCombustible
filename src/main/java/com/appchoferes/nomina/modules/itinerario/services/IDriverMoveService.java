package com.appchoferes.nomina.modules.itinerario.services;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.models.Itinerario;

@Service
public interface IDriverMoveService {

    public int setItinerarioAsVisto(String itinerarioId,String dbType);

    public Itinerario getItinerario(String choferId,String dbType);

}
