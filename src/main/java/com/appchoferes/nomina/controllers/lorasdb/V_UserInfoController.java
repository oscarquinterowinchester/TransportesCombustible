package com.appchoferes.nomina.controllers.lorasdb;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.services.lorasdb.UserPatiosServ;

@RestController
@RequestMapping("/visitantes")
public class V_UserInfoController {

    @Autowired
    private UserPatiosServ userPatiosServ;
    @GetMapping("/getInformationUser")
    public ResponseEntity<?> getNombreUsuario(@RequestParam("id") Integer usuarioId) {
        Optional<String> nombre = userPatiosServ.getUsuarioNombre(usuarioId);
        if (nombre.isPresent()) {
            return ResponseEntity.ok(Map.of("nombre", nombre.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("error", "Usuario no encontrado"));
        }
    }

    
}
