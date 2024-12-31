package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.ChoferDTO;
import com.appchoferes.nomina.modules.combustible.services.ChoferService;
import com.appchoferes.nomina.security.dtos.LoginDTO;
import com.appchoferes.nomina.security.dtos.UsuarioDBDTO;
import com.appchoferes.nomina.security.services.UsuarioDBService;

@RestController
@RequestMapping("/api/combustible")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @Autowired
    private UsuarioDBService usuarioDBService;

    @GetMapping("/choferes")
    public List<ChoferDTO> getAllChoferes(@RequestParam String username) {
        LoginDTO loginDTO = new LoginDTO(username, "password_placeholder");
        UsuarioDBDTO usuarioAutenticado = usuarioDBService.authenticationUsuario(loginDTO);
        String databaseName = usuarioAutenticado.getDatabase_name();
        return choferService.getAllChoferes(databaseName);
    }

}
