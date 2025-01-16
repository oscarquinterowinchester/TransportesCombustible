package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appchoferes.nomina.models.lorasdb.UsuarioLoginModel;

public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginModel, Long> {
    UsuarioLoginModel findByLoginUsuarioAndPasswordUsuario(String loginUsuario, String passwordUsuario);
}
