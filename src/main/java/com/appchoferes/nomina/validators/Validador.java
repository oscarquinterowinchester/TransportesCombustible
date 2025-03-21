package com.appchoferes.nomina.validators;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.stereotype.Component;


@Component
public class Validador {

    public static void print(String cadena){
        System.out.println(cadena);
    }

    public static Time validarTime(String valorObjeto) {
        Time valorHora = null;
    
        // Verificar si el valor del objeto es nulo o inválido
        if (objetoNoEsValido(valorObjeto)) {
            return null;
        }
        // Definir el formato esperado de la hora
        // SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        // formatoHora.setLenient(false); // Desactivar la leniencia para una validación estricta
    
        try {
            // Intentar parsear el String a Date
            valorHora = Time.valueOf(valorObjeto);
        } catch (Exception e) {
            // Manejo de excepciones en caso de que el formato no sea válido
            System.out.println("El formato de la hora es inválido: " + e.getMessage());
        }
    
        return valorHora;
    }

    public static Date validarDate(String valorObjeto)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date valorDate = null;
        if(objetoNoEsValido(valorObjeto)){
            return null;
        }
        try{
            valorDate = formatoFecha.parse(valorObjeto.toString());
        }catch(ParseException e){
            print("Error al formatear la fecha: " + e);
        }
        return valorDate;
    }

    public static LocalDate validarLocalDate(String valorObjeto)
    {
        LocalDate valorDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(objetoNoEsValido(valorObjeto)){
            return null;
        }
        try{
            valorDate = LocalDate.parse(valorObjeto,formatter);

        }catch(Exception e){
            print("Error al formatear la fecha: " + e);
        }
        return valorDate;
    }

    public static int validarInteger(Object valorObjeto){
        if(objetoNoEsValido(valorObjeto)){
            return 0;
        }
        int valorInteger = 0;
        try{
            valorInteger = Integer.parseInt(valorObjeto.toString());
        }catch(NumberFormatException e){
            return 0;
        }
        return valorInteger;
    }

    public static Double validarDouble(Object valorObjeto){
        if(objetoNoEsValido(valorObjeto)){
            return 0.0;
        }
        Double valorDouble = 0.0;
        try{
            valorDouble = Double.parseDouble(valorObjeto.toString());
        }catch(NumberFormatException e){
            return 0.0;
        }
        return valorDouble;
    }

    public static Boolean validarBoolean(String valorObjeto) {
        Boolean valorBoolean = null;
    
        // Verificar si el valor del objeto es nulo o inválido
        if (objetoNoEsValido(valorObjeto)) {
            return false;
        }
            valorBoolean = Boolean.parseBoolean(valorObjeto.toString());
        return valorBoolean;
    }

    public static boolean objetoNoEsValido(Object valorObjeto){
        try{
        if(valorObjeto == null){
            return true;
        }
        if(valorObjeto.toString().isEmpty()){
            return true;
        }
        }catch(NullPointerException e){
            return true;
        }
        return false;
    } 

}
