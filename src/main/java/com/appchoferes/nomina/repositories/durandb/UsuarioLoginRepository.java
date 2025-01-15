package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appchoferes.nomina.models.durandb.UsuarioLoginModel;

public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginModel, Long> {
    UsuarioLoginModel findByLoginUsuarioAndPasswordUsuario(String loginUsuario, String passwordUsuario);
}
