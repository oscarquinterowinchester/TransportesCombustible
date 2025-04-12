package com.appchoferes.nomina.controllers.lorasdb.SalidasEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.SalidasEquipo.EquipoSalidaResponse;
import com.appchoferes.nomina.services.lorasdb.SalidasEquipo.SalidasEquipoService;

@RequestMapping("/patios")
@RestController
public class SalidasEquipoController {

   @Autowired
   private SalidasEquipoService salidasEquipoService;

   @GetMapping("/equipo-salida")
   public EquipoSalidaResponse getContenedorSalida(
         @RequestParam("ItinerarioID") Long itinerarioId,
         @RequestParam("PatioID") Integer patioId) {
      return salidasEquipoService.getContenedorSalida(itinerarioId, patioId);
   }
}
