package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.EmpresaModel;
import com.appchoferes.nomina.models.durandb.EmpresasModel;
import com.appchoferes.nomina.services.durandb.EmpresasService;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

    @Autowired
    EmpresasService empresasService;

    @GetMapping()
    public ArrayList<EmpresasModel> obtenerEmpresas() {
        return empresasService.obtenerEmpresas();
    }

    @GetMapping("/{id}")
    public EmpresasModel obtenerEmpresaid(@PathVariable int id) {
        Optional<EmpresasModel> entidad = empresasService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @GetMapping("/sicofi/{id}")
    public EmpresaModel obtenerEmpresasid(@PathVariable int id) {
        Optional<EmpresaModel> entidad = empresasService.efindById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }
}
