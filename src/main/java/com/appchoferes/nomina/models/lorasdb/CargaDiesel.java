package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargasdiesel_tbl")
public class CargaDiesel {

    @Id
    @Column(name = "CargaID")
    // se usa GenerationType.IDENTITY para indicar que es autoincrementable
    // en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cargaId;

    @Column(name = "Tipo")
    @JsonProperty("Tipo")
    private Integer Tipo;

    @Column(name = "UnidadID")
    // JsonProperty indica como se llamar el valor en el Json generado
    // evitando que la libreria Jackson convierta el valor a camelCase
    @JsonProperty("UnidadID")
    private Integer UnidadID;

    @Column(name = "ProveedorID")
    @JsonProperty("ProveedorID")
    private Integer ProveedorID;

    @Column(name = "PrecioTotal")
    @JsonProperty("PrecioTotal")
    private Double PrecioTotal;

    @Column(name = "MonedaCarga")
    @JsonProperty("MonedaCarga")
    private Integer MonedaCarga;

    @Column(name = "Litros")
    @JsonProperty("Litros")
    private double Litros;

    @Column(name = "FotoTanque1")
    @JsonProperty("FotoTanque1")
    private String fotoTanque1;

    @Column(name = "FotoTanque2")
    @JsonProperty("FotoTanque2")
    private String fotoTanque2;

    @Column(name = "Folio")
    @JsonProperty("Folio")
    private String Folio;

    @Column(name = "Nota")
    @JsonProperty("Nota")
    private String Nota;

    @Column(name = "SerieBomba")
    @JsonProperty("SerieBomba")
    private String SerieBomba;

    @Column(name = "OdometroCarga")
    @JsonProperty("OdometroCarga")
    private Double OdometroCarga;

    @Column(name = "FotoOdometro")
    @JsonProperty("FotoOdometro")
    private String FotoOdometro;

    @Column(name = "RendimientoECM")
    @JsonProperty("RendimientoECM")
    private double RendimientoECM;

    @Column(name = "RecorridoECM")
    @JsonProperty("RecorridoECM")
    private Double RecorridoECM;

    @Column(name = "LitrosECM")
    @JsonProperty("LitrosECM")
    private double LitrosECM;

    @Column(name = "Sellos")
    @JsonProperty("Sellos")
    private String Sellos;

    @Column(name = "FotoSello")
    @JsonProperty("FotoSello")
    private String FotoSello;

    @Column(name = "Firma")
    @JsonProperty("Firma")
    private String Firma;

    @Column(name = "ChoferID")
    @JsonProperty("ChoferID")
    private Integer ChoferID;

    @Column(name = "UsuarioID")
    // @JsonProperty("UsuarioID")
    private Integer usuarioID;

    @Column(name = "esChofer")
    @JsonProperty("esChofer")
    private Integer esChofer;

    @Transient
    private String fechaString;

    @Column(name = "Fecha")
    // Especificamos el formato en que jackson recibira la fecha
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("Fecha")
    private LocalDate Fecha;

    @Column(name = "Hora")
    @JsonProperty("HoraTransformada")
    private String Hora;

    @Column(name = "AjusteOdometro")
    @JsonProperty("AjusteOdometro")
    private Integer ajusteOdometro;

    @Column(name = "RendimientoCarga")
    @JsonProperty("RendimientoCarga")
    private Double rendimientoCarga;

    @Column(name = "RendimientoRutas")
    @JsonProperty("RendimientoRutas")
    private Double rendimientoRutas;

    @Column(name = "RecorridoCarga")
    @JsonProperty("RecorridoCarga")
    private Double recorridoCarga;

    @Transient
    @JsonProperty("tickets")
    private List<String> tickets;

    // Datos mapeados de la base de datos pero no utilizados en la insercion de
    // cargaId

    /*
     * @Column(name = "Status")
     * private Integer status;
     * 
     * @Column(name = "FacturaID")
     * private Integer FacturaID;
     * 
     * @Column(name = "CantidadActual")
     * private Double cantidadActual;
     * 
     * @Column(name = "MetodoPago")
     * private Integer MetodoPago;
     * 
     * @Column(name = "FromWS")
     * private Integer fromWS;
     * 
     * @Column(name = "RecorridoRutas")
     * private Double recorridoRutas;
     * 
     * @Column(name = "OdometroAjustado")
     * private Double odometroAjustado;
     * 
     * @Column(name = "UsuarioAjuste")
     * private String usuarioAjuste;
     * 
     * @Column(name = "FechaAjuste")
     * private String fechaAjuste;
     * 
     * @Column(name = "MotivoAjuste")
     * private String motivoAjuste;
     * 
     * // revisar si no hace referencia a otra tabla
     * 
     * @OneToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "EstadoID", referencedColumnName = "EstadoID")
     * private Estado estado;
     * 
     * @Column(name = "OdometroECM")
     * private Double odometroECM;
     */
}
