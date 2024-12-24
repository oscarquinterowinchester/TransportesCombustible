package com.appchoferes.nomina.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CargaDieselEntity;
import com.appchoferes.nomina.dtos.CargasDieselEntityOld;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.operaciones.UtilsCarga;
import com.appchoferes.nomina.repositories.CargasDieselRepository;
import com.appchoferes.nomina.validators.Validador;

@Service
public class CargaDieselService {


    @Autowired
    CargasDieselRepository cargasDieselRepository;

    @Autowired
    Validador val;

    public CargaDieselEntity obtenerCargaPorId(String cargaId,String dbType)
    {
        Utils.establecerBaseDatos(dbType);
        return cargasDieselRepository.findByCargaId(Integer.parseInt(cargaId));
            }

    public ResponseEntity<String> procesarCarga(CargasDieselEntityOld carga,String dbType)
    {
        HttpStatusCode codigoFormatoIncorrecto = HttpStatusCode.valueOf(400);
        int operacionInsercion = 0;

        Utils.establecerBaseDatos(dbType);

        ResponseEntity<String> respuestaCamposValidos = UtilsCarga.revisarCampos(carga,cargasDieselRepository,operacionInsercion);

        if(respuestaCamposValidos.getStatusCode() == codigoFormatoIncorrecto){
            return respuestaCamposValidos;
        }
        
        String ultimoOdometro = UtilsCarga.obtenerUltimoOdometro(carga, cargasDieselRepository, operacionInsercion);
        carga.calcularRecorridoyRendimiento(ultimoOdometro);

        cargasDieselRepository.save(carga);

        return respuestaCamposValidos;
    }
    

    public ResponseEntity<String> actualizarCargaPorCampos(String cargaId, Map<String, Object> campos, String dbType) {
        
        Map<String,Object> errores = null;
        int cargaIdInt = Validador.validarInteger(cargaId); 
        int operacionActualizar = 1;

        if(cargaIdInt <= 0)
        {
            return ResponseEntity.badRequest().body("Error en formato, cargaId no valida");
        }

        Utils.establecerBaseDatos(dbType);

        CargaDieselEntity cargaExistente = cargasDieselRepository.findByCargaId(cargaIdInt);

        cargaExistente = UtilsCarga.asignarDatosDeCarga(campos, cargaExistente);

        errores = UtilsCarga.datosCargaSonValidos(cargaExistente,cargasDieselRepository,operacionActualizar);

        Boolean campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));
        String mensajeError = "Error en los formatos: "+ errores.get("campoErroneo");

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body(mensajeError); // Invalid data
        }

        String ultimoOdometro = UtilsCarga.obtenerUltimaFecha(cargaExistente, cargasDieselRepository, operacionActualizar);
        cargaExistente.calcularRecorridoyRendimiento(ultimoOdometro);
        
        cargasDieselRepository.save(cargaExistente);
    
        return ResponseEntity.ok("Actualizado con exito"); // Retornar la entidad actualizada
    }

    
    


}
