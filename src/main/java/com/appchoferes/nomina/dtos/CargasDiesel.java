package com.appchoferes.nomina.dtos;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CargasDiesel {
@Id
Long cargaId;
String fecha;
Double rendimientoCarga;
Double rendimientoEsperado;
String sellos;
String segundoSellos;

public Long getCargaId() {
    return cargaId;
}
public void setCargaId(Long cargaId) {
    this.cargaId = cargaId;
}
public String getFecha() {
    return fecha;
}
public void setFecha(String fecha) {
    this.fecha = fecha;
}
public Double getRendimientoCarga() {
    return rendimientoCarga;
}
public void setRendimientoCarga(Double rendimientoCarga) {
    this.rendimientoCarga = rendimientoCarga;
}
public Double getRendimientoEsperado() {
    return rendimientoEsperado;
}
public void setRendimientoEsperado(Double rendimientoEsperado) {
    this.rendimientoEsperado = rendimientoEsperado;
}
public String getSellos() {
    return sellos;
}
public void setSellos(String sellos) {
    this.sellos = sellos;
}
public String getSegundoSellos() {
    return segundoSellos;
}
public void setSegundoSellos(String segundoSellos) {
    this.segundoSellos = segundoSellos;
}



}
