package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.Sizes;
import com.appchoferes.nomina.services.lorasdb.SizesServ;

@RestController
@RequestMapping("/patios")
public class P_SizesController {

    @Autowired
    private SizesServ sizesServ;

    @GetMapping("/sizes-patios")
    public List<Sizes> getSizes() {
        return sizesServ.getSizes();
    }

}
