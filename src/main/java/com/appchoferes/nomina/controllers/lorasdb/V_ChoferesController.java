package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.Chofer;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpleadoDTO;
import com.appchoferes.nomina.services.lorasdb.ChoferService;
import com.appchoferes.nomina.services.lorasdb.PV_RawQueryService;

@RestController
@RequestMapping("/patios")
public class V_ChoferesController {

    @Autowired
    private ChoferService choferService;

    @Autowired
    private PV_RawQueryService rawQueryService;

    @GetMapping("/getChoferes")
    public List<Chofer> getChoferesPatios() {
        return choferService.getChoferesPatios();
    }

    //enpoint de visitantes
    @GetMapping("/getEmpleados")
    public ResponseEntity<List<EmpleadoDTO>> getEmpleados() {
        List<EmpleadoDTO> empleados = rawQueryService.getEmpleados();
        return ResponseEntity.ok(empleados);
    }

}
