package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ParadasConsultaModel;
import com.appchoferes.nomina.models.durandb.ParadaswcModel;
import com.appchoferes.nomina.repositories.durandb.ParadasConsultaRepository;
import com.appchoferes.nomina.repositories.durandb.ParadaswcRepository;

@Service
public class ParadaswcService {

    @Autowired
    ParadaswcRepository paradaswcRepository;

    @Autowired
    ParadasConsultaRepository paradasconsultaRepository;

    public ArrayList<ParadaswcModel> obtenerParada() {
        return (ArrayList<ParadaswcModel>) paradaswcRepository.findAll();
    }

    public ArrayList<ParadasConsultaModel> getParadas(Integer WcontID) {
        return (ArrayList<ParadasConsultaModel>) paradasconsultaRepository.findParadas(WcontID);
    }

    public ArrayList<ParadasConsultaModel> getParadaswcont(Integer WcontID) {
        return (ArrayList<ParadasConsultaModel>) paradasconsultaRepository.findParadascont(WcontID);
    }
    
    public ParadaswcModel registrarParada(ParadaswcModel parada) {
        return paradaswcRepository.save(parada);
    }
    
    // public void actualizarStatusParaWcid(String wcid) {
    // paradaswcRepository.updateStatusForWcid(wcid);
    // }
}
