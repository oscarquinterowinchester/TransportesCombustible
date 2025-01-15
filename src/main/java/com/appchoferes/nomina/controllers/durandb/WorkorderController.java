package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.WorkorderModel;
import com.appchoferes.nomina.repositories.durandb.WorkorderRepository;
import com.appchoferes.nomina.services.durandb.WorkorderService;

@RestController
@RequestMapping("/workorder")
public class WorkorderController {

    @Autowired
    WorkorderRepository workorderRepository;

    @Autowired
    WorkorderService workorderService;

    @GetMapping()
    public ArrayList<WorkorderModel> obtenerWorkorder() {
        return workorderService.obtenerWorkorder();
    }

    @GetMapping("/byclienteid/{clienteID}")
    public ResponseEntity<List<WorkorderModel>> getByClienteID(@PathVariable Integer clienteID) {
        List<WorkorderModel> workorders = workorderRepository.findByClienteID(clienteID);

        if (!workorders.isEmpty()) {
            return ResponseEntity.ok(workorders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public WorkorderModel registrarOrden(@RequestBody WorkorderModel nuevaOrden) {
        return workorderService.registrarOrden(nuevaOrden);
    }

}
