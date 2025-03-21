package com.appchoferes.nomina.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HoraUtil {

    public static LocalTime convertHora12a24(String hora12) {

        // Definicion del formato de hora con AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", java.util.Locale.US);

        String horaNormalizada = hora12.replace("p.m.", "PM").replace("a.m.", "AM").trim();
        
        // Convertimos la hora a formato 24 horas
        return LocalTime.parse(horaNormalizada, formatter);

    }
}
