package com.appchoferes.nomina.operaciones;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;

import com.appchoferes.nomina.modules.combustible.models.CargaDieselEntity;
import com.appchoferes.nomina.repositories.CargasDieselReporsitory;
import com.appchoferes.nomina.validators.Validador;

public class UtilsCarga {
    @Autowired
    static CargasDieselReporsitory cargasDieselReporsitory;

    

    

    public static CargaDieselEntity asignarDatosDeCarga(Map<String, Object> campos, CargaDieselEntity cargaExistente){

        campos.forEach((key, value) -> {
            // Usar reflection para encontrar el setter correspondiente
            String setterName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1); // Generar el nombre del setter
            Class<? extends Object> tipoClase = (key.equalsIgnoreCase("Fecha") ? LocalDate.class : value.getClass());


            Method setter = ReflectionUtils.findMethod(CargaDieselEntity.class, setterName, tipoClase);
            value = convertirDatoASuClase(value,key); 
            try {
                if (setter == null) {
                    System.out.println("No se encontro un setter para el campo: " + setterName+ " value: "+ tipoClase);
                    return; // Terminar esta iteración y pasar a la siguiente
                }
                setter.invoke(cargaExistente, value); // Invocar el setter
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("Error invocando el metodo setter: " + e.getMessage());
            }
        });

