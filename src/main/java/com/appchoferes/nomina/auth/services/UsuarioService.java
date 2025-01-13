package com.appchoferes.nomina.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.auth.models.UsuarioModel;
import com.appchoferes.nomina.auth.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public List<UsuarioModel> findByUsuarioAndPassword(String usuario, String password){
        return usuarioRepository.findByUsuarioAndPassword(usuario, password);
    }

}
