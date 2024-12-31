package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.ProveedorDTO;
import com.appchoferes.nomina.modules.combustible.services.ProveedorService;
import com.appchoferes.nomina.security.dtos.LoginDTO;
import com.appchoferes.nomina.security.dtos.UsuarioDBDTO;
import com.appchoferes.nomina.security.services.UsuarioDBService;

@RestController
@RequestMapping("/api/combustible")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private UsuarioDBService usuarioDBService;

    @GetMapping("/proveedores")
    public List<ProveedorDTO> getProveedores(@RequestParam String username) {
        LoginDTO loginDTO = new LoginDTO(username, "password_placeholder");
        UsuarioDBDTO usuarioAutenticado = usuarioDBService.authenticationUsuario(loginDTO);
        String databaseName = usuarioAutenticado.getDatabase_name();
        return proveedorService.getProveedores(databaseName);
    }
}


