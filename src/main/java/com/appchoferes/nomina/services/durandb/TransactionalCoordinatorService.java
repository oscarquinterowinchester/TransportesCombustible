package com.appchoferes.nomina.services.durandb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CartasPorteModel;
import com.appchoferes.nomina.models.durandb.OperadoricpModel;
import com.appchoferes.nomina.models.durandb.PuntosicpModel;
import com.appchoferes.nomina.models.durandb.WconticpModel;
import com.appchoferes.nomina.models.durandb.dtos.ItiCartasPorteDTO;

import jakarta.transaction.Transactional;

@Service
public class TransactionalCoordinatorService {
    @Autowired
    CartasPorteService cartasPorteService;

    @Autowired
    ItiCartasPorteService itiCartasPorteService;

    @Autowired
    OperadoricpService operadoricpService;

    @Autowired
    PuntosicpService puntosicpService;

    @Autowired
    WconticpService wconticpService;

    @Transactional
    public ResponseEntity<Object> TransactionalCoordinatorGuardarCartaPorte(
        CartasPorteModel cartaPorte, ItiCartasPorteDTO itiCartaPorte , 
        OperadoricpModel operador, PuntosicpModel puntos, WconticpModel wcont 
    ){
        CartasPorteModel cartaPorteSaved = null;
        ItiCartasPorteDTO itiCartasPorteDTOSaved = null;
        try {
            cartaPorteSaved = cartasPorteService.registrarCartas(cartaPorte);
            itiCartasPorteDTOSaved = itiCartasPorteService.registrarItiCartas(itiCartaPorte);
            operadoricpService.registrarOperador(operador);
            puntosicpService.registrarPuntos(puntos);
            wconticpService.registrarOrden(wcont);
            return ResponseEntity.ok("Se guardo correctamente la carta");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear usuario y orden: " + e.getMessage());
        }
    }
}
