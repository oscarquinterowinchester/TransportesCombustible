package com.appchoferes.nomina.controllers.lorasdb.EntradasEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo.EquipoEntradaResponse;
import com.appchoferes.nomina.services.lorasdb.EntradasEquipo.EntradasEquipoService;

@RestController
@RequestMapping("/patios")
public class EntradasEquipoController {

   @Autowired
   private EntradasEquipoService entradasEquipoService;

   @GetMapping("/equipo-entrada")
   public EquipoEntradaResponse getContenedorEntrada(
         @RequestParam("ItinerarioID") Long itinerarioId,
         @RequestParam("PatioID") Integer patioId) {
      return entradasEquipoService.getContenedorEntrada(itinerarioId, patioId);
   }
}
