package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo1DTO;
import com.appchoferes.nomina.services.lorasdb.ContenedorPatioServ;

@RestController
@RequestMapping("/patios")
public class P_ContenedorController {

    @Autowired
    private ContenedorPatioServ service;

    @GetMapping("/getContenedoresPatio")
    public Map<String, Object> obtenerContenedores(
            @RequestParam Integer patioId,
            @RequestParam Integer usuarioId) {

        return service.obtenerContenedores(patioId, usuarioId);
    }

    @GetMapping("/getContenedorEntrada")
    public Object getContenedorEntrada(
            @RequestParam(required = false) Long ItinerarioID,
            @RequestParam(required = false) String contenedor,
            @RequestParam Integer tipo) {

        return service.getContenedorEntrada(ItinerarioID, contenedor, tipo);
    }

    /*
     * endpoint para obtener salida de contenedores, se realiza la busqueda de dos
     * maneras
     * la primera (tipo 1) busca los datos en base al contenedor y la segunda (tipo
     * 2)
     * realiza la busqueda en base al itinerarioId, es por eso que
     * 
     * @RequestParam(required = false) Integer itinerarioId
     * no siempre es requerido
     */

    @GetMapping("/getContenedorPatio")
    public List<ContenedorTipo1DTO> getContenedorPatio(
            @RequestParam String contenedor,
            @RequestParam Integer tipo,
            @RequestParam(required = false) Integer itinerarioId) {
        return service.getContenedorPatio(contenedor, tipo, itinerarioId);
    }

}
