package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.UsuarioModels;
import com.appchoferes.nomina.repositories.durandb.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModels> obtenerUsuarios() {
        return (ArrayList<UsuarioModels>) usuarioRepository.findAll();
    }

    public List<UsuarioModels> findByUsuarioAndPassword(String usuario, String password) {
        return usuarioRepository.findByUsuarioAndPassword(usuario, password);
    }

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
}
