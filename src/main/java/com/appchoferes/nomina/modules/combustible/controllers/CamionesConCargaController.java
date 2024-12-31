package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.modules.combustible.services.CamionesConCargaService;
import com.appchoferes.nomina.security.dtos.LoginDTO;
import com.appchoferes.nomina.security.dtos.UsuarioDBDTO;
import com.appchoferes.nomina.security.services.UsuarioDBService;

@RestController
@RequestMapping("/api/combustible")
public class CamionesConCargaController{
    
    @Autowired
    private CamionesConCargaService camionesConCargaService;

    private UsuarioDBService usuarioDBService;

    @GetMapping("/camiones-cargas")
    public List<CamionesConCargaDTO> getAllCamionesConCargas(@RequestParam String username){
        LoginDTO loginDTO = new LoginDTO(username, "password_placeholder");
        UsuarioDBDTO usuarioAutenticado = usuarioDBService.authenticationUsuario(loginDTO);
        String databaseName = usuarioAutenticado.getDatabase_name();
        return camionesConCargaService.getAllCamionesConCargas(databaseName);
    }


    @GetMapping("/camiones-cargas/{id}")
    public CamionesConCargaDTO getCamion(@PathVariable Long id, @RequestParam String username){
        LoginDTO loginDTO = new LoginDTO(username, "password_placeholder");
        UsuarioDBDTO usuarioAutenticado = usuarioDBService.authenticationUsuario(loginDTO);
        String databaseName = usuarioAutenticado.getDatabase_name();
        return camionesConCargaService.getCamion(id, databaseName);
    }

    

}
