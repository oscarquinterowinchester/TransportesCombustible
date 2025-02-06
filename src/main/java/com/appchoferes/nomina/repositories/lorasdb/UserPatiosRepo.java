package com.appchoferes.nomina.repositories.lorasdb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Usuario;

@Repository
public interface UserPatiosRepo extends JpaRepository<Usuario, Long> {

    @Query("SELECT u.nombre FROM Usuario u WHERE u.usuarioId = :usuarioId")
    Optional<String> findNombreByUsuarioId(@Param("usuarioId") Integer usuarioId);
}
