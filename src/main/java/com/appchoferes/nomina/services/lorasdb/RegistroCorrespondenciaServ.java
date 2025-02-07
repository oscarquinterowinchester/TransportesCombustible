package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroFirmaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroInicialDTO;
import com.appchoferes.nomina.repositories.lorasdb.RegistroCorrespondenciaRepo;
import com.appchoferes.nomina.utils.ImageUtil;


@Service
public class RegistroCorrespondenciaServ {

    @Autowired
    private RegistroCorrespondenciaRepo rCrepo;

    public List<RegistroCorrespondencia> getRegistrosC(){
        List<RegistroCorrespondencia> registrosC = rCrepo.getRegistrosC();
        return registrosC;
    }

        public RegistroCorrespondencia saveRegistro(RegistroInicialDTO registroInicial) {
        // Mapear el DTO a la entidad
        RegistroCorrespondencia registro = new RegistroCorrespondencia();
        registro.setUsuario(registroInicial.getUsuario());
        registro.setFechaRecibido(registroInicial.getFechaRecibido());
        registro.setTipoCorrespondencia(registroInicial.getTipoCorrespondencia());
        registro.setInspeccion(registroInicial.getInspeccion());
        registro.setAreaCorrespondencia(registroInicial.getAreaCorrespondencia());
        registro.setFirma(""); // Valor por defecto

        // Guardar el registro
        return rCrepo.save(registro);
    }

    public RegistroCorrespondencia saveFirma(RegistroFirmaDTO registroFirma) throws Exception {
        // Buscar el registro existente
        RegistroCorrespondencia registroExistente = rCrepo.findById(registroFirma.getId())
            .orElseThrow(() -> new IllegalArgumentException("Registro no encontrado"));

        // Guardar la firma, cambiar directorio por el del servidor
        if (registroFirma.getFirma() != null) {
            String firmaPath = ImageUtil.saveImage(registroFirma.getFirma(), "firma-entregado", "/home/drago/work/lorasImagenes/firmas/");
            registroExistente.setFirma(firmaPath);
        }

        if (registroFirma.getFecha() != null) {
            registroExistente.setFechaEntrega(registroFirma.getFecha());
        }

        // Guardar el registro actualizado
        return rCrepo.save(registroExistente);
    }
}
