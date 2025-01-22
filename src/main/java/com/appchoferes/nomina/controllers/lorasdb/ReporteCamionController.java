package com.appchoferes.nomina.controllers.lorasdb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.HistorialAnteriorDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ItinerarioDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.KmCamionDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ReporteCamionDTO;
import com.appchoferes.nomina.services.lorasdb.CombustibleCargasDieselService;
import com.appchoferes.nomina.services.lorasdb.CombustibleItinerarioService;
import com.appchoferes.nomina.services.lorasdb.KmCamionService;

@RestController
@RequestMapping("/combustible")
public class ReporteCamionController {

    @Autowired
    private CombustibleItinerarioService combustibleItinerarioService;

    @Autowired
    private KmCamionService kmCamionService;

    @Autowired
    private CombustibleCargasDieselService combustibleCargasDieselService;

    @GetMapping("/reporte-camion")
    public ReporteCamionDTO getReporteCamion(
            @RequestParam("camionId") Long camionId,
            @RequestParam("fechaActual") String fechaActual) {

        // Obtener historial anterior
        List<HistorialAnteriorDTO> historial = combustibleCargasDieselService.getHistorialAnterior(camionId,
                fechaActual);
        String fechaAnterior;
        Long odometro;

        if (!historial.isEmpty()) {
            fechaAnterior = historial.get(0).getFechayHora();
            odometro = historial.get(0).getOdometroCarga().longValue();
        } else {
            LocalDateTime lastYear = LocalDateTime.now().minusYears(1);
            fechaAnterior = lastYear.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            odometro = 0L;
        }

        // Obtener itinerarios
        List<ItinerarioDTO> itinerarios = combustibleItinerarioService.getItinerarioCamion(camionId, fechaAnterior,
                fechaActual);

        // Obtener kilómetros
        List<KmCamionDTO> kms = kmCamionService.getKmCamion(camionId, fechaAnterior, fechaActual);

        // Crear DTO de respuesta
        ReporteCamionDTO response = new ReporteCamionDTO();
        response.setFechaAnterior(fechaAnterior);
        response.setOdometro(odometro);
        response.setItinerarios(itinerarios);
        response.setKm(kms);

        return response;
    }
}
