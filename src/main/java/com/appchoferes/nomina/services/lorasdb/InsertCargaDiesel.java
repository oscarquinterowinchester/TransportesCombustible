package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Caja;
import com.appchoferes.nomina.models.lorasdb.Camion;
import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.models.lorasdb.Chofer;
import com.appchoferes.nomina.models.lorasdb.Estado;
import com.appchoferes.nomina.models.lorasdb.MetodoPago;
import com.appchoferes.nomina.models.lorasdb.Proveedor;
import com.appchoferes.nomina.models.lorasdb.Usuario;
import com.appchoferes.nomina.models.lorasdb.dtos.ComCargaDieselDTO;
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

    public CargaDiesel insertarCargaDiesel(ComCargaDieselDTO comCargaDieselDTO) {
        CargaDiesel cargaDiesel = mapToEntity(comCargaDieselDTO);
        CargaDiesel insertedCarga = combustibleCargasDieselRepository.insertarCargaDiesel(cargaDiesel);
        return insertedCarga;
    }

    private CargaDiesel mapToEntity(ComCargaDieselDTO comCargaDieselDTO) {
        CargaDiesel cargaDiesel = new CargaDiesel();
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
