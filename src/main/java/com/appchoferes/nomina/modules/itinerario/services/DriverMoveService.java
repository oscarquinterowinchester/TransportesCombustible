package com.appchoferes.nomina.modules.itinerario.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.models.ContenedorEntity;
import com.appchoferes.nomina.modules.itinerario.models.DriverMoveEntity;
import com.appchoferes.nomina.modules.itinerario.models.Itinerario;
import com.appchoferes.nomina.modules.itinerario.repositories.ContenedorRepository;
import com.appchoferes.nomina.modules.itinerario.repositories.DriveMoveRepository;
import com.appchoferes.nomina.operaciones.Utils;

@Service
public class DriverMoveService implements IDriverMoveService{

    @Autowired
    DriveMoveRepository driverMoveRepository;

    @Autowired
    ContenedorRepository contenedorRepository;
    
    @Override
    public int setItinerarioAsVisto(String itinerarioId,String dbType)
    {
        Utils.establecerBaseDatos(dbType);

        return driverMoveRepository.setItinerarioAsVisto(itinerarioId);
        
    }

    @Override
    public Itinerario getItinerario(String choferId,String dbType)
    {

        Utils.establecerBaseDatos(dbType);

        Itinerario data = getInformacionItinerario(choferId);
        
        return data;
    }


    private Itinerario getInformacionItinerario(String choferId)
    {

        Itinerario itinerarioChofer = new Itinerario();

        List<DriverMoveEntity> listaItinerarios = driverMoveRepository.getDriveMoveByChofer(choferId);

        itinerarioChofer.setData(listaItinerarios);

            for(DriverMoveEntity iti : itinerarioChofer.getData()){

                List<ContenedorEntity> contenedores = contenedorRepository.getContenedores(Utils.toStr(iti.getId()));
                iti.setContenedores(contenedores);

                }

        // Datos complementarios, ayudan a que el front los reciba, revisar si son esenciales, sino, borrarlos
        itinerarioChofer.set_estatus(20);
        itinerarioChofer.set_message("Datos encontrados");
        itinerarioChofer.setCount(1);

        return itinerarioChofer;
    
    }

}
