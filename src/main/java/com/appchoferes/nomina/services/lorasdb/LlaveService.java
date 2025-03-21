package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Llaves;
import com.appchoferes.nomina.models.lorasdb.dtos.LlaveRequest;
import com.appchoferes.nomina.repositories.lorasdb.LlavesRepository;
import com.appchoferes.nomina.utils.S3Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LlaveService {

    @Autowired
    private LlavesRepository llaveRepository;

    @Autowired
    private S3Service s3Service;

    public void registrarLlave(LlaveRequest llaveRequest) throws Exception {

        if (llaveRequest.getFirma() != null) {
            String path = s3Service.uploadFile("patios/llaves/firmas", "Firma",
                    llaveRequest.getCamionID() + "_" + llaveRequest.getFecha(), llaveRequest.getFirma());
            llaveRequest.setFirma(path);
        }

        String fechaHora = llaveRequest.getFecha() + " " + llaveRequest.getHora();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaCompleta = LocalDateTime.parse(fechaHora, formatter);

        Llaves llave = new Llaves();
        llave.setPatioID(llaveRequest.getPatioID());
        llave.setUsuarioID(llaveRequest.getUsuarioID());
        llave.setChoferID(llaveRequest.getChoferID());
        llave.setCamionID(llaveRequest.getCamionID());
        llave.setFecha(fechaCompleta);
        llave.setTipo(llaveRequest.getTipo());
        llave.setComentario(llaveRequest.getComentario());
        llave.setFirma(llaveRequest.getFirma());

        llaveRepository.save(llave);
    }
}
