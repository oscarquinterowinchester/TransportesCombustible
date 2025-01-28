package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.RutasClientePatio;
import com.appchoferes.nomina.repositories.lorasdb.RutasClienteRepo;

@Service
public class RutasClienteServ {

    @Autowired
    private RutasClienteRepo rutasClienteRepo;

    public List<RutasClientePatio> getRutasClientesPatios(Long clienteID) {
        List<Object[]> resultado = rutasClienteRepo.getRutaClienteRaw(clienteID);

        return resultado.stream()
                .map(obj -> new RutasClientePatio(((Number) obj[0]).longValue(), (String) obj[1], ((Boolean) obj[2])))
                .collect(Collectors.toList());
    }
    
}
