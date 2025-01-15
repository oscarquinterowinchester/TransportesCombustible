package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.FuelGroupModel;
import com.appchoferes.nomina.repositories.durandb.FuelGroupRepository;

@Service
public class FuelGroupService {

    @Autowired
    FuelGroupRepository fuelGroupRepository;

    public ArrayList<FuelGroupModel> obtenerFuelGroup() {
        ArrayList<FuelGroupModel> FuelGroupList = (ArrayList<FuelGroupModel>) fuelGroupRepository.findAll();
        return FuelGroupList;
    }
}
