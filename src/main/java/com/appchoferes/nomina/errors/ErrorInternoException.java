package com.appchoferes.nomina.errors;

public class ErrorInternoException extends RuntimeException {
    public ErrorInternoException(String mensaje) {
        super(mensaje);
    }
}