package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.EmRemolqueModel;

@Repository
public interface EmRemolqueRepository extends JpaRepository<EmRemolqueModel, Long> {
    // Puedes agregar métodos de consulta adicionales aquí si los necesitas
}
