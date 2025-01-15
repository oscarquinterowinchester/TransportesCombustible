package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.MercanciaConfiguracionModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasConfiguracionRepository;

@Service
public class MercanciaConfiguracionService {
    @Autowired
    MercanciasConfiguracionRepository mercanciasConfiguracionRepository;

    public ArrayList<MercanciaConfiguracionModel> getAllConfiguraciones(){
        return (ArrayList<MercanciaConfiguracionModel>) mercanciasConfiguracionRepository.findAll();
    }

    public MercanciaConfiguracionModel saveConfiguracion(MercanciaConfiguracionModel mercanciaConfiguracion){
        return mercanciasConfiguracionRepository.save(mercanciaConfiguracion);
    } 

    public ResponseEntity<Map<String, String>> deleteConfiguracion(Integer id){
        mercanciasConfiguracionRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Camión eliminado correctamente"));
    } 

}
