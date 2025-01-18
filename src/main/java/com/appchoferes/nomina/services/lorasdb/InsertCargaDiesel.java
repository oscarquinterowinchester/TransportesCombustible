package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.repositories.lorasdb.CajasConCargaRepository;
import com.appchoferes.nomina.repositories.lorasdb.CamionesConCargaRepository;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleCargasDieselRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InsertCargaDiesel {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    @Autowired
    private CamionesConCargaRepository camionesConCargaRepository;

    @Autowired
    private CajasConCargaRepository cajasConCargaRepository;

    public CargaDiesel insertarCargaDiesel(CargaDiesel cargaDiesel) {
        validarCargaDiesel(cargaDiesel);
        return combustibleCargasDieselRepository.save(cargaDiesel);
    }

    private void validarCargaDiesel(CargaDiesel cargaDiesel) {
        System.out.println("Validando cargaDiesel: " + cargaDiesel);

        Long unidadId = cargaDiesel.getCamion() != null ? cargaDiesel.getCamion().getId() : null;

        if (unidadId == null || !camionesConCargaRepository.existsById(unidadId)) {
            throw new EntityNotFoundException("Unidad (Camión) no encontrada");
        }

        if (cargaDiesel.getChofer() == null ||
                cargaDiesel.getChofer().getId() == 0) {
            throw new EntityNotFoundException("Chofer no especificado");
        }

        if (cargaDiesel.getProveedor() == null || cargaDiesel.getProveedor().getProveedorId() == null) {
            throw new EntityNotFoundException("Proveedor no especificado");
        }

        if (cargaDiesel.getMetodoPago() == null ||
                cargaDiesel.getMetodoPago().getMetodoId() == 0) {
            throw new EntityNotFoundException("Método de pago no especificado");
        }
    }
}
