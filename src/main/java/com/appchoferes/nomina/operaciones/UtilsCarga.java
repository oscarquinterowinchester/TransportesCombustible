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

import com.appchoferes.nomina.dtos.CargaDieselEntity;
import com.appchoferes.nomina.dtos.CargasDieselEntityOld;
import com.appchoferes.nomina.repositories.CargasDieselRepository;
import com.appchoferes.nomina.validators.Validador;

public class UtilsCarga {
    @Autowired
    static CargasDieselRepository cargasDieselRepository;

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

    /*public static Map<String,Object> datosCargaSonValidos(CargaDieselEntity cargaExistente,CargasDieselRepository repo,int tipoOperacion){
        
        Map<String,Object> errores = new HashMap<>();
        if(cargaExistente == null){
            errores.put("campoErroneo", "Carga invalida");
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(cargaExistente.getTipo()) > 1 || Validador.validarInteger(cargaExistente.getTipo()) < 0){
            errores.put("campoErroneo", "Tipo unidad invalido: " + cargaExistente.getTipo());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarInteger(cargaExistente.getUnidadId()) <= 0)
        {
            errores.put("campoErroneo", "UnidadID: " + cargaExistente.getUnidadId());
            errores.put("esValido", false);
            return errores; 
        }
        if(Validador.validarInteger(cargaExistente.getTipoCombustible()) <= 0 ){
            errores.put("campoErroneo", "Tipo de combustible no valido: " + cargaExistente.getTipoCombustible());
            errores.put("esValido", false);    
            return errores;
        }
        if(Validador.validarInteger(cargaExistente.getUsuarioId()) <= 0)
        {
            errores.put("campoErroneo", "UsuarioID no puede ser 0: " + cargaExistente.getUsuarioId());
            errores.put("esValido", false);
            return errores;      
        }
        if(Validador.validarInteger(cargaExistente.getMonedaCarga()) > 1 || Validador.validarInteger(cargaExistente.getMonedaCarga()) < 0){
            errores.put("campoErroneo", "Moneda carga solo acepta 1 o 0: " + cargaExistente.getMonedaCarga());
            errores.put("esValido", false);
            return errores;
        }
        if(Validador.validarDouble(cargaExistente.getLitros()) <= 0.0)
        {
            errores.put("campoErroneo", "Litros no validos; no puede ser 0 y no numerico: " + cargaExistente.getLitros());
            errores.put("esValido", false);
            return errores;      
        }
        if(Validador.validarDouble(cargaExistente.getPrecioTotal()) <= 0.0)
        {
            errores.put("campoErroneo", "Precio total no puede ser 0: " + cargaExistente.getPrecioTotal());
            errores.put("esValido", false);
            return errores;      
        }
        if(distanciaNoEsValida(cargaExistente,repo,tipoOperacion))
        {
            errores.put("campoErroneo", "Odometro no valido; no puede ser 0, menor o mayor a 4000 del ultimo: " + cargaExistente.getOdometroCarga());
            errores.put("esValido", false);
            return errores;
        }
        if(fechaNoEsValida(cargaExistente,repo,tipoOperacion))
        {
            errores.put("campoErroneo", "Fecha no puede ser menor a la ultima: " + cargaExistente.getFecha());
            errores.put("esValido", false);   
            return errores;
        }
        if(Validador.validarTime(String.valueOf(cargaExistente.getHora())) == null)
        {
            System.out.println("HoraRaw: " + cargaExistente.getHora());
            errores.put("campoErroneo", "Hora no valida: " + cargaExistente.getHora());
            errores.put("esValido", false);   
            return errores;
        }
        errores.put("campoErroneo", "");
        errores.put("esValido", true); 
        return errores;
    }*/



    public static boolean fechaNoEsValida(CargaDieselEntity carga,CargasDieselRepository repo,int tipoOperacion){

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

    public static String obtenerUltimaFecha(CargaDieselEntity carga,CargasDieselRepository repo,int tipoOperacion){

        String unidadId = String.valueOf(carga.getUnidadId());
        int tipoUnidad = carga.getTipo();

       String ultimaFecha = repo.obtenerUltimaFecha(unidadId, tipoUnidad, tipoOperacion);

        return ultimaFecha;
    }

    public static boolean distanciaNoEsValida(CargaDieselEntity carga,CargasDieselRepository repo,int tipoOperacion){
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

    public static String obtenerUltimoOdometro(CargasDieselEntityOld carga,CargasDieselRepository repo,int tipoOperacion){

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

    public static ResponseEntity<String> revisarCampos(CargasDieselEntityOld carga,CargasDieselRepository cargasDieselRepository2,int tipoOperacion) {
        
        Map<String,Object> errores = null;
        Boolean campoEsValido = false; // Declaracion

        errores = UtilsCarga.datosCargaSonValidos(carga,cargasDieselRepository2,tipoOperacion);
        campoEsValido = Validador.validarBoolean(String.valueOf(errores.get("esValido")));

        if(campoEsValido == false){
            return ResponseEntity.badRequest().body("Error en los formatos: "+ errores.get("campoErroneo")); // Invalid data
        } // Validacion de datos

        return ResponseEntity.ok("guardado con exito!");
    }

    public static Map<String, Object> datosCargaSonValidos(CargaDieselEntity cargaExistente,
            CargasDieselRepository cargasDieselRepository2, int operacionActualizar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'datosCargaSonValidos'");
    }

    

}
