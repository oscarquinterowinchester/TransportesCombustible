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
import com.appchoferes.nomina.dtos.CargasDieselEntityOld;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.operaciones.UtilsCarga;
import com.appchoferes.nomina.repositories.CargasDieselReporsitory;
import com.appchoferes.nomina.validators.Validador;

@Service
public class CargaDieselService {


    @Autowired
    CargasDieselReporsitory cargasDieselReporsitory;

    @Autowired
    Validador val;

    public CargasDieselEntity obtenerCargaPorId(String cargaId,String dbType)
    {
        Utils.establecerBaseDatos(dbType);
        return cargasDieselReporsitory.findByCargaId(Integer.parseInt(cargaId));
            }

    public ResponseEntity<String> procesarCarga(CargasDieselEntity carga,String dbType)
    {
        HttpStatusCode codigoFormatoIncorrecto = HttpStatusCode.valueOf(400);
        int operacionInsercion = 0;

        Utils.establecerBaseDatos(dbType);

        ResponseEntity<String> respuestaCamposValidos = UtilsCarga.revisarCampos(carga,cargasDieselReporsitory,operacionInsercion);

        if(respuestaCamposValidos.getStatusCode() == codigoFormatoIncorrecto){
            return respuestaCamposValidos;
        }
        
        String ultimoOdometro = UtilsCarga.obtenerUltimoOdometro(carga, cargasDieselReporsitory, operacionInsercion);
        carga.calcularRecorridoyRendimiento(ultimoOdometro);

        cargasDieselReporsitory.save(carga);

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

        CargasDieselEntity cargaExistente = cargasDieselReporsitory.findByCargaId(cargaIdInt);

        cargaExistente = UtilsCarga.asignarDatosDeCarga(campos, cargaExistente);

        errores = UtilsCarga.datosCargaSonValidos(cargaExistente,cargasDieselReporsitory,operacionActualizar);

        Boolean campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));
        String mensajeError = "Error en los formatos: "+ errores.get("campoErroneo");

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body(mensajeError); // Invalid data
        }

        String ultimoOdometro = UtilsCarga.obtenerUltimoOdometro(cargaExistente, cargasDieselReporsitory, operacionActualizar);
        cargaExistente.calcularRecorridoyRendimiento(ultimoOdometro);
        
        cargasDieselReporsitory.save(cargaExistente);
    
        return ResponseEntity.ok("Actualizado con exito"); // Retornar la entidad actualizada
    }

    
    


}
