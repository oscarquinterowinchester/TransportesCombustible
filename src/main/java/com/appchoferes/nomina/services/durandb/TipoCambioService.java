package com.appchoferes.nomina.services.durandb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TipoCambioModel;
import com.appchoferes.nomina.repositories.durandb.TipoCambioDTORepository;
import com.appchoferes.nomina.repositories.durandb.TipoCambioRepository;

@Service
public class TipoCambioService {

    @Autowired
    TipoCambioRepository tipocambioRepository;

    public ArrayList<TipoCambioModel> obtenerTipos() {
        return (ArrayList<TipoCambioModel>) tipocambioRepository.findAll();
    }

    public List<TipoCambioDTORepository> obtenerTodo() {
        List<Object[]> resultados = tipocambioRepository.obtenerTodoComoArray();

        return resultados.stream().map(obj -> {
            TipoCambioDTORepository dto = new TipoCambioDTORepository();
            dto.setCambioID((Integer) obj[0]);
            dto.setTipoCambio((Float) obj[1]);
            dto.setFecha((Date) obj[2]);
            dto.setFechaRegistro((String) obj[3]);
            dto.setUsuarioID((Integer) obj[4]);
            dto.setStatus((Boolean) obj[5]);
            dto.setNombreUsuario((String) obj[6]);
            dto.setvalidoEliminar((Long) obj[7]);
            return dto;
        }).collect(Collectors.toList());
    }

    public TipoCambioModel registrarCambio(TipoCambioModel tipocambio) {
        return tipocambioRepository.save(tipocambio);
    }

}
