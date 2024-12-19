package com.appchoferes.nomina.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CamionCarga;
import com.appchoferes.nomina.dtos.CargasDiesel;
import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.repositories.ICamionCargaRepository;
import com.appchoferes.nomina.repositories.ICargasDieselRepository;
import com.appchoferes.nomina.repositories.IMetodosPagoRepository;
import com.appchoferes.nomina.repositories.IProveedoresRepository;
import com.appchoferes.nomina.repositories.ITiposCombustibleRepository;

@Service
public class VistaCargaCamionService {

    @Autowired
    ICamionCargaRepository camionCargaRepository;
    @Autowired
    IProveedoresRepository proveedoresRepository;
    @Autowired
    ICargasDieselRepository cargasDieselRepository;
    @Autowired
    ITiposCombustibleRepository tiposCombustibleRepository;
    @Autowired
    IMetodosPagoRepository metodosPagoRepository;

    public VistaCargaCamion getVistaCargaCamion(String choferId, String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);

        VistaCargaCamion vistaCamionCarga = new VistaCargaCamion();

        CamionCarga camionCarga = new CamionCarga();

        camionCarga = camionCargaRepository.getCamionCarga(choferId);

        vistaCamionCarga.setCamionId(camionCarga.getCamionId());
        vistaCamionCarga.setNoEconomico(camionCarga.getNoEconomico());
        vistaCamionCarga.setTanqueActual(camionCarga.getTanqueActual());

        List<CargasDiesel> cargasDiesel = cargasDieselRepository.getCargasDiesel(choferId);

        vistaCamionCarga.setCargasDiesel(cargasDiesel);
        vistaCamionCarga.setProveedores(proveedoresRepository.getProveedoresCombustible());
        vistaCamionCarga.setMetodosPagos(metodosPagoRepository.getMetodosPago());
        vistaCamionCarga.setTipoCombustibles(tiposCombustibleRepository.getTipoCombustible());
        return vistaCamionCarga;
    }

}
