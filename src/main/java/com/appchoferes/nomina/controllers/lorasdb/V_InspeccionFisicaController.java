package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ListaInspeccionRequest;
import com.appchoferes.nomina.services.lorasdb.InspeccionFisicaServ;

@RestController
@RequestMapping("/visitantes")
public class V_InspeccionFisicaController {

    @Autowired
    private InspeccionFisicaServ inspeccionFisicaService;

    @PostMapping("/saveListaInspeccion")
    public String saveListaInspeccion(@RequestBody ListaInspeccionRequest request) {
        // Verificar que los datos lleguen correctamente
        System.out.println("Guardia: " + request.getGuardia());
        System.out.println("Nota: " + request.getNota());
        System.out.println("ListaPuntos: " + request.getListaPuntos());

        // Llamar al servicio con el mapa de puntos
        return inspeccionFisicaService.saveListaInspeccion(request.getListaPuntos(), request.getGuardia(),
                request.getNota());
    }

}
