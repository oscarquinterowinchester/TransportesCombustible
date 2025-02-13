package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.HistorialCargasDTO;
import com.appchoferes.nomina.services.lorasdb.C_RawQueryService;
import com.appchoferes.nomina.services.lorasdb.CamionesConCargaService;

@RestController
@RequestMapping("/combustible")
public class CamionesConCargaController{
    
    @Autowired
    private CamionesConCargaService camionesConCargaService;

    @Autowired
    private C_RawQueryService c_RawQueryService;

    @GetMapping("/camiones-cargas")
    public List<CamionesConCargaDTO> getAllCamionesConCargas(){
        return c_RawQueryService.getCamionesConCarga();
    }

    @GetMapping("/camiones-cargas/{id}")
    public CamionesConCargaDTO getCamion(@PathVariable Long id){
        return camionesConCargaService.getCamion(id);
    }

    @GetMapping("/historial-cargas")
    public List<HistorialCargasDTO> getHistorial(
            @RequestParam("id") Long id,
            @RequestParam("tipo") Integer tipo) {
        return c_RawQueryService.getHistorialCargas(id, tipo);
    }
}
