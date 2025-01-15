package com.appchoferes.nomina.services.durandb;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class RespuestaServidor {
    private String cuerpo;
    private HttpStatus estado;

    public RespuestaServidor(String cuerpo, HttpStatusCode httpStatusCode) {
        this.cuerpo = cuerpo;
        this.estado = (HttpStatus) httpStatusCode;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }
}
