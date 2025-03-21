package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.RegistroEntradaSalida;

@Repository
public interface RegistroEntradaSalidaRepository extends JpaRepository<RegistroEntradaSalida, Integer> {
}
