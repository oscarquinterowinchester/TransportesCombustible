package com.appchoferes.nomina.controllers.lorasdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.PuntosSemanaResponse;
import com.appchoferes.nomina.services.lorasdb.RegistroPuntoInspeccionServ;

@RestController
@RequestMapping("/visitantes")
public class V_RegistroPuntoInspeccionController {

    @Autowired
    private RegistroPuntoInspeccionServ registroPuntoInspeccionService;

    @GetMapping("/getListaPuntosGuardadosSemanal")
    public Map<String, Object> getListaPuntosGuardadosSemanal() {
        List<PuntosSemanaResponse> data = registroPuntoInspeccionService.getPuntosSemana();

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("_estatus", 20);
        response.put("_message", "Datos encontrados");
        response.put("count", data.size());

        return response;
    }
}
