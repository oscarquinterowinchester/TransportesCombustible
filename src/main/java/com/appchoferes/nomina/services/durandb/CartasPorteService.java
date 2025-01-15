package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CartasPorteModel;
import com.appchoferes.nomina.repositories.durandb.CartasPorteRepository;

@Service
public class CartasPorteService {

    @Autowired
    CartasPorteRepository cartasPorteRepository;

    public ArrayList<CartasPorteModel> obtenerCartas() {
        return (ArrayList<CartasPorteModel>) cartasPorteRepository.findAll();
    }

    public CartasPorteModel registrarCartas(CartasPorteModel cartas) {
        System.out.println("Fecha enviada2: " + cartas.getFechaRegistro());
        return cartasPorteRepository.save(cartas);
    }

    public CartasPorteModel obtenerUltimoRegistro() {
        return cartasPorteRepository.findFirstByOrderByFechaRegistroDesc();
    }

    public Optional<CartasPorteModel> findById(int id) {
        return cartasPorteRepository.findById(id);
    }

    public CartasPorteModel obtenerUltimoRegistroId() {
        return cartasPorteRepository.findFirstByOrderByCartaPorteIDDesc();
    }

    public CartasPorteModel findFirstByGeneracionCartaPorteOrderByFechaRegistroDesc() {
        return cartasPorteRepository.findFirstByGeneracionCartaPorteOrderByFechaRegistroDesc(2);
    }

    public CartasPorteModel findByUUID(String folio) {
        return cartasPorteRepository.findByUUID(folio);
    }

}
