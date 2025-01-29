package com.appchoferes.nomina.services.lorasdb;

import com.appchoferes.nomina.models.lorasdb.Contenedor;
import com.appchoferes.nomina.models.lorasdb.Punto;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntoDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.SalidaContenedorDTO;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorRepo;
import com.appchoferes.nomina.repositories.lorasdb.PuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.Date;

@Service
public class SalidaContenedorServ {

    @Autowired
    private ContenedorRepo contenedorRepository;

    @Autowired
    private PuntoRepository puntoRepository;

    @Transactional
    public void procesarSalidaContenedor(SalidaContenedorDTO salidaContenedorDTO) {
        // Validar datos
        if (salidaContenedorDTO.getContenedor() == null || salidaContenedorDTO.getPuntos() == null) {
            throw new IllegalArgumentException("Datos incompletos: contenedor o puntos vacíos");
        }
    
        // Mapear DTO a entidad Contenedor
        Contenedor contenedor = new Contenedor();
        contenedor.setWContenedorID(salidaContenedorDTO.getContenedor().getWContenedorID());
        contenedor.setItinerarioID(salidaContenedorDTO.getContenedor().getItinerarioID());
        contenedor.setClienteID(salidaContenedorDTO.getContenedor().getClienteID());
        contenedor.setTipoEvento(salidaContenedorDTO.getContenedor().getTipoEvento());
        contenedor.setFechaEvento(new Date()); // Fecha actual
    
        // Guardar el contenedor
        Contenedor contenedorGuardado = contenedorRepository.save(contenedor);
    
        // Procesar cada punto
        for (PuntoDTO puntoDTO : salidaContenedorDTO.getPuntos()) {
            Punto punto = new Punto();
            punto.setId(puntoDTO.getId());
            punto.setInventarioSalidaID(contenedorGuardado.getInventarioID());
            punto.setFechaSalida(new Date());
    
            if (puntoDTO.getFotoSalida() != null && !puntoDTO.getFotoSalida().isEmpty()) {
                // Procesar imagen base64
                String[] parts = puntoDTO.getFotoSalida().split(",");
                byte[] imageBytes = Base64.getDecoder().decode(parts[1]);
                String filePath = "revisiones/salida_" + puntoDTO.getId() + ".jpg";
                // Guardar la imagen en el sistema de archivos (implementar esta lógica)
                punto.setFotoSalida(filePath);
            } else {
                punto.setFotoSalida(null);
                punto.setComentarioSalida(null);
            }
    
            // Guardar el punto
            puntoRepository.save(punto);
        }
    }
}