package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Sizes;
import com.appchoferes.nomina.repositories.lorasdb.SizesRepository;

@Service
public class SizesServ {

    @Autowired
    private SizesRepository sizesRepository;

    public List<Sizes> getSizes() {
        List<Sizes> sizes = sizesRepository.getSizes();
        return sizes;
    }

}
