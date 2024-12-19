package com.appchoferes.nomina.operaciones;

import com.appchoferes.nomina.config.DatabaseContextHolder;

public class Utils {

public static void establecerBaseDatos(String baseDatos)
    {
        DatabaseContextHolder.setDatabaseType(baseDatos);   
    }

    public static String toStr(float valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public static String toStr(int valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public static String toStr(Object valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    public static String toStr(Double valor){

        String str = "";

        try{
            str = String.valueOf(valor);
        }catch(NullPointerException e){

        }
        return str;

    }

    
}