        return cargaExistente;
    }

    private static Object convertirDatoASuClase(Object valor,String NombreCampo){
        Object valorRetorno = valor;
        if(NombreCampo.equalsIgnoreCase("Fecha")){
            LocalDate fecha = Validador.validarLocalDate(valor.toString());
            valorRetorno = fecha;
        }
        if(NombreCampo.equalsIgnoreCase("Hora")){
            Time hora = Validador.validarTime(valor.toString());
            valorRetorno = hora;
        }
        return valorRetorno;
    }

    public static Map<String,Object> datosCargaSonValidos(CargaDieselEntity carga,CargasDieselReporsitory repo,int tipoOperacion){
        
        Map<String,Object> errores = new HashMap<>();
        if(carga == null){
            errores.put("campoErroneo", "Carga invalida");
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(carga.getTipo()) > 1 || Validador.validarInteger(carga.getTipo()) < 0){
            errores.put("campoErroneo", "Tipo unidad invalido: " + carga.getTipo());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(carga.getUnidadId()) <= 0)
        {
            errores.put("campoErroneo", "UnidadID: " + carga.getUnidadId());
            errores.put("esValido", false);
            return errores; 
        }
        if(Validador.validarInteger(carga.getTipoCombustible()) <= 0 ){
            errores.put("campoErroneo", "Tipo de combustible no valido: " + carga.getTipoCombustible());
            errores.put("esValido", false);    
            return errores;
        }
        if(Validador.validarInteger(carga.getUsuarioId()) <= 0)
        {
            errores.put("campoErroneo", "UsuarioID no puede ser 0: " + carga.getUsuarioId());
            errores.put("esValido", false);
            return errores;      
        }
        if(Validador.validarInteger(carga.getMonedaCarga()) > 1 || Validador.validarInteger(carga.getMonedaCarga()) < 0){
            errores.put("campoErroneo", "Moneda carga solo acepta 1 o 0: " + carga.getMonedaCarga());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarDouble(carga.getLitros()) <= 0.0)
        {
            errores.put("campoErroneo", "Litros no validos; no puede ser 0 y no numerico: " + carga.getLitros());
            errores.put("esValido", false);
            return errores;      
        }
        if(Validador.validarDouble(carga.getPrecioTotal()) <= 0.0)
        {
            errores.put("campoErroneo", "Precio total no puede ser 0: " + carga.getPrecioTotal());
            errores.put("esValido", false);
            return errores;      
        }
        if(distanciaNoEsValida(carga,repo,tipoOperacion))
        {
            errores.put("campoErroneo", "Odometro no valido; no puede ser 0, menor o mayor a 4000 del ultimo: " + carga.getOdometroCarga());
            errores.put("esValido", false);
            return errores;
        }
        if(fechaNoEsValida(carga,repo,tipoOperacion))
        {
            errores.put("campoErroneo", "Fecha no puede ser menor a la ultima: " + carga.getFecha());
            errores.put("esValido", false);   
            return errores;
        }
        if(Validador.validarTime(String.valueOf(carga.getHora())) == null)
        {
            System.out.println("HoraRaw: " + carga.getHora());
            errores.put("campoErroneo", "Hora no valida: " + carga.getHora());
            errores.put("esValido", false);   
            return errores;
        }
        errores.put("campoErroneo", "");
        errores.put("esValido", true); 
        return errores;
    }



    public static boolean fechaNoEsValida(CargaDieselEntity carga,CargasDieselReporsitory repo,int tipoOperacion){

        boolean esPrimerRegistro = repo.esPrimerRegistro(carga.getUnidadId(), carga.getTipo());
        boolean esFechaNula = (Validador.validarDate(String.valueOf(carga.getFecha())) == null);

        if(esFechaNula){
            return true; // Mandar el error
        }
        if(esPrimerRegistro){ // No hace falta validar fechas
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // adjust the pattern to match your string format
        String ultimaFechaStr = obtenerUltimaFecha(carga,repo,tipoOperacion);
        LocalDateTime ultimaFecha = LocalDateTime.parse(ultimaFechaStr, formatter);
        String fechaCargaStr = (carga.getFecha() + " " + carga.getHora());
        LocalDateTime fechaDeCarga = LocalDateTime.parse(fechaCargaStr,formatter);

         boolean fechaEsValida = (fechaDeCarga.isBefore(ultimaFecha) || fechaDeCarga.isEqual(ultimaFecha));
        
        return fechaEsValida;
    }

    private static String obtenerUltimaFecha(CargaDieselEntity carga,CargasDieselReporsitory repo,int tipoOperacion){

        String unidadId = String.valueOf(carga.getUnidadId());
        int tipoUnidad = carga.getTipo();

       String ultimaFecha = repo.obtenerUltimaFecha(unidadId, tipoUnidad, tipoOperacion);

        return ultimaFecha;
    }

    public static boolean distanciaNoEsValida(CargaDieselEntity carga,CargasDieselReporsitory repo,int tipoOperacion){
        boolean esPrimerRegistro = repo.esPrimerRegistro(carga.getUnidadId(), carga.getTipo());
        boolean esOdoCargaInvalido  = Validador.validarDouble(carga.getOdometroCarga()) <= 0;
        
        if(esOdoCargaInvalido){
            return true;
        }
        if(esPrimerRegistro){ // No hace falta validar odometro
            return false;
        }
        String ultimoOdometro = obtenerUltimoOdometro(carga,repo,tipoOperacion);

        double recorrido =  calcularRecorrido(carga,ultimoOdometro);

        boolean recorridoEsValido = !(recorrido <= Globals.MAX_DISTANCIA && recorrido > 0);
        
        return recorridoEsValido;
    }

    public static String obtenerUltimoOdometro(CargaDieselEntity carga,CargasDieselReporsitory repo,int tipoOperacion){

        String unidadId = String.valueOf(carga.getUnidadId());
        int tipoUnidad = carga.getTipo();

       String ultimoOdometro = repo.obtenerUltimoOdometro(unidadId, tipoUnidad, tipoOperacion);

        return ultimoOdometro;
    }
    
    public static double calcularRecorrido(CargaDieselEntity carga,String ultimoOdometroStr)
    {
        double odometroUltimo = Validador.validarDouble(ultimoOdometroStr);
        double odometroActual = carga.getOdometroCarga();
        double recorrido = 0.0;

        try{
        recorrido = odometroActual - odometroUltimo;
        }catch(ArithmeticException e){
            System.out.println("Error al calcular el recorrido: " + recorrido);
        }

        return recorrido;
    }

    public static double calcularRendimiento(double recorrido,double litros)
    {
        double rendimiento = 0.0;

        try{
            rendimiento = recorrido / litros;
            }catch(ArithmeticException e){
                rendimiento = 0.0;
                System.out.println("Error al calcular el recorrido: " + recorrido);
            }
            
        return rendimiento;
    }

    public static ResponseEntity<String> revisarCampos(CargaDieselEntity carga,CargasDieselReporsitory cargasDieselReporsitory2,int tipoOperacion) {
        
        Map<String,Object> errores = null;
        Boolean campoEsValido = false; // Declaracion

        errores = UtilsCarga.datosCargaSonValidos(carga,cargasDieselReporsitory2,tipoOperacion);
        campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body("Error en los formatos: "+ errores.get("campoErroneo")); // Invalid data
        } // Validacion de datos

        return ResponseEntity.ok("guardado con exito!");
    }

    

}
