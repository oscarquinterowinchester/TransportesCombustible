package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.FuelGroupModel;
import com.appchoferes.nomina.services.durandb.FuelGroupService;

@RestController
@RequestMapping("/fuel-group")
public class FuelGroupController {
    @Autowired
    FuelGroupService fuelGroupService;

    @GetMapping()
    public ArrayList<FuelGroupModel> obtenerFuelGroup() {
        return fuelGroupService.obtenerFuelGroup();
    }

}
