package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.UsuariosUniModel;
import com.appchoferes.nomina.services.durandb.UsuariosUniService;

@RestController
@RequestMapping("/usuario-uni")
public class UsuariosUniController {

    @Autowired
    UsuariosUniService usuariosUniService;

    @GetMapping
    public ArrayList<UsuariosUniModel> obtenerUsuariosUni() {
        return usuariosUniService.obtenerUsuariosUni();
    }
}
