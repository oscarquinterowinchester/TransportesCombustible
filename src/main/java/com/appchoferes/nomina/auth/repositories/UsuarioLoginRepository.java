package com.appchoferes.nomina.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appchoferes.nomina.auth.models.UsuarioLoginModel;

public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginModel, Long> {
    UsuarioLoginModel findByLoginUsuarioAndPasswordUsuario(String loginUsuario, String passwordUsuario);
}
