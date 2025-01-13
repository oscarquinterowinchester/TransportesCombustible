package com.appchoferes.nomina.auth.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.auth.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    @Query(value = "SELECT * FROM usuarios_tbl " +
            "WHERE Status = true and Usuario = :usuario " +
            "AND CAST(AES_DECRYPT(Password, 'integranets01') AS CHAR(100)) = :password", nativeQuery = true)
    List<UsuarioModel> findByUsuarioAndPassword(String usuario, String password);

}
