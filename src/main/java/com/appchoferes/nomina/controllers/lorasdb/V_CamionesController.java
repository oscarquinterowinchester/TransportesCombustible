package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesPatios;
import com.appchoferes.nomina.services.lorasdb.CamionesConCargaService;

@RestController
@RequestMapping("/visitantes")
public class V_CamionesController {

    @Autowired
    private CamionesConCargaService camionesService;

    @GetMapping("/getCamiones")
    public List<CamionesPatios> getCamiones() {
        return camionesService.getCamionesDePatios();
    }

    @GetMapping("/getInfoCamion")
    public Map<String, Object> getInfoCamion(@RequestParam Long id) {
        return camionesService.getInfoCamion(id);
    }
}
