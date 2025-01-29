package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InventarioExterno;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepo;
import com.appchoferes.nomina.utils.ImageUtil;

@Service
public class InventarioExternoServ {

    @Autowired
    private InventarioExternoRepo invExtRepo;

    public static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/";

    public Integer procesarInventarioExterno(InventarioExterno contenedor) throws Exception{
        if(sonParametrosInvalidos(contenedor)){
            throw new IllegalArgumentException("Itinerario y Contenedor están vacíos o no son válidos");
        }

        if (invExtRepo.existsByContenedorAndItinerarioId(contenedor.getContenedor(),contenedor.getItinerarioId())){
            throw new IllegalArgumentException("Entrada duplicada");
        }

        if (contenedor.getFirmaChofer() != null){
            String path = ImageUtil.saveImage(contenedor.getFirmaChofer(),"firma-chofer", BASE_DIRECTORY + "firmas-chofer/");
            contenedor.setFirmaChofer(path);
        }   
          
        if (contenedor.getFirmaGuardia() != null){
            String path = ImageUtil.saveImage(contenedor.getFirmaGuardia(),"firma-guardia", BASE_DIRECTORY + "firmas-guardia/");
            contenedor.setFirmaGuardia(path);
        }   

        InventarioExterno savedInventario = invExtRepo.save(contenedor);
        
        return savedInventario.getInventarioID();
        
    }
    
    public boolean sonParametrosInvalidos(InventarioExterno contenedor) {
        return contenedor.getContenedor() == null || contenedor.getItinerarioId() == null;
    }

}
