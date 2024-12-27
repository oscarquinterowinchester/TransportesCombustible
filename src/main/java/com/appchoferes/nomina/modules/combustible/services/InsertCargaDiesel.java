package com.appchoferes.nomina.modules.combustible.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.combustible.dtos.ComCargaDieselDTO;
import com.appchoferes.nomina.modules.combustible.models.Caja;
import com.appchoferes.nomina.modules.combustible.models.Camion;
import com.appchoferes.nomina.modules.combustible.models.CargaDiesel;
import com.appchoferes.nomina.modules.combustible.models.Chofer;
import com.appchoferes.nomina.modules.combustible.models.Estado;
import com.appchoferes.nomina.modules.combustible.models.MetodoPago;
import com.appchoferes.nomina.modules.combustible.models.Proveedor;
import com.appchoferes.nomina.modules.combustible.models.Usuario;
import com.appchoferes.nomina.modules.combustible.repositories.CajasConCargaRepository;
import com.appchoferes.nomina.modules.combustible.repositories.CamionesConCargaRepository;
import com.appchoferes.nomina.modules.combustible.repositories.CombustibleCargasDieselRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InsertCargaDiesel {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    @Autowired
    private CamionesConCargaRepository camionesConCargaRepository;

    @Autowired
    private CajasConCargaRepository cajasConCargaRepository;

    public CargaDiesel insertarCargaDiesel(ComCargaDieselDTO comCargaDieselDTO) {
        CargaDiesel cargaDiesel = mapToEntity(comCargaDieselDTO);
        combustibleCargasDieselRepository.insertarCargaDiesel(cargaDiesel);
        return cargaDiesel;
    }

    private CargaDiesel mapToEntity(ComCargaDieselDTO comCargaDieselDTO) {
        CargaDiesel cargaDiesel = new CargaDiesel();
        cargaDiesel.setCargaId(comCargaDieselDTO.getCargaId());
        cargaDiesel.setTipo(comCargaDieselDTO.getTipo());
        cargaDiesel.setLitrosECM(comCargaDieselDTO.getLitrosECM());
        cargaDiesel.setLitros(comCargaDieselDTO.getLitros());
        cargaDiesel.setFecha(comCargaDieselDTO.getFecha());
        cargaDiesel.setHora(comCargaDieselDTO.getHora());
        cargaDiesel.setFechayHora(comCargaDieselDTO.getFechayHora());
        cargaDiesel.setFolio(comCargaDieselDTO.getFolio());
        cargaDiesel.setNota(comCargaDieselDTO.getNota());
        cargaDiesel.setFechaRegistro(comCargaDieselDTO.getFechaRegistro());
        cargaDiesel.setStatus(comCargaDieselDTO.getStatus());
        cargaDiesel.setAjusteOdometro(comCargaDieselDTO.getAjusteOdometro());
        cargaDiesel.setSerieBomba(comCargaDieselDTO.getSerieBomba());
        cargaDiesel.setRendimientoCarga(comCargaDieselDTO.getRendimientoCarga());
        cargaDiesel.setRendimientoECM(comCargaDieselDTO.getRendimientoECM());
        cargaDiesel.setOdometroCarga(comCargaDieselDTO.getOdometroCarga());
        cargaDiesel.setOdometroECM(comCargaDieselDTO.getOdometroECM());
        cargaDiesel.setRecorridoCarga(comCargaDieselDTO.getRecorridoCarga());
        cargaDiesel.setRecorridoECM(comCargaDieselDTO.getRecorridoECM());
        cargaDiesel.setSellos(comCargaDieselDTO.getSellos());
        cargaDiesel.setPrecioTotal(comCargaDieselDTO.getPrecioTotal());
        cargaDiesel.setMonedaCarga(comCargaDieselDTO.getMonedaCarga());
        cargaDiesel.setFotoSello(comCargaDieselDTO.getFotoSello());
        cargaDiesel.setFotoOdometro(comCargaDieselDTO.getFotoOdometro());
        cargaDiesel.setFirma(comCargaDieselDTO.getFirma());
        cargaDiesel.setFotoTanque1(comCargaDieselDTO.getFotoTanque1());
        cargaDiesel.setFotoTanque2(comCargaDieselDTO.getFotoTanque2());
        cargaDiesel.setFromWS(comCargaDieselDTO.getFromWS());
        cargaDiesel.setRecorridoRutas(comCargaDieselDTO.getRecorridoRutas());
        cargaDiesel.setOdometroAjustado(comCargaDieselDTO.getOdometroAjustado());
        cargaDiesel.setUsuarioAjuste(comCargaDieselDTO.getUsuarioAjuste());
        cargaDiesel.setFechaAjuste(comCargaDieselDTO.getFechaAjuste());
        cargaDiesel.setMotivoAjuste(comCargaDieselDTO.getMotivoAjuste());
        cargaDiesel.setEsChofer(comCargaDieselDTO.getEsChofer());

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(comCargaDieselDTO.getUsuarioId());
        cargaDiesel.setUsuario(usuario);

        Chofer chofer = new Chofer();
        chofer.setId(comCargaDieselDTO.getChoferId());
        cargaDiesel.setChofer(chofer);

        Estado estado = new Estado();
        estado.setEstadoId(comCargaDieselDTO.getEstadoId());
        cargaDiesel.setEstado(estado);

        Proveedor proveedor = new Proveedor();
        proveedor.setProveedorId(comCargaDieselDTO.getProveedorId());
        cargaDiesel.setProveedor(proveedor);

        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setMetodoId(comCargaDieselDTO.getMetodoPagoId());
        cargaDiesel.setMetodoPago(metodoPago);

        Long unidadId = comCargaDieselDTO.getUnidadId();
        if (camionesConCargaRepository.existsById(unidadId)) {
            Camion camion = new Camion();
            camion.setId(comCargaDieselDTO.getUnidadId());
            cargaDiesel.setCamion(camion);
        } else if (cajasConCargaRepository.existsById(unidadId)) {
            Caja caja = new Caja();
            caja.setId(comCargaDieselDTO.getUnidadId());
            cargaDiesel.setCaja(caja);
        } else {
            throw new EntityNotFoundException("Unidad no encontrada");
        }

        return cargaDiesel;
    }
}
