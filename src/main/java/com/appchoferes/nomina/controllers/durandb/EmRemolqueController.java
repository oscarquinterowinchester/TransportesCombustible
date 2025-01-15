package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.EmRemolqueModel;
import com.appchoferes.nomina.services.durandb.EmRemolqueService;


@RestController
@RequestMapping("/emremolque")
public class EmRemolqueController {

    @Autowired
    EmRemolqueService emRemolqueService;

    @GetMapping
    public ArrayList<EmRemolqueModel> obtenerTodosLosEmRemolques() {
        return emRemolqueService.obtenerTodosLosEmRemolques();
    }

    @PostMapping
    public EmRemolqueModel guardarEmRemolque(@RequestBody EmRemolqueModel emRemolqueModel) {
        return emRemolqueService.guardar(emRemolqueModel);
    }

    // Puedes agregar más endpoints según tus necesidades
}
