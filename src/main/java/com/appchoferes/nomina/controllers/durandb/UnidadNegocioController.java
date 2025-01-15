package com.appchoferes.nomina.controllers.durandb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.UnidadNegocioModel;
import com.appchoferes.nomina.services.durandb.UnidadNegocioService;

@RestController
@RequestMapping("/u-negocio")
public class UnidadNegocioController {

    @Autowired
    private UnidadNegocioService unidadNegocioService;

    @GetMapping()
    public List<UnidadNegocioModel> obtenerEntidadesConStatusUno() {
        return unidadNegocioService.obtenerEntidadesConStatusUno();
    }

    @GetMapping("/{id}")
    public UnidadNegocioModel obtenerEntidadPorId(@PathVariable int id) {
        Optional<UnidadNegocioModel> entidad = unidadNegocioService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

}
