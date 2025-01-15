package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.UsuariosUniModel;
import com.appchoferes.nomina.repositories.durandb.UsuariosUniRepository;

@Service
public class UsuariosUniService {

    @Autowired
    UsuariosUniRepository usuariosUniRepository;

    public ArrayList<UsuariosUniModel> obtenerUsuariosUni() {
        return (ArrayList<UsuariosUniModel>) usuariosUniRepository.findAll();
    }
}
