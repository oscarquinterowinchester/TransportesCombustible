package com.appchoferes.nomina.services.lorasdb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.repositories.lorasdb.UserPatiosRepo;

@Service
public class UserPatiosServ {

    @Autowired
    private UserPatiosRepo userPatiosRepo;

    public Optional<String> getUsuarioNombre(Long usuarioId) {
        return userPatiosRepo.findNombreByUsuarioId(usuarioId);
    }
}